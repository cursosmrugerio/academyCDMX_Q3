## Ronda 1: verificación a ciegas del índice de preguntas

No abrí `INDICE-PREGUNTAS.md` ni `indice-preguntas.tsv`. Tampoco miré los archivos de trabajo del otro agente en el scratchpad (`indice_rows.json`, `lab_*.txt`, `plan_*`, `write_index.py`…). En `materialApx` no escribí nada.

**Entregable:** `/private/tmp/claude-501/-Users-mike-ide-eclipse-eclipse-workspace-academyCdmxQ3-materialApx/8f5b0d8c-06b4-4287-a952-0d1e3c8fb856/scratchpad/vidx1/clasificacion_ronda1.tsv`. Tiene 479 filas más la cabecera, con las columnas examen, n, tema, confianza y nota. Hay 38 filas con confianza «media» o «baja», cada una con su nota.

### 1. Clasificación por examen

| Examen | APX | Java | Herr./general | Total |
|---|---|---|---|---|
| 01 - Simulación APX V1 | 9 | 23 | 13 | 45 |
| 02 - Simulación APX V2 | 15 | 19 | 11 | 45 |
| 07 - Diagnóstico APX 5 | 61 | 22 | 2 (#11, #78) | 85 |
| 01 - Quiz APX | 6 | 8 | 8 | 22 |
| 02 - Quiz Desarrollo APX 1 | 11 | 12 | 2 (#15, #19) | 25 |
| 03 - Quiz Desarrollo APX 2 | 4 | 14 | 6 | 24 |
| Examen Diagnóstico APX 4.pdf | 12 | 7 | 2 (#1, #8) | 21 |
| Java.pdf | 37 | 134 | 41 | 212 |
| **Total** | **155** | **239** | **85** | **479** |

**Preguntas con código en imagen que miré** (todas resultaron ser Java):
- **07 APX 5:** 9 de 19 (#65, 70, 72, 74, 77, 79, 81, 83, 85).
- **Quiz APX:** 4 de 6 (#4, 6, 8, 9).
- **Quiz Desarrollo 1:** 4 de 8 (#1, 4, 7, 13).
- **Quiz Desarrollo 2:** 6 de 14 (#7, 10, 13, 16, 17, 20).
- **APX 4.pdf:** las 12 páginas completas.

Las imágenes no revisadas quedan marcadas en la nota. Para esas decidí por las opciones, que son claramente Java.

### 2. Verificación de la extracción

**a) `Java.pdf`: hay 212 preguntas numeradas, pero en realidad son 213 preguntas.**
- El PDF tiene 303 páginas de texto, sin imágenes. Las cabeceras numeradas van de 1 a 212 en orden. No falta ningún número y no hay nada después de la 212 (p. 302–303).
- La #69 (p. 104) y la #85 (p. 130) están escritas sin espacio («69.¿…», «85.¿…»). Un parser estricto se las saltaría, pero la lista las tiene bien.
- No me quedé en la muestra de 25: comparé automáticamente las 212 preguntas. En todas coinciden el inicio del enunciado del TSV (60 caracteres, y 200 contenidos en el bloque) y la página indicada. Hubo 0 discrepancias.
- Además revisé a mano el texto de 2, 3, 15, 28, 29, 31, 44, 64, 66, 75, 76, 91, 96, 98, 104, 107, 108, 113, 118, 126, 132, 133, 136, 137, 191, 205 y 208–212.
- **Hallazgo 1: falta una pregunta.** Dentro del bloque #126 (p. 198, «¿Qué es ENTORNO LOCAL APX?») hay, después de su respuesta, una segunda pregunta sin número: «¿Cuál de las siguientes afirmaciones describe mejor un Step en el contexto de Spring Batch?». Tiene 4 opciones y respuesta c. No aparece como fila en la lista. Es APX (Spring Batch). No encontré más preguntas embebidas de este tipo en otros bloques.
- **Hallazgo 2:** la #75 no es de opción múltiple. Es «Resultado de la operacion 9 | 4» con la respuesta (13) ya incluida.
- **Hallazgo 3:** el enunciado de la #191 es una paráfrasis de una imagen («The image shows a multiple-choice question about java -jar…»).
- La #31 no trae respuesta en el PDF. Sí es una pregunta.

**b) `Examen Diagnóstico APX 4.pdf`: 21 preguntas reales, que coinciden con la lista.**
- Reparto: páginas 1–7, 2 preguntas cada una (14); página 8, 1 pregunta a la izquierda; página 9, 1; páginas 10–11, 2 cada una; página 12, 1.
- El panel derecho de la página 8 no es una pregunta. Es una explicación en inglés (viñetas de Validation of Exit Code / Commit Control / ROP Writing / Business Event Notification / Monitorization). La lista lo excluye correctamente: no hay ninguna fila «pág 8 der».
- No falta ninguna pregunta y no sobra ninguna fila.
- La #3 figura como «[enunciado ilegible en el OCR]», pero en la imagen se lee bien: «Selecciona las tres respuestas que describen las mejores prácticas establecidas para acceder a Datos».
- El resto de los OCR tiene ruido de caracteres, pero cada fila corresponde a su pregunta.

**c) Los demás exámenes coinciden todos con el original.**
- Las cifras son 45, 45, 85, 22, 25 y 24, y en todos la numeración «Pregunta N» es consecutiva.
- Crucé el enunciado del TSV con el docx para todas las preguntas con texto: 0 discrepancias de número.
- Contrasté también con los datos crudos de `_datos-extraccion`:
  - En Microsoft Forms, V1 y V2 tienen 46 elementos cada uno: 45 preguntas más el campo «Ingresa tu nombre completo», que se excluye bien.
  - El Google Form de APX 5 tiene 85 preguntas de opción más 2 cabeceras de sección.
  - En Educaplay hay 22, 25 y 24 preguntas.

### 3. Casos dudosos (el criterio no decide con claridad)
- **Definición genérica de «patrón de diseño»** (APX5 #11, Quiz Desarrollo 1 #19, APX4 #8): la puse en Herr./general porque es un patrón genérico. Pero está en la sección APX y el curso la enseña en el módulo de patrones APX.
- **Paginación genérica en aplicaciones web** (V2 #4, Java.pdf #69): la puse en Herr./general. El curso enseña paginación como patrón APX, pero el enunciado no lo menciona.
- **Java.pdf #173**, propósito de un DTO «en el diseño de software»: la puse en Herr./general, aunque DTO también es componente APX.
- **Java.pdf #194**, transacción con propiedades ACID: Herr./general.
- **Java.pdf #198**, CRUD: Herr./general, con confianza media.
- **Las puse en APX aunque el concepto sea genérico**, porque aplican una norma APX o están en la sección APX:
  - V2 #18 y #41, Java.pdf #98 y #147: acceso a datos encapsulado en transacción o librería.
  - APX5 #8 (variables bind), #33 (@SuppressWarnings), #36 y #38–41 (niveles de log), #59, #60 y #61 (ROWNUM).
  - V2 #16 y Java.pdf #91: herramientas para desarrollar componentes APX.
  - V2 #40: habla de «BLOB», pero la respuesta es el antipatrón Blob del curso.
- **Retrocompatibilidad**, dos tratamientos:
  - En su forma genérica (V2 #29, Java.pdf #122 y #171) la puse en Herr./general.
  - Referida a una transacción (Quiz APX #22, APX5 #50) la puse en APX.
- **pom.xml sin concepto APX** (APX4 #1, Quiz Desarrollo 1 #15): Herr./general (Maven).
- **Singleton en la sección JAVA** (APX5 #78): Herr./general (patrón genérico).

### Qué no pude verificar
- No miré 10 de las 19 imágenes de APX5, 2 de 6 del Quiz APX, 4 de 8 del Quiz Desarrollo 1 ni 8 de 14 del Quiz Desarrollo 2. Las clasifiqué por las opciones de respuesta.
- La V1 #9 no tiene código en el docx. La doy por Java por su equivalente en Java.pdf #52.
- No revisé los formularios en vivo: el recuento se apoya en los docx y en los JSON crudos.
