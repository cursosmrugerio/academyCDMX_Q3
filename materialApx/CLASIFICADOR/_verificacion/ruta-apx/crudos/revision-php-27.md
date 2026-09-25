# Revisión del script de la Ruta de estudio APX (Moodle 4.5.12)

**Archivos revisados:** `moodle/build/27_ruta_estudio_apx.php` (490 líneas) y `27_ruta_estudio_apx.json`. Se renombraron desde `26_…` a mitad de la revisión; el contenido y los números de línea son los mismos.

**Código de Moodle contrastado:** etiqueta **v4.5.12**, descargada en `scratchpad/moodle45/v4512/`. La copia previa de `moodle45/` es 4.5.14+; en lo revisado no hay diferencias relevantes.

**`php -l`:** no se pudo pasar. No hay PHP en local y Docker no arranca. Revisé la sintaxis a mano línea por línea: los ternarios anidados de L266-267 llevan paréntesis, los paréntesis de L332-334, L350 y L361 están balanceados, y el `foreach` con `[$tabla, $campo, $html]` es válido. No encontré errores de sintaxis. **Pasad `sudo -u www-data php -l /tmp/27_ruta_estudio_apx.php` en el servidor antes del dry-run.** Ojo: `php -l` **no** detecta el fallo A1, que solo aparece al ejecutar.

## Resumen

| Gravedad | Nº |
|---|---|
| Alta | 1 |
| Media | 5 |
| Baja | 9 |

---

## ALTA

### A1. L357: el método `recompute_quiz_sum_grades()` no existe y la ejecución muere a mitad, dejando el curso a medias y visible

```php
$settings->get_grade_calculator()->recompute_quiz_sum_grades();
```

**Por qué falla:** en 4.5.12, `mod/quiz/classes/grade_calculator.php:93` se llama

```php
public function recompute_quiz_sumgrades(): void {
```

No hay alias en `deprecatedlib.php` ni `__call`; lo comprobé con `grep -rn recompute_quiz_sum_grades mod/quiz/`, que no devuelve nada. El script 26 (Accenture), que sí se aplicó en el servidor, usa `recompute_quiz_sumgrades()` (L192 y L209).

**Qué pasa si se ejecuta así:**
- Se produce `Error: Call to undefined method mod_quiz\grade_calculator::recompute_quiz_sum_grades()` en el paso 7, en la **primera** vuelta. Ya se habrán hecho todas estas escrituras:
  - la sección y las 14 subsecciones;
  - las categorías y las 168 preguntas;
  - las 56 actividades, todas `visible=1`;
  - los 26 huecos de `quiz-e01`.
- El paso 8 no llega a ejecutarse. Los 11 alumnos verían:
  - 10 cuestionarios vacíos;
  - `quiz-e01` con `sumgrades=0`;
  - etiquetas con `{{cm:…}}` sin resolver;
  - la página con el texto «(se completa en esta misma corrida)».
- El dry-run **no puede detectarlo** porque sale en L316, antes del paso 7.
- Se recupera volviendo a ejecutar el script ya corregido, porque es idempotente. Aun así, es un estado roto a la vista de los alumnos.

**Parche:**

```php
$settings->get_grade_calculator()->recompute_quiz_sumgrades();
```

Para mitigar el riesgo de fondo, ver M3.

---

## MEDIA

### M1. L332: las 40 preguntas del simulacro caen todas en la página 1 y se ignora `por_pagina: 5`

`structure::add_random_questions(1, 40, …)` crea cada hueco con `slot_random::insert($page)`. En `mod/quiz/classes/local/structure/slot_random.php:180-192`:

```php
if (is_int($page) && $page >= 1) {
    ...
    $this->record->page = min($page, $maxpage + 1);
```

Con `$page = 1`, los 40 huecos van a la página 1 y no se aplica `questionsperpage`. El script 26 lo resolvía con `quiz_repaginate_questions($quiz->id, $POR_PAG)` (L208). Este script no lo hace, y el alumno ve 40 preguntas en una sola página.

