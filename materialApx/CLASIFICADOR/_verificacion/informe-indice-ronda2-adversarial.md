## Informe del verificador adversarial, ronda 2: INDICE-PREGUNTAS.md y indice-preguntas.tsv

No escribí nada en el repo. Los temporales están en `…/scratchpad/vidx2/`.

**Resultado general:**
- **Tema:** no encontré ninguno mal asignado.
- **Número y ubicación:** correctos en las 480 filas.
- **Fallo real en «También en»:** 14 enlaces falsos seguros (más 1 discutible) de 101, y al menos 25 omisiones claras.
- **Nota de cabecera de Java.pdf:** una afirmación es falsa.

### ERRORES CONCRETOS

**1. Java.pdf #31: la nota «la #31 no trae respuesta» es falsa.**
- Evidencia: renderizada la pág. 46, el «5000» está resaltado en verde.
- Además, la frase «cada pregunta trae la respuesta correcta y su justificación» es inexacta. Hay 30 preguntas cuya respuesta es solo ese resaltado verde, sin justificación escrita: #15, 28, 29, 31, 44, 64, 66, 76, 91, 98, 104, 113, 118, 136, 137, 144, 149, 160, 162, 164, 167, 176, 180, 182, 187, 195, 201, 203, 204 y 208.
- Comprobé el resaltado a ojo en 6 de ellas: #31, 44, 98, 136, 180 y 208 (págs. 46, 66, 161, 212, 274 y 299).
- Corrección: «Resuelto: la respuesta correcta va marcada (resaltado verde y/o ✅), casi siempre con justificación; 30 preguntas solo traen el resaltado». Quitar «la #31 no trae respuesta».

**2. «También en»: enlaces falsos.** Son preguntas distintas que el índice da por la misma. Causa probable: enunciados cortos o genéricos idénticos, comparados sin mirar las opciones.
- **01 - Quiz APX #9 ↔ 03 - Quiz Desarrollo APX 2 #7, 8, 13, 14, 15, 16, 18, 19, 20 (9 enlaces).** Todas comparten el enunciado «Dado el siguiente código ¿cuál es el resultado?».
  - QA#9 es la clase `Recursividad`, con opciones «Numerico/Default».
  - En QD2 miré las imágenes de la #13 (`Ordenamiento`), la #18 (`MultiHerencia`) y la #20 (`Prioridad`).
  - Las opciones de los 9 casos no coinciden en nada: cobertura de palabras entre 0 y 0,1.
  - Eliminar los 9.
- **Java.pdf #206 ↔ 07 #66.**
  - Las opciones de 07#66 son las de Java.pdf #192 (interface / abstract class), no las de la #206 («A class that is abstract cannot be instantiated…»).
  - Mantener la #192 y quitar la #206.
- **Java.pdf #156 (throw) ↔ V1 #43 (ArrayList)**, y **V1 #43 ↔ V2 #45 (throw)**. Temas distintos: eliminar los dos. El par correcto #156 ↔ V2#45 ya existe.
- **Java.pdf #159 («verdaderas acerca de APX») ↔ V2 #39 («verdadera acerca de Spring Batch»).** V2#39 tiene exactamente las opciones de la #137. Eliminar.
- **Java.pdf #177 (nomenclatura de transacción) ↔ V2 #27 (nomenclatura de librería).** La V2#27 corresponde a la #119. Eliminar.
- **Discutible: 07 #46 (protocolos *lógicos*) ↔ QD1 #18 (protocolos *físicos*).** Tienen las mismas opciones, pero la pregunta es otra. Lo marcaría como variante o lo quitaría.
- Verificación de apoyo: comparé con un script las opciones de los 101 pares enlazados. Solo estos casos, la variante del Blob (observación 4) y OCR ruidoso de APX 4 quedan por debajo de 0,8 de coincidencia.

**3. «También en»: omisiones claras.** Es la misma pregunta, en el mismo idioma, y no está enlazada:
- **Java.pdf ↔ simulaciones y quizzes:**
  - #74 ↔ V2#7 (texto idéntico)
  - #69 ↔ V2#4 (la tabla «Casos límite» incluso las cita juntas)
  - #104 ↔ QA#19 (hueco de transitividad: los dos enlazan con V2#20)
  - #148 ↔ V2#42
  - #63 ↔ V1#27 (código idéntico)
  - #91 ↔ V2#16
  - #142 ↔ V2#40 (BLOB, misma respuesta)
  - #46 ↔ V1#14
  - #163 ↔ V1#31
