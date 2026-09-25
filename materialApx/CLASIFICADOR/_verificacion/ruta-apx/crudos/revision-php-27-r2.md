# Revisión 2 (independiente) de `27_ruta_estudio_apx.php`, contra Moodle 4.5.12

**Revisado:** `moodle/build/27_ruta_estudio_apx.php` (569 líneas, versión parcheada) y `27_ruta_estudio_apx.json`. Comparé con `27_antes_parches.php` (`diff`). Leí la revisión 1 **después** de terminar esta.

**Código de referencia:** v4.5.12 en `scratchpad/moodle45/v4512/`. Descargué además, de la misma etiqueta: `lib/accesslib.php`, `lib/grade/grade_category.php`, `lib/grade/grade_object.php`, `course/format/classes/{base,sectiondelegate,sectiondelegatemodule,formatactions}.php`, `course/format/classes/local/{cmactions,baseactions}.php`, `mod/subsection/classes/*`, `mod/quiz/classes/question/bank/qbank_helper.php`, `mod/url/locallib.php` y `mod/resource/*`.

**`php -l`:** pasado con `docker run --rm -v …:/w php:8.2-cli php -l /w/27_ruta_estudio_apx.php`, que dio **«No syntax errors detected»**. Tuve que arrancar Docker Desktop para ello y lo volví a cerrar al terminar; la imagen `php:8.2-cli` (734 MB) queda descargada.

## Resumen

| Gravedad | Nº |
|---|---|
| Alta | 0 |
| Media | 1 |
| Baja | 8 |

Ningún hallazgo impide ejecutar. Todas las llamadas existen en 4.5.12 con la firma usada, el dry-run no escribe, y el peso 0 y la restauración final de visibilidad funcionan. La media (M1) es que **la protección de «construir oculto» es más débil de lo que dice el script**. La revisión 1 partía de una premisa falsa en ese punto.

---

## MEDIA

### M1. L184 y L320 (más L151 y L30-31): las actividades creadas en la sección oculta quedan `visible=1` y **los alumnos sí tienen acceso a ellas** mientras se construye o si el script se corta

**Qué hace Moodle:**
- `add_moduleinfo` (`course/modlib.php:67-68`) escribe `visible = visibleold = $moduleinfo->visible`, aquí `1`.
- `course_add_cm_to_section` (`course/lib.php:553-586`) **no** mira la visibilidad de la sección.
- `subsection_add_instance` (`mod/subsection/lib.php:79-86`) crea la sección delegada con `'visible' => $moduleinstance->visible`, es decir `1`.
- La interfaz evita esto con `prepare_new_moduleinfo_data` (`modlib.php:889`, `$data->visible = $cw->visible`), y `moveto_module` también (`course/lib.php:1318-1323`: oculta y deja `visibleold=1`). El script no pasa por ninguno de los dos.

**Por qué los alumnos acceden:** `cm_info::update_user_visible()` (`lib/modinfolib.php:2623-2665`) solo mira `cm->visible` y la *disponibilidad*. La comprobación de la sección padre (`modinfolib.php:2524-2533`) usa `get_available()`, que trata las restricciones y no la visibilidad. Por tanto, un módulo `visible=1` dentro de una sección oculta tiene `uservisible = true` para un alumno.

- Moodle da por hecho el invariante «sección oculta ⇒ sus módulos con `visible=0`». El script lo rompe.
- La afirmación de la revisión 1 (M3.2), «las actividades se crean con visible=1 dentro de una sección oculta, así que los alumnos no las ven (uservisible=false)», es **falsa**.

**Qué ven realmente los alumnos durante la ventana de construcción** (o indefinidamente, si el script muere entre L149 y L451):
- **Página del curso e índice:** no ven la sección. Esto sí queda protegido.
- **Acceso directo:** `…/mod/quiz/view.php?id=N` funciona, porque `require_login` solo exige `$cm->uservisible`.
- **Calificaciones:** el informe de usuario muestra los 11 cuestionarios. `quiz_grade_item_update` los crea con `hidden = !$quiz->visible = 0` (`mod/quiz/lib.php:720-730`).
- **Progreso de finalización del curso:** cuenta las actividades nuevas, porque `uservisible` es true.