**Parche** (L332-335):

```php
$struct->add_random_questions(1, (int)$it['aleatorias']['n'], ['filter' => ['category' => [
    'jointype' => \core_question\local\bank\condition::JOINTYPE_DEFAULT, 'values' => [(int)$catpadre->id],
    'filteroptions' => ['includesubcategories' => true]]],
    'cat' => "{$catpadre->id},{$ctxc->id}"]);            // B1: igual que core y que el 26
quiz_repaginate_questions($quiz->id, (int)$it['por_pagina']);
```

La otra opción es pasar `0` como `$addonpage`: la rama `else` de `insert()` sí respeta `$quiz->questionsperpage`. Aun así prefiero repaginar, porque ya funcionó en el 26.

### M2. L428: `grade_item::fetch` sin `require_once gradelib`, con error fatal en una re-ejecución que no crea nada

El script no carga `lib/gradelib.php`, y `grade_item` no se carga automáticamente: es una clase heredada en `lib/grade/grade_item.php` y no aparece en `core_component`.

- En la primera ejecución sí queda cargada, porque `add_moduleinfo → edit_module_post_actions` hace `require_once($CFG->libdir.'/gradelib.php')` (`course/modlib.php:232`).
- En una re-ejecución idempotente en la que todo existe, no se llama a `add_moduleinfo`. Ninguna otra inclusión la carga: lo comprobé en `mod/quiz/lib.php`, `locallib.php`, `completionlib.php`, `questionlib.php`, `calendar/lib.php` y `question/editlib.php`.
- Resultado: `Class "grade_item" not found` en la verificación, sin ledger. El script 26 lo carga explícitamente en su L29.

**Parche** (tras L38):

```php
require_once($CFG->libdir . '/gradelib.php');
```

### M3. Si falla a mitad, el curso queda a medias y visible; el dry-run no prueba las APIs que se usan tras la salida

Todo lo que va después de L316 no se ejerce en el dry-run: `quiz_add_quiz_question`, `add_random_questions`, `remove_slot`, `recompute_…`, `grade_item`… Por eso A1 y M2 habrían pasado un dry-run limpio.

Tampoco hay transacción global. Los fallos posibles a mitad de ejecución son:
- A1;
- una excepción de `save_question` (por ejemplo `notenoughanswers`);
- una caída de la base de datos o del proceso.

Cualquiera de ellos deja visibles para los 11 alumnos elementos incompletos. Mitigaciones, de menor a mayor esfuerzo:

1. **Comprobación previa en el dry-run.** Añadirla justo después del paso 2, antes de cualquier escritura:

   ```php
   foreach (['quiz_add_quiz_question', 'quiz_repaginate_questions', 'quiz_delete_previews', 'question_get_top_category',
             'course_create_section', 'course_update_section', 'moveto_module'] as $fn) {
       if (!function_exists($fn)) { cli_error("ABORTA: falta la función {$fn}"); }
   }
   foreach ([[\mod_quiz\grade_calculator::class, 'recompute_quiz_sumgrades'], [structure::class, 'add_random_questions'],
             [structure::class, 'remove_slot'], [\core_question\category_manager::class, 'get_max_sortorder'],
             [\grade_item::class, 'fetch']] as [$c, $m]) {
       if (!method_exists($c, $m)) { cli_error("ABORTA: falta {$c}::{$m}"); }
   }
   if (empty($course->enablecompletion)) { cli_error('ABORTA: el curso no tiene la finalización activada'); }   // B7
   ```