- **07 ↔ Examen Diagnóstico APX 4:** las confirmé mirando las 12 páginas escaneadas.
  - 07#1 (y la variante #29) ↔ A4#2
  - 07#3 ↔ A4#3 (el caso que citaste)
  - 07#4 y #42 ↔ A4#4
  - 07#9 y QD1#25 ↔ A4#6
  - 07#13 ↔ A4#11
  - 07#15 ↔ A4#14
  - 07#47 ↔ A4#15
  - 07#48 ↔ A4#17
  - 07#63 ↔ A4#21
  - 07#65 ↔ A4#18 (opciones idénticas: 3false3…)
  - 07#66 ↔ A4#19 (mismas 6 opciones, en el mismo orden)
  - 07#67 ↔ A4#20 (Alpha/Beta/Gamma; 07 añade un cast)
  - 07#68 ↔ A4#12 (blipvert)
  - 07#69 ↔ A4#16 (Super/Sub)
  - También Java.pdf #192 ↔ A4#19.
- **Reformuladas, con opciones casi iguales:**
  - 07#43 ↔ QA#20 (Consola de Operaciones)
  - QD1#9 ↔ 07#13 y A4#11 (/fichtemporal)
- **Traducciones.** El índice declara esta limitación. Solo la primera la comprobé por opciones; las demás las detecté por enunciado y no las verifiqué una a una:
  - #58 ↔ V1#43 (ArrayList; opciones iguales traducidas)
  - #23 ↔ V1#12
  - #25 ↔ V1#34/36
  - #30 ↔ V2#11
  - #55 ↔ V1#26 y V2#1
  - #39 ↔ V1#44
  - #76 ↔ V2#8
  - #35 ↔ V1#31
  - #180 ↔ V1#13
- **Gravedad: media.**
  - En APX 4 faltan 14 de sus unos 19 enlaces reales. Solo tiene 5, así que la columna no sirve para ese examen.
  - Los enlaces falsos son peores que las omisiones, porque afirman una equivalencia falsa, y el aviso de «puede estar incompleta» no los cubre.
  - Causa probable: la similitud ≥ 0,85 se calculó contra enunciados de Java.pdf que incluyen opciones y justificación, y contra el OCR de APX 4 con sus opciones. Eso baja el ratio de las parejas verdaderas.
  - Corrección propuesta: comparar solo el enunciado, sin opciones; exigir que coincidan las opciones cuando el enunciado sea genérico o corto; y reescribir la nota del método.

### OBSERVACIONES MENORES
1. **«Casos límite» incompleta, aunque sin contradicciones.** Las 31 preguntas que cita tienen en el TSV el tema que declara la tabla. Casos del mismo tipo que faltan:
   - Java.pdf #142 (BLOB → APX, igual que V2#40).
   - 07#37 (nivel de log sin mencionar APX, igual que #36).
   - QD2#22 («Si un DTO cambia… serial versión», sin mencionar APX). Está como APX, pero la regla declarada para un DTO sin APX (#173) es Herramientas/general, así que es frontera no declarada. Proponga añadirla a la tabla o reclasificarla.
   - 07#50 figura como «referida a una transacción», pero su enunciado no dice «transacción». Solo se infiere por la sección APX.
2. **Ubicación vacía en 133 filas:** V1 45, V2 45, QA 16, QD1 17 y QD2 10. El «Pregunta N» del .docx sirve como localizador; bastaría con indicarlo o poner «Pregunta N».
3. **APX 4:** las filas #16 y #21 dicen «pág 9 izq» y «pág 12 izq», pero son páginas con una sola pregunta, centrada.
4. **V1#14 ↔ 07#26 (Blob):** mismo enunciado con opciones distintas. Es una variante, no la misma pregunta; conviene anotarlo.
5. **Duplicados internos no señalados:** V1#34 = V1#36, y en 07 la #67 y la #74 tienen las mismas opciones. Está fuera del alcance declarado de «También en»; solo lo informo.