Riesgo real bajo: los alumnos no conocen los cmid y la ventana es de minutos. Pero la cabecera (L30-31, L151: «si algo falla a mitad, los alumnos no ven nada a medias») promete más de lo que se cumple.

**Lo que sí funciona: la restauración final (L450-454).** Con el código actual, `course_update_section($course, $sec, ['visible' => 1])` llega a `sectionactions::transfer_visibility_to_cms()` (`sectionactions.php:400-450`), que para cada subsección de la secuencia llama a `set_coursemodule_visible($id, $cm->visibleold=1)`. Como ya están a `visible=1`, `cmactions::set_visibility` (`cmactions.php:152-154`) retorna sin cambios. **El estado final es correcto:** subsecciones, secciones delegadas y actividades quedan todas visibles. Solo falla la protección intermedia.

**Parche** (replica lo que hace `moveto_module` al meter un módulo en una sección oculta; **no probado**):

```php
// L184 (subsecciones): en $mi
    'section' => (int)$sec->section, 'visible' => (int)$sec->visible, 'visibleoncoursepage' => 1, ...
// tras L187 ($sub = buscar_subseccion(...)):
    if (!$sec->visible) { $DB->set_field('course_modules', 'visibleold', 1, ['id' => $sub->cmid]); }

// L320 (actividades): en $mi
    'visible' => (int)$sec->visible, 'visibleoncoursepage' => 1, ...
// tras L356 ($mi = add_moduleinfo(...)):
    if (!$sec->visible) { $DB->set_field('course_modules', 'visibleold', 1, ['id' => $mi->coursemodule]); }
```

**Qué pasa al mostrar la sección con este parche** (recorrido por el código de 4.5.12):
1. `transfer_visibility_to_cms(padre, true)` llama a `set_coursemodule_visible(subsección, visibleold=1)`.
2. `cmactions::set_visibility` pone el módulo a `visible=1` y llama a `update_delegated($cm, ['visible'=>1,'visibleold'=>1])`.
3. Eso ejecuta `sectionactions::update(sección delegada)`, que pone la sección delegada a `visible=1`, y como antes era 0 llama a `transfer_visibility_to_cms(delegada, true)`.
4. Esa llamada pone cada actividad a `set_coursemodule_visible(cm, visibleold=1)`.
5. En los cuestionarios, `set_visibility` llama a `quiz_grade_item_update`, que vuelve a poner el elemento de calificación a `hidden=0`.

La columna `visibleold` no existe en `course_sections`, y `update_record` la descarta. Es la ruta del propio core.

**Alternativa sin tocar código:** aceptar la ventana y corregir la cabecera (L30-31, L151) para que diga «la sección no se ve en la página del curso; las actividades son accesibles por enlace directo hasta que termine».

---

## BAJA

### B1. L450-454 frente a L147 y L457-568: la sección se muestra **antes** de verificar y aunque la verificación falle
- El mensaje de L147 dice «se mostrará al terminar si todo cuadra», pero L450 la muestra siempre, antes del paso 9.
- Si la verificación encuentra fallos (L568 `cli_error`), los alumnos ya la tienen visible.
- `$recien` (L145/L155) se asigna pero no se usa.

**Parche:**
1. Mover el bloque L450-454 a justo antes de «Quién lo ve, por rol» (L540).
2. Condicionarlo a que no haya fallos de contenido.
3. La comprobación por rol va después porque, con el parche de M1, los módulos tienen `visible=0` hasta que se muestra la sección.

```php
// tras L539 (fin de la verificación de archivos/contenido), en lugar de L450-454:
if ($fallos) {
    cli_writeln('[!] La sección se deja ' . ($sec->visible ? 'como estaba' : 'OCULTA') . ' por los fallos de contenido');
} else if (!$sec->visible) {
    course_update_section($course, $sec, ['visible' => 1]);
    rebuild_course_cache($COURSEID, true);
    $sec = $DB->get_record('course_sections', ['id' => $sec->id], '*', MUST_EXIST);
    cli_writeln('[~] sección visible para los alumnos');
}
// y L513 (`if (!$sec->visible) $fallos[] = ...`) justo después de este bloque.
```