2. **Construir con la sección oculta y mostrarla al final.** No lo he probado. Al crear la sección (L111) se pasa `'visible' => 0`; como la sección está vacía, `transfer_visibility_to_cms` no hace nada. Las actividades se crean con `visible=1` dentro de una sección oculta, así que los alumnos no las ven (`uservisible=false`). Al final del paso 8, antes de la verificación por rol:

   ```php
   // L108-114: 'visible' => 0 en course_update_section SOLO al crearla (y $recienCreada = true)
   // tras L395:
   if (!empty($recienCreada)) {
       $sec = $DB->get_record('course_sections', ['id' => $sec->id], '*', MUST_EXIST);
       course_update_section($course, $sec, ['visible' => 1]);   // restaura visibleold (=1) de las subsecciones
       rebuild_course_cache($COURSEID, true);
   }
   ```

   Si el script muere antes, los alumnos no ven nada. Una re-ejecución encuentra la sección oculta existente; para ese caso, lo más simple es mostrarla si está oculta y todo lo demás cuadra.

3. **Mínimo imprescindible, sin tocar código:** respaldo previo, corregir A1 y M2, y, si algo falla, **re-ejecutar de inmediato**. El script es idempotente, y lo comprobé punto por punto:
   - marcadores;
   - subsecciones por nombre dentro del padre;
   - preguntas por idnumber y hash;
   - huecos comparados con el plan;
   - contenido comparado.

### M4. L349-353: añade preguntas a cuestionarios que ya tienen intentos, algo que Moodle prohíbe expresamente

`structure::check_can_be_edited()` (`structure.php:407`) lanza `cannoteditafterattempts` en cuanto hay intentos. El script se lo salta llamando a `quiz_add_quiz_question` directamente. Consecuencias:
- Cambia `quiz.sumgrades` y, a partir de ahí, `quiz_rescale_grade()` reescala con el nuevo total.
- Las notas guardadas en `quiz_grades` no se recalculan, porque el script no llama a `recompute_all_final_grades()`.
- Los intentos anteriores no contienen la pregunta nueva.
- El estado de «aprobado» de un alumno puede cambiar o quedar incoherente con el libro de calificaciones.

En la primera ejecución no hay intentos, así que no aplica. Sí aplicaría en re-ejecuciones futuras, cuando los alumnos ya estén haciendo los cuestionarios.

**Parche:** con intentos, solo informar.

```php
} else {
    cli_writeln("[!] {$it['nombre']}: tiene {$intentos} intentos y difiere del plan; NO se toca (Moodle no permite editar un cuestionario con intentos)");
}
```

Si de verdad hay que ampliarlo, hacedlo a mano desde la interfaz, que obliga a borrar los intentos primero.

### M5. Libro de calificaciones: 11 elementos de calificación nuevos y visibles, de 10 puntos cada uno, que alteran el total del curso

Para que funcione `completionpassgrade`, el script usa `grade = 10` y `gradepass = 7`. `quiz_grade_item_update()` crea el elemento con `gradetype=VALUE`, `grademax=10` y `hidden=0`, porque `marksopen/closed = 1` (`mod/quiz/lib.php:680-718`). Con agregación natural, el máximo del total del curso sube 110 puntos, y los alumnos que no hagan los cuestionarios verán bajar su porcentaje.

El script 26 evitó esto a propósito («sin calificación (grade 0 → no crea columna en el libro)»). **Es una decisión del instructor**, no un fallo técnico. Aprobar sin nota no es posible: `completionpassgrade` necesita un elemento con `gradepass`.

**Propuesta:**
- En el dry-run, mostrar la agregación del total del curso:

  ```php
  $cc = grade_category::fetch_course_category($COURSEID);
  cli_writeln("Libro: agregación {$cc->aggregation}, " . $DB->count_records('grade_items', ['courseid' => $COURSEID]) . ' elementos');
  ```

- Si hay que excluir los cuestionarios del total, con agregación natural se hace tras crear cada uno:

  ```php
  $gi = grade_item::fetch(['itemtype' => 'mod', 'itemmodule' => 'quiz', 'iteminstance' => $quiz->id, 'courseid' => $COURSEID]);
  $gi->weightoverride = 1; $gi->aggregationcoef2 = 0; $gi->update();
  ```

  La otra vía es meterlos en una categoría de calificación propia con peso 0. Hay que confirmarlo con el instructor antes de aplicar.

