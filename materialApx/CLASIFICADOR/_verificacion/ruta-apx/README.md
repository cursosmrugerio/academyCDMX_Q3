# Ruta de estudio APX: cómo se construyó el banco de preguntas

Registro de trabajo del 25-sep-2026. Con él se montó la sección «Ruta de estudio APX» en Moodle
(script 27 del repo `academia-cdmx26Q3`, que lee `banco-final.json`). Es un registro interno: la
guía para el alumno es [`../../LEEME.md`](../../LEEME.md), §1.

## En Moodle

Publicado el 25-sep-2026 en el curso 7, sección «Ruta de estudio APX» (id 181, número 11):
- 14 subsecciones (cmid 668–681) y 56 actividades (cmid 682–737).
- 11 cuestionarios: 10 autoevaluaciones y el simulacro (cmid 724). Todos pesan 0 en el total del curso.
- La página «Preguntas sin respuesta confirmada» (cmid 725). Al publicarse se llamaba «Preguntas para resolver con
  el instructor»; el 25-sep se renombró porque tampoco el instructor tiene esas respuestas.
- 168 preguntas en la categoría «Ruta de estudio APX» (id 69).

El script, el plan y el ledger están en el repo `academia-cdmx26Q3`, en `moodle/build/27_*` y
`moodle/ledgers/27_*`. Las revisiones del script están en `crudos/revision-php-27*.md` y las
de las guías en `crudos/verif-ruta-r*.md`.

## Qué se hizo

1. **Corpus.**
   - Se extrajo el texto de los 33 archivos de `apx/`, página por página.
   - Los PDF sin texto seleccionable, los mapas mentales y las imágenes de las diapositivas
     pasaron por el OCR de macOS (Vision).
2. **Clave de APX 3.**
   - El resaltado amarillo de `apx/examenes/Exámen Diagnóstico APX 3 (1).pdf` está en el propio
     contenido, no en anotaciones.
   - Se detectó por color y se sacó a `APX3_clave_marcada.txt`: las líneas con «[✔]» son las
     resaltadas.
   - La herramienta está en `crudos/pdfmark.swift`.
3. **Candidatas.** `candidatas.json` reúne 369 preguntas de 13 exámenes:
   - todas las de 05, 06 y 08;
   - las de tema APX de los 8 exámenes mixtos, según `../indice-preguntas.tsv`;
   - 4 de V3 y V4.
   - No incluye `Exámen Diagnóstico APX 3 (1).pdf`, que repite 06 y se usó como clave.
   - Tampoco incluye `Exámen Diagnóstico Java.pdf`, que repite 04.
4. **Clasificación** (`crudos/clasif-lote-1..5.json`, unidos en `clasif-todas.json`).
   - La hicieron 5 agentes.
   - Por pregunta registraron: tema, etapa y concepto; la respuesta según la documentación, con
     cita y página; y la respuesta según la clave (APX 3 o `Java.pdf`).
   - **357 son de APX.**
5. **Duplicados** (`grupos-duplicados.json`).
   - Otro agente agrupó por significado las que son la misma pregunta. Cuentan también las que
     cambian de redacción, de orden de opciones o de idioma.
   - Quedaron **222 únicas**; tras la ronda 1, **223** (G215 se separó en dos).
6. **Construcción** (`banco-v1.json`).
   - 3 agentes fijaron por pregunta: enunciado y opciones, respuestas correctas, respaldo,
     destino, fuente, cita y retroalimentación.
   - **Respaldo:** «doc» si lo dice la documentación; «clave» si solo lo dice una clave;
     «ninguno»; o «contradictorio».
   - **Destino:** «cuestionario» (se califica) o «instructor» (no se califica).
7. **Verificación en dos rondas.**
   - Cada ronda la hicieron 3 agentes distintos de los constructores.
   - **Ronda 1:** `crudos/verif-r1-*.json`; lo aplicado está en `cambios-r1.md` y da `banco-v2.json`.
   - **Ronda 2:** `crudos/verif-r2-*.json`; lo aplicado está en `cambios-r2.md` y da `banco-final.json`.
   - **Ninguna ronda encontró un hallazgo de gravedad alta**, es decir, una respuesta mal marcada.
   - Las preguntas dudosas pasaron a «instructor».
   - Las instrucciones exactas de cada paso están en `crudos/instrucciones-*.md`.

## Resultado (`banco-final.json`)

| | Preguntas |
|---|---|
| Únicas de APX | 223 (de 357 apariciones en 13 exámenes) |
| En los cuestionarios de la ruta | 168: 132 con respaldo en la documentación y 36 solo en una clave |
| En «Preguntas sin respuesta confirmada» | 55: 28 sin respuesta en ningún archivo y 27 con fuentes que se contradicen o ambiguas |

## Límites

- **Las claves no están validadas.** Las 36 preguntas que respalda solo una clave llevan en
  Moodle el aviso «Respuesta tomada de la clave del examen».
- **La clave de APX 3 contradice la documentación en varias preguntas:** niveles de log, WARN,
  invocaciones restringidas de Batch y objetivo de los patrones. Esas preguntas están en la
  página del instructor.
- **Hay cosas que solo el instructor o la empresa pueden confirmar.** Por ejemplo, si existe
  `apx init du-lib` (G089) o si la «cesión de ficheros entre UUAAs» en batch es una norma
  (G109).
- **`etapas.md` usa la numeración provisional E1–E13.** La ruta final tiene 11 etapas. En la
  numeración nueva E3 y E9 se juntan en la 3, E7 se divide en la 7 y la 8, E10 y E11 se juntan
  en la 10, y E12 y E13 se juntan en la 11.
- **Los `crudos/` citan rutas del scratchpad de la sesión.** Los archivos a los que se refieren
  son los de esta carpeta.