### B2. L391-392: `remove_slot` en bucle con la misma instancia de `structure` genera *warnings* de PHP a partir de la 2.ª iteración
`structure::remove_slot()` (`structure.php:1063-1120`) solo reindexa `slotsinorder` en el bucle `for ($i = $slot->slot + 1; $i <= $maxslot; …)`.
1. Al quitar siempre el **último** hueco (orden inverso), ese bucle no se ejecuta y `slotsinorder[$N]` queda obsoleto.
2. Justo después, `unset_question()` borra su pregunta de `$this->questions`.
3. En la siguiente llamada, `populate_question_numbers()` (`structure.php:791-806`) recorre la entrada obsoleta, `$this->questions[$slot->questionid]` no existe, y salen `Warning: Undefined array key …` y `Attempt to read property "length" on null`.

**Efectos:**
- No es fatal: `default_error_handler` no convierte los *warnings*. En la BD se borra bien, porque cada vuelta relee `quiz_slots`.
- Solo ocurre en re-ejecuciones con cuestionarios sin intentos que difieren del plan. En la primera corrida `$slots` está vacío.
- Ensucia la salida.
- La revisión 1 («remove_slot funciona de la última a la primera») acierta en el resultado pero no vio los *warnings*.

**Parche** (una estructura fresca por hueco, como hace la interfaz, que quita uno por petición):

```php
foreach (array_reverse($slots) as $s) {
    structure::create_for_quiz(quiz_settings::create($quiz->id))->remove_slot((int)$s->slot);
}
```

La L394 ya crea una estructura nueva para `add_random_questions`, y eso está bien.

### B3. L319-334: sin `cmidnumber`, `edit_module_post_actions` emite un *warning* por cada cuestionario
`course/modlib.php:253` hace `$item->idnumber != $moduleinfo->cmidnumber`, y se ejecuta solo con módulos que tienen elemento de calificación, es decir, los 11 cuestionarios. Da `Warning: Undefined property: stdClass::$cmidnumber`. Es inocuo (con `null != null` no hay actualización) y el 26 tenía lo mismo.

**Parche:** añadir `'cmidnumber' => ''` en L320-321.
- No cambia nada, porque `null != ''` es falso.
- `quiz_grade_item_update` (`lib.php:673-677`) usará entonces `idnumber=''` en el elemento de calificación, igual que la interfaz.

### B4. L134: la decisión del libro de calificaciones es implícita y no se valida
- El JSON **no tiene** clave `libro`, así que se aplica el valor por defecto `'fuera_del_total'`.
- Cualquier errata (`'fuera'`, `'Cuenta'`) se trata en silencio como `'cuenta'`, y el cuestionario sumaría al total.

**Parche:**
1. Poner `"libro": "fuera_del_total"` explícito en el JSON (lo genera `27_generar_plan.py`), para que conste la decisión del instructor.
2. Tras L134:

```php
if (!in_array($LIBRO, ['fuera_del_total', 'cuenta'], true)) { cli_error("ABORTA: libro='{$LIBRO}' no válido"); }
```

### B5. L121-132: la comprobación previa no cubre «TODAS» las llamadas que se ejecutan solo con `--aplicar`, como dicen L29-30 y L121-122
Todas existen en 4.5.12 (lo comprobé con grep), así que el riesgo real es nulo. Solo es inexacta la afirmación.

**Faltan tras la salida del dry-run:**
- `quiz_settings::get_grade_calculator` (L404);
- `grade_item::update` (L409);
- la constante `\core_question\local\bank\condition::JOINTYPE_DEFAULT` (L396), cuya ausencia sería un *Error* fatal;
- `get_role_users` (L544).

**Faltan antes de la salida pero solo en ramas `if ($aplicar)`,** que el dry-run tampoco ejerce:
- `add_moduleinfo`;
- `question_type::save_question`;
- `file_get_unused_draft_itemid`;
- `make_unique_id_code`;
- la constante `question_version_status::QUESTION_STATUS_READY` (L228).

**Parche:**