---

## BAJA

**B1. L332: falta la clave `'cat'` en `filtercondition`.**
- Core la incluye (`mod/quiz/classes/external/add_random_questions.php:133-135`: `'cat' => "{$categoryid},{$thiscontext->id}"`) y el script 26 también la usaba.
- La generación aleatoria y `editrandom.php` usan `filter.category`, así que funciona sin ella.
- Se añade por paridad: el parche va incluido en M1.

**B2. L346-351: no se llama a `quiz_delete_previews($quiz)` antes de quitar o añadir huecos.**
- Core lo hace siempre antes de cambiar la estructura (`add_random_questions.php:148`; el docblock de `recompute_quiz_sumgrades` dice «You should call quiz_delete_previews() before»).
- Sin él, las vistas previas abiertas del profesor quedan inconsistentes.
- **Parche:** llamar a `quiz_delete_previews($quiz);` justo antes de L331 (dentro del `foreach`, después de L329).

**B3. Faltan validaciones previas en el paso 2, antes de escribir.** Hoy el plan cumple las tres (lo comprobé), pero si no se cumplen el script falla a mitad:
- **Al menos 2 opciones por pregunta.** Si no, `save_question_options` devuelve `notenoughanswers`, que se convierte en `moodle_exception` (`multichoice/questiontype.php:134-137` y `questiontypebase.php` `if (!empty($result->error)) throw`).
- **`categoria` existente en `categorias.etapas`.** Si no, en L223 se usa `$cat->id` sobre `null`.
- **`aleatorias.n` ≤ total de preguntas** (168 ≥ 40).

```php
$etapas = array_column($P['categorias']['etapas'], 'idnumber');
// dentro del foreach de L88:
if (count($q['opciones']) < 2) { cli_error("ABORTA: {$q['idnumber']} tiene menos de 2 opciones"); }
if (!in_array($q['categoria'], $etapas, true)) { cli_error("ABORTA: {$q['idnumber']} en categoría desconocida {$q['categoria']}"); }
// tras L100:
foreach ($items as $it) { if (isset($it['aleatorias']) && $it['aleatorias']['n'] > count($preg)) { cli_error("ABORTA: {$it['key']} pide más al azar que preguntas hay"); } }
```

**B4. L208: la búsqueda de la pregunta se hace solo en su categoría actual.**
- Si en un plan futuro una pregunta cambia de etapa, se crea otra con el mismo idnumber en la nueva categoría. La vieja queda huérfana y **aparece dos veces en el conjunto del simulacro** (`includesubcategories`).
- **Parche:** buscar el idnumber en todas las subcategorías de `rutaapx` y abortar si aparece en otra:

```php
$en = $DB->get_records_sql('SELECT qbe.id, qbe.questioncategoryid FROM {question_bank_entries} qbe
    JOIN {question_categories} qc ON qc.id = qbe.questioncategoryid WHERE qc.parent = ? AND qbe.idnumber = ?', [$catpadre->id ?? 0, $idn]);
foreach ($en as $x) { if ($cat && (int)$x->questioncategoryid !== (int)$cat->id) { cli_error("ABORTA: {$idn} existe en otra etapa (cat {$x->questioncategoryid})"); } }
```

**B5. A la verificación del paso 9 le faltan comprobaciones** (lo que ya comprueba está bien: ver la lista de comprobaciones correctas). Conviene añadir:
- `(int)$cm->completiongradeitemnumber === 0`, porque «aprobar» exige que no sea `null` (lo pone `set_moduleinfo_defaults`, `modlib.php:470-474`);
- `(float)$gi->grademax === 10.0` y `(int)$gi->gradetype === GRADE_TYPE_VALUE`;
- **el orden y la identidad** de las preguntas en los cuestionarios fijos (hoy solo se cuentan huecos): recalcular `$have === $want` como en L340-343;
- en el simulacro, que las 40 `question_set_references` apunten a `$catpadre->id` con `includesubcategories`, como hace el 26 en L245-250;
- las opciones de revisión `reviewrightanswer & 0x10000` (DURING) y `reviewgeneralfeedback & 0x10000`, que son la base de la «retroalimentación inmediata».