### QUÉ REVISÉ Y CÓMO
- **Tarea 1, completitud de Java.pdf.**
  - Extraje el texto de las 303 páginas con pypdf. El PDF no tiene imágenes, así que no puede haber preguntas solo en imagen.
  - Segmenté los 212 números en orden, anclándolos al texto del TSV. Las 212 páginas coinciden con la columna «Ubicación» y la numeración es secuencial, sin números duplicados.
  - En cada bloque busqué, después de la marca de respuesta (✅, «respuesta correcta», «correct answer», «Justificación»…):
    - enunciados «¿…?»;
    - preguntas en inglés («Which / What… ?»);
    - listas de opciones a./b./c. que no fueran viñetas de justificación (●);
    - repeticiones de «Seleccione una / Verdadero Falso».
  - Revisé a mano 24 bloques marcados. **Único hallazgo: la 126b (pág. 199), que la ronda 1 ya había añadido.** Confirmé en render las págs. 198–199.
  - Todas las demás alarmas eran justificaciones: por ejemplo, la #96 repite el enunciado dentro de su análisis.
  - Los 30 bloques sin marca de texto son cortos y contienen una sola pregunta.
- **Tarea 2, coherencia del criterio.** Leí todas las filas de APX y de Herramientas/general, y busqué en las de Java por palabras clave (Batch, Job, Step, patrón, Maven, pom, JDBC, SQL, log, prácticas, retrocompatibilidad, DTO, OSGi, JUnit, Mockito, JDK…). Resultado coherente:
  - pom.xml y Maven → Herramientas/general, salvo cuando se trata de un concepto APX (JDBC Utility, apx config) → APX.
  - Spring Batch → APX en todos los casos.
  - JDBC de `java.sql` → Java; JDBC APX y Datasource → APX.
  - JUnit y Mockito → Java.
  - «Malas prácticas» → Java en los 5 casos.
  - Singleton, Command, Composite y State → Herramientas/general.
  - Retrocompatibilidad genérica → Herramientas/general; referida a una transacción → APX.
- **Tarea 3, muestreo.**
  - Muestra aleatoria estratificada con `random.Random(20260924)`, 60 filas:
    - **Java.pdf:** 4, 209, 169, 139, 161, 179, 38, 143, 145, 201, 186, 208, 15, 110, 72, 95, 195.
    - **07:** 84, 57, 69, 43, 45, 85, 70, 32, 8, 34.
    - **V1:** 14, 18, 3, 6, 38, 24.
    - **V2:** 31, 21, 5, 17, 30, 15.
    - **QA:** 17, 20, 16, 15, 14.
    - **QD1:** 15, 9, 2, 18, 6.
    - **QD2:** 18, 13, 21, 24, 20.
    - **APX 4:** 14, 4, 17, 9, 6, 15.
  - Resultado: 60 de 60 correctas en enunciado, número y tema.
  - Además, de forma exhaustiva y por script, el enunciado del TSV coincide con el bloque «Pregunta N» del .docx en las 267 filas de .docx, y la sección APX/JAVA de 07 cuadra.
  - Miré las 12 páginas de APX 4 (las 21 preguntas, conteo 12/7/2 correcto).
  - Imágenes de código revisadas (12): 07 image1, 2, 4, 5, 18 y 19 (#65, 67, 69, 70, 84 y 85); QD1 image4 (#6); QD2 image7, 12 y 14 (#13, 18 y 20); QA image1 y 6 (#4 y 9). Todas son Java.
- **Tarea 4.** Revisé a mano 23 pares enlazados y comparé por script las opciones de los 101. Para las omisiones, hice un barrido de similitud por prefijo y Jaccard entre exámenes y revisé a mano los candidatos.
- **Tarea 5, consistencia interna.** Por script:
  - TSV: 480 filas, sin claves duplicadas.
  - Conteos por examen y tema, y porcentajes, cuadran con el Resumen (156/239/85).
  - Las 480 filas están en el .md con el mismo tema, ubicación, «También en» y el recorte como prefijo del texto completo.
  - Ninguna fila de tabla tiene un número de columnas incorrecto (con pipes escapados).
  - «También en» es simétrico y todas sus referencias existen.

**No verifiqué:**
- Una por una, las 30 respuestas de Java.pdf que solo van resaltadas (vi 6).
- Las imágenes de V1/V2: esos .docx no tienen imágenes.
- Todas las traducciones posibles como omisiones.
- La corrección de las respuestas en sí, que está fuera del alcance.

Datos de apoyo en `…/scratchpad/vidx2/`: `blocks.json`, `cand.txt`, `fn.txt`, `fn2.txt`, `sample.txt`, `docxq.json`, `a4_p*.jpg` y `jv_p*.jpg`.