```php
foreach (['add_moduleinfo', 'file_get_unused_draft_itemid', 'make_unique_id_code', 'get_role_users'] as $fn) { if (!function_exists($fn)) { cli_error("ABORTA: falta la función {$fn}"); } }
foreach ([[quiz_settings::class, 'get_grade_calculator'], [\grade_item::class, 'update'], [\qtype_multichoice::class, 'save_question']] as [$c, $m]) { if (!method_exists($c, $m)) { cli_error("ABORTA: falta {$c}::{$m}"); } }
foreach (['\core_question\local\bank\condition::JOINTYPE_DEFAULT', '\core_question\local\bank\question_version_status::QUESTION_STATUS_READY'] as $k) { if (!defined($k)) { cli_error("ABORTA: falta {$k}"); } }
```

`qtype_multichoice` está cargada por `question_bank::get_qtype`, en L247. Hay que mover la línea detrás de ella o usar `get_class($mc)`.

### B6. L152: una sección oculta puede verse como «No disponible» según el formato
`core_courseformat\base::is_section_visible()` (`base.php:1608-1624`) muestra las secciones ocultas como no disponibles, con su título, si el curso tiene `hiddensections = 0`. Es solo cosmético: no se ven los módulos. Comprobar en el servidor `course_get_format(7)->get_course()->hiddensections`. Si es 0, los alumnos verán el título «Ruta de estudio APX» atenuado durante la construcción.

### B7. L163-172: `buscar_subseccion` no filtra `cm.deletioninprogress = 0`
Si alguien borra a mano una subsección con la papelera asíncrona y el script se relanza durante el borrado, puede encontrar dos filas. `get_record_sql` avisa y devuelve la primera, que quizá es la que se está borrando. `buscar_por_marca` (L284) sí filtra. **Parche:** añadir `AND cm.deletioninprogress = 0` en L169.

### B8. L135: en teoría el dry-run podría escribir
`grade_category::fetch_course_category()` (`grade_category.php:2496-2512`) **crea** la categoría raíz del libro si no existe. En el curso 7 existe, porque el 26 creó cuestionarios con elemento de calificación, así que no escribirá. Lo apunto porque el script dice que el dry-run no escribe «NADA».

**Parche opcional:** en el dry-run, sustituirla por `grade_category::fetch(['courseid' => $COURSEID, 'parent' => null])` y abortar si devuelve `false`.

---

## Estado de los hallazgos de la revisión 1

| Hallazgo | Estado | Comprobación |
|---|---|---|
| **A1** `recompute_quiz_sum_grades` | ✅ Resuelto | L404 `recompute_quiz_sumgrades()` existe en `grade_calculator.php:93`, y se comprueba en el dry-run (L127). |
| **M1** simulacro en 1 página | ✅ Resuelto | L403 `quiz_repaginate_questions($quiz->id, 5)` tras cualquier cambio. La verificación de páginas (L501, L509) lo confirma. |
| **M2** falta `gradelib` | ✅ Resuelto | L48. |
| **M3.1** comprobación previa | ✅ Hecho, aunque incompleto frente a lo que dice | Ver B5 (sin riesgo real). |
| **M3.2** construir oculto | ⚠ Parcial | Se implementó, pero la premisa («uservisible=false») es falsa: ver **M1**. La restauración final sí es correcta. Además la sección se muestra antes de verificar: ver B1. |
| **M4** preguntas en cuestionarios con intentos | ✅ Resuelto | L387-388: con intentos no se toca y solo se informa. La verificación marcará el fallo. |
| **M5** libro de calificaciones | ✅ Resuelto técnicamente | Peso 0 con `weightoverride=1`, `aggregationcoef2=0` y aborto si la agregación no es natural (ver comprobaciones). Decisión implícita: ver B4. |
| **B1** clave `'cat'` | ✅ Resuelto | L397. |
| **B2** `quiz_delete_previews` | ✅ Resuelto | L390, dentro de la rama que modifica. |
| **B3** validaciones del plan | ✅ Resuelto | L111-118. |
| **B4** pregunta en otra etapa | ✅ Resuelto | L250-255: busca en las hijas directas de `rutaapx` y aborta. Correcto también en dry-run con la categoría de la etapa aún sin crear (`!$cat`). |
| **B5** verificación más completa | ✅ Resuelto | L488-509: orden e identidad, `question_set_references` del simulacro, `grademax`, `gradetype`, peso, `completiongradeitemnumber`, DURING y páginas. |
| **B6** abortos tras escribir | ➖ Sin cambios (aceptable) | Siguen siendo los mismos que en el dry-run. Mitigación: dry-run justo antes. |
| **B7** finalización del curso | ✅ Resuelto | L133. |
| **B8** número de sección | ℹ Informativo | Confirmado: `calculate_positions` (`sectionactions.php:92-113`) y la predicción de L158-159 usan la misma fórmula. |
| **B9** `$GLOBALS['COURSEID']` | ✅ Resuelto | L221 y L223. |