**B6. Algunos abortos ocurren después de escribir con `--aplicar`:**
- L256 y L259 (una actividad duplicada o fuera de su subsección);
- L158 (una categoría con otro padre).

El dry-run ejecuta las mismas comprobaciones, así que basta con **ejecutar el dry-run justo antes** de `--aplicar`, sin cambios manuales entre medias.

**B7. La finalización se ignora en silencio si el curso no la tiene activada** (`modlib.php:84`: `if ($completion->is_enabled())`). La verificación lo detectaría tarde. La comprobación previa va en M3.

**B8. Número de sección: correcto.**
- `course_create_section($course, 0)` → `sectionactions::calculate_positions()` (`sectionactions.php:101-113`) coloca la sección en `MAX(section) de las no delegadas + 1`. Si «Preguntas Java… Accenture» es la 10, la nueva es la **11**, y luego `move_section_to` desplaza las secciones delegadas (subsecciones) una posición hacia abajo.
- La predicción del dry-run (L116-117, `MAX(section) … component IS NULL + 1`) usa la misma fórmula y mostrará 11.
- Aviso: los números de sección de **todas las subsecciones existentes** (Soft Skills, etc.) suben en 1. Es inofensivo para scripts que buscan por id o por nombre, pero no para los que usen `section` num de una subsección guardada en un ledger.

**B9. `$GLOBALS['COURSEID']` en `form_pregunta` (L181).**
- Funciona, porque el script se ejecuta en el ámbito global y `$COURSEID` es global.
- Es frágil. **Parche:** pasar el id de contexto como parámetro, `form_pregunta(array $q, $catid, $ctxid)` → `$f->category = "{$catid},{$ctxid}";`, y en L215/L224 llamar a `form_pregunta($q, $cat->id, $ctxc->id)`.

---

## Comprobaciones correctas

**1. `save_question`** (`questiontypebase.php:365-560`, `multichoice/questiontype.php:118-226`):
- **Campos:** `$form` lleva todo lo que se usa: `category` como «id,ctx» (se hace `explode`), `name`, `questiontext` y `generalfeedback` como arrays, `defaultmark`, `penalty`, `idnumber`, `status`, `single`, `shuffleanswers`, `answernumbering='none'` (valor válido), `showstandardinstruction`, `shownumcorrect`, los tres `*feedback` como arrays y `answer`/`fraction`/`feedback`. Coincide con `get_multichoice_question_form_data_two_of_four` del helper de tests de 4.5.12.
- **Campos que no hacen falta:** `$form->contextid` no se necesita (el contexto sale de la categoría). `hint` tampoco: `count_hints_on_form` usa `!empty()` y no avisa. `penalty` es opcional (por defecto 0).
- **Campos que ignora la base de datos:** `contextid`, `category` e `idnumber` del objeto `$question` no son columnas de `question`, e `insert_record` las descarta.
- **Fracciones:** las negativas se guardan tal cual. En respuesta múltiple la nota se recorta a [0,1]. La validación de la suma es `round($totalfraction, 2) != 1`, que con `0.3333333×3`, `0.1428571×7` y `0.1666667×6` da 1.0, así que no hay `noticeyesno`. Recalculé las 26 preguntas de respuesta múltiple y todas cumplen. Todas las fracciones del plan están además en la lista de valores de Moodle, así que al editar la pregunta desde la interfaz no se deforman. `(string)0.3333333` da `"0.3333333"` y la columna es `NUMBER(12,7)`.
- **Versión nueva:** pasar `$question->id = $last->id` hace que `get_question_bank_entry` encuentre la entrada existente. Se inserta una `question` nueva y una `question_versions` con `get_next_version`. La validación del idnumber excluye su propia entrada (`qbe.id != :notid`). Los huecos usan `version = null`, es decir, siempre la última versión. Funciona así en 4.5.