**Errores nuevos introducidos por los parches:** ninguno que rompa la ejecución.
- La sintaxis se revisó con `php -l` 8.2.
- Los nombres de función y método se comprobaron uno a uno.
- Del parche del paso 7 y de la sección oculta salen M1 (premisa), B1 (orden mostrar/verificar y mensaje de L147) y B5 (afirmación de «todas»).
- B2 ya existía antes de los parches.

---

## Comprobado sin objeción

**1. Existencia y firma en 4.5.12** (grep en la etiqueta):
- **Funciones del core:**
  - `quiz_add_quiz_question($questionid, $quiz, $page = 0, $maxmark = null)` (`locallib.php:1710`);
  - `quiz_repaginate_questions($quizid, $slotsperpage)` (`:515`);
  - `quiz_delete_previews($quiz, $userid = null)` (`:487`);
  - `question_get_top_category($contextid, $create = false)` (`questionlib.php:1206`);
  - `course_create_section($courseorid, $position = 0, $skipcheck = false)` (`course/lib.php:517`);
  - `course_update_section($courseorid, $section, $data)` (`:1170`), que acepta array u objeto;
  - `moveto_module($mod, $section, $beforemod = null)` (`:1302`);
  - `rebuild_course_cache(int, bool, bool)` (`modinfolib.php:2992`);
  - `get_fast_modinfo` (`:2783`);
  - `add_moduleinfo($moduleinfo, $course, $mform = null)` (`modlib.php:49`);
  - `get_role_users($roleid, context, $parent, $fields, $sort, …)` (`accesslib.php:4062`), que con un solo `roleid` y `'u.id'` no avisa;
  - `file_get_unused_draft_itemid`, `make_unique_id_code`, `display_size`, `get_file_storage` y `get_config`.
- **Métodos y clases:**
  - `structure::create_for_quiz($quizobj)` (`:99`), `remove_slot($slotnumber)` (`:1063`) y `add_random_questions(int, int, array)` (`:1685`);
  - `quiz_settings::create(int, ?int)` (`:116`) y `get_grade_calculator()` (`:398`);
  - `grade_calculator::recompute_quiz_sumgrades()` (`:93`);
  - `category_manager::get_max_sortorder(int)` (`:372`), sin constructor ni `strict_types`, así que el id en cadena se convierte;
  - `grade_item::fetch` y `update($source, $isbulkupdate)`;
  - `grade_category::fetch_course_category`.
- **Constantes:** `QUIZ_GRADEHIGHEST`, `QUIZ_NAVMETHOD_FREE`, `RESOURCELIB_DISPLAY_OPEN/NEW`, `COMPLETION_TRACKING_AUTOMATIC`, `GRADE_AGGREGATE_SUM = 13`, `GRADE_TYPE_VALUE`, `condition::JOINTYPE_DEFAULT` y `question_version_status::QUESTION_STATUS_READY`.

**2. Sección y subsecciones:**
- `course_create_section($course, 0)` la pone en «última no delegada + 1» y desplaza las delegadas.
- `course_update_section(…, 'visible' => 0)` sobre la sección vacía no hace nada con los módulos (`transfer_visibility_to_cms` retorna si `sequence` está vacío).
- El `$course` con `cacherev` antiguo no da un `modinfo` obsoleto, gracias a `course_modinfo::$mincacherevs` (`modinfolib.php:585-593`) y `clear_instance_cache` en `rebuild_course_cache`.
- `mover()` dentro de la misma sección no toca la visibilidad (`moveto_module` solo lo hace si `$mod->section != $section->id`).

**3. Peso 0 en el libro (agregación natural):** funciona y no hace falta forzar un recálculo.
- `grade_item::update()` detecta el cambio de `weightoverride` o `aggregationcoef2` (`grade_item.php:363-372`) y llama a `force_regrading()`. El libro recalcula al abrirse (`grade_regrade_final_grades_if_required`).
- En el recálculo, `auto_update_weights()` no toca los elementos con `weightoverride` (`grade_category.php:1742` en adelante) y no suma su `grademax` al total (`:1665-1667`).
- `auto_update_max()` salta los elementos con `aggregationcoef2 <= 0` (`:1566-1572`).
- `aggregate_values_and_adjust_bounds` les da peso 0 (`:1359-1362`).
- El máximo del total del curso no sube y la nota del curso no cambia.
- **No se revierte:** `quiz_grade_item_update` llama a `grade_update`, cuya lista blanca es `itemname, idnumber, gradetype, grademax, grademin, scaleid, multfactor, plusfactor, deleted, hidden` (`gradelib.php:69`). Solo lo revertiría `set_aggregation_fields_for_aggregation`, que se ejecuta al cambiar la agregación de la categoría o al mover el elemento a otra categoría (`grade_item.php:1581`, `grade_category.php:2597`), y de SUM a SUM con peso sobrescrito no hace nada (`:1616`). `edit_module_post_actions` no lo ejecuta porque `$moduleinfo->add` está vacío.
- El paso es idempotente (L408).
- Si se quiere el total recalculado sin esperar a que alguien abra el libro: `grade_regrade_final_grades($COURSEID);` tras el bucle del paso 7. Es opcional.

**4. Cuestionarios:**
- Campos de `quiz_add_instance` y `quiz_process_options`: `quizpassword` pasa a `password`; las revisiones se agregan con `quiz_review_option_form_to_db`, y DURING vale `0x10000` (`display_options.php:40`).
- `gradepass=7` lo guarda `edit_module_post_actions` (`modlib.php:283-295`).
- `completiongradeitemnumber=0` lo pone `set_moduleinfo_defaults` (`:466-474`).
- Las páginas de las preguntas fijas se respetan con `questionsperpage=5` y además se repagina.

**5. Verificación del paso 9:**
- `question_set_references.filtercondition` en 4.5.12 es el `json_encode` literal del array que se pasa (`slot_random.php:150-152, 214`), con `usingcontextid` = contexto del módulo. `['filter']['category']['values'][0]` y `['filteroptions']['includesubcategories']` son las rutas correctas.
- `reviewrightanswer & 0x10000` es DURING (correcto para `immediatefeedback`). DURING no se retira de `reviewgeneralfeedback` (solo de `overallfeedback`, `lib.php:1054`).
- `MAX(page)` con `get_field` funciona.
- `sumgrades` se relee después del recálculo.

**6. `save_question`, nuevas y versiones:** coincido con la revisión 1.
- Con las fracciones del plan no se lanza `noticeyesno`: 26 preguntas múltiples, `round(…, 2) == 1`.
- La tolerancia de L103 (0,001) es más estricta que la de Moodle.

**7. El dry-run no escribe:**
- Todas las escrituras (`course_create_section`, `course_update_section`, `add_moduleinfo`, `insert_record`, `save_question`, `create_file_from_pathname`) están dentro de `if ($aplicar)` o después de `exit(0)` (L366).
- `question_get_top_category(…, false)`.
- `set_user` y `context_*::instance` no escriben, porque los contextos existen.
- Única salvedad: B8.

**8. Plan JSON:**
- 56 claves únicas.
- 168 preguntas, todas usadas una sola vez.
- Todos los `{{cm:…}}` resuelven.
- Ninguna opción vacía.
- URLs `https://…` que `url_fix_submitted_url` no altera, así que la comparación de L531 es estable.
- Nombres de 255 caracteres o menos.