**2. Categorías de preguntas:**
- `question_get_top_category($ctx, true)` existe (`questionlib.php:1206`).
- `\core_question\category_manager::get_max_sortorder(int)` existe en 4.5.12 (`question/classes/category_manager.php:372`).
- El `insert` directo en `question_categories` con `idnumber` es válido: la unicidad `(contextid, idnumber)` la comprueba el propio script.
- 4.5 **no** tiene `mod_qbank`, que llega en 5.0. Al actualizar a 5.0, las categorías de curso se migrarán a una instancia de qbank, y los filtros aleatorios los migra el propio proceso de actualización.

**3. Creación del cuestionario:**
- Están todos los campos NOT NULL sin valor por defecto de `quiz` (`install.xml`).
- `quizpassword` pasa a `password` y `browsersecurity='-'`.
- Las opciones de revisión `…during/immediately/open/closed` se agregan en `quiz_process_options`.
- Con `completionunlocked=1` se conservan `completionusegrade` y `completionpassgrade`, y `set_moduleinfo_defaults` pone `completiongradeitemnumber=0`.
- `gradepass=7` lo guarda `edit_module_post_actions` (`modlib.php:283-295`) en el elemento que ya creó `quiz_grade_item_update` (grademax 10).
- Es la misma receta que el script 26 aplicó en el servidor, más `grade/gradepass/completion*`.

**4. Huecos y preguntas aleatorias:**
- `quiz_add_quiz_question($id, $quiz)` con página 0 respeta `questionsperpage=5` (`locallib.php:1791-1803`) y necesita `$quiz->cmid` (L325 lo pone).
- `remove_slot($n)` funciona de la última a la primera.
- `add_random_questions(int, int, array)` exige `moodle/question:useall`, que el administrador tiene, puesto con `set_user(get_admin())`.
- Las constantes existen: `QUIZ_GRADEHIGHEST`, `QUIZ_NAVMETHOD_FREE`, `condition::JOINTYPE_DEFAULT` y `question_version_status::QUESTION_STATUS_READY`.
- Los `use mod_quiz\quiz_settings` y `use mod_quiz\structure` son válidos.

**5. El dry-run no escribe nada.**
- L168 usa `question_get_top_category(..., false)` sin `--aplicar`.
- `categoria()` devuelve antes de insertar.
- Las preguntas y actividades solo se escriben con `$aplicar`.
- Las demás llamadas solo leen: `get_admin`, `set_user`, `context_*::instance` (los contextos ya existen) y `display_size`.

**6. Campos que lee la verificación:** son los correctos: `course_modules.completionpassgrade`, `grade_items.gradepass` (vía `grade_item::fetch`, que falla sin M2), `quiz.sumgrades`, `qtype_multichoice_options.single/questionid` y `question_answers` ordenadas por id.

**7. Datos del plan:**
- 56 claves únicas.
- 168 preguntas, todas usadas una sola vez y todas con categoría válida.
- Las de respuesta única tienen exactamente una opción al 100 % y ninguna negativa.
- No hay opciones vacías ni repetidas.
- Todos los `{{cm:…}}` apuntan a claves del plan.

## Orden de aplicación recomendado

1. Corregir A1 y M2, que son de una línea cada una, y aplicar M1.
2. Decidir M5 con el instructor.
3. Aplicar M3 (al menos la comprobación previa del punto 1) y M4.
4. `php -l` en el servidor.
5. Dry-run.
6. Respaldo del curso.
7. `--aplicar` inmediatamente después del dry-run.
