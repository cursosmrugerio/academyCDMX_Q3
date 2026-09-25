# Construcción del banco de preguntas de la «Ruta de estudio APX»

Directorio base: `/private/tmp/claude-501/-Users-mike-ide-eclipse-eclipse-workspace-academyCdmxQ3-materialApx/0d8b0801-62f8-4667-b823-2888ede1dc10/scratchpad/ruta`

## Qué es esto

Los alumnos de una academia estudiarán APX (arquitectura Java de BBVA) por etapas. Cada etapa termina con un cuestionario de Moodle de autoevaluación. Tú construyes, para cada pregunta, la versión final que irá al cuestionario: respuesta correcta y retroalimentación con la fuente. **Un error aquí enseña algo falso a 11 alumnos**: prefiere mandar una pregunta a «instructor» antes que darle una respuesta dudosa.

## Archivos

- `banco-borrador.json`: 222 preguntas únicas (una por grupo de duplicados): `grupo`, `paso` (1–11), `representante` (id de la pregunta elegida), `miembros` (ids de la misma pregunta en otros exámenes), `enunciado`, `opciones` ([letra, texto]) ya separadas del texto original, `tipo_origen` ("single" | "multi" | null) y `opciones_de_formulario` (letras de opciones «Otro: …» o «No conozco la respuesta», propias de Google Forms).
- `clasif-todas.json`: por cada id (también los miembros): `texto` original completo, `respuesta_doc`, `fuente_doc`, `cita_doc`, `cubierta_por_documentacion`, `respuesta_clave`, `fuente_clave`, `coinciden`, `confianza`, `nota`. Lo produjo otro agente; **no lo des por bueno: compruébalo**.
- `grupos-duplicados.json`: `respuestas_consistentes` y `nota` de cada grupo.
- `corpus/`: texto de la documentación («=== página N», «--- slideN.xml»; `*.slides-ocr.txt` = OCR de imágenes de diapositivas; `*.mapa.txt` = OCR de mapas mentales).
- `APX3_clave_marcada.txt`: PDF «Exámen Diagnóstico APX 3» con «[✔]» en las líneas resaltadas (su clave; no validada).
- `preguntas.json`: todas las preguntas; las de "java/Java.pdf" traen su clave en el texto («La respuesta correcta es: …»).
- `etapas.md`: fuentes y conceptos por etapa (numeración vieja E1–E13; la nueva numeración `paso` 1–11 es: 1=E1, 2=E2, 3=E3+E9, 4=E4, 5=E5, 6=E6, 7=E7 acceso a datos/excepciones/restricciones de código, 8=E7 logs/errores/estilo, 9=E8, 10=E10+E11, 11=E12+E13).

## Qué produces por cada pregunta de tu lote

Un objeto JSON:
- `grupo`, `paso`, `representante`, `miembros`: tal cual (si crees que `paso` está mal, cámbialo y explícalo en `nota_constructor`).
- `enunciado`: el del borrador, corrigiendo solo defectos de extracción (ligaduras «ﬁ», saltos de línea rotos, restos como «Seleccione una:»). **No reescribas el contenido** ni corrijas la ortografía original salvo erratas que cambien el sentido (anótalas).
- `opciones`: las del borrador, corregidas igual; **quita** las de `opciones_de_formulario` y cualquier opción duplicada por error de extracción; no reordenes ni cambies letras de las demás.
- `tipo`: "single" (una respuesta) o "multi" (varias). Las de «selección múltiple» del .docx son "multi". Las de Java.pdf, según su clave.
- `correctas`: lista de letras correctas (según `opciones`).
- `respaldo`: "doc" (la documentación del corpus lo dice), "clave" (solo lo respalda una clave: APX3 o Java.pdf; el corpus no lo trata), "ninguno" (no hay respuesta en ningún archivo) o "contradictorio" (documentación y clave se contradicen, o las fuentes no permiten una única respuesta).
- `destino`: "cuestionario" si `respaldo` es "doc" o "clave" y la respuesta es inequívoca; "instructor" en los demás casos (sin respuesta, contradicción, pregunta ambigua o con varias opciones defendibles cuando se pide una).
- `fuente`: "archivo · pág. N" / "archivo · diap. N" (para "doc"), o "APX3 #N" / "Java.pdf #N" (para "clave"); null si no hay.
- `cita`: cita LITERAL de la fuente, ≤ 25 palabras, comprobada por ti en el archivo; null si no hay. Para "clave", la opción marcada tal como aparece.
- `retro`: retroalimentación para el alumno, en español, ≤ 50 palabras, que explique por qué es la correcta y **dónde estudiarlo** (archivo y página/diapositiva). Si `respaldo` es "clave": empieza con «Respuesta tomada de la clave del examen (no la explica la documentación del curso).». Para "instructor": explica qué dice cada fuente o por qué no hay respuesta, sin afirmar una respuesta.
- `nota_constructor`: decisiones y dudas (breve).

## Reglas

- Comprueba cada respuesta abriendo la fuente. Si la respuesta de `clasif-todas.json` está mal, corrígela y dilo en `nota_constructor`.
- Revisa todos los `miembros`: si alguno trae clave (APX3/Java.pdf) úsala para cotejar; si los miembros tienen opciones distintas, las letras siempre se refieren a las `opciones` del representante.
- No uses conocimiento general para decidir una respuesta que las fuentes no dan: eso es "ninguno".
- Las opciones compuestas («a y b», «Todas las anteriores») cuentan como una opción más.

Escribe tu lote como array JSON válido en el archivo indicado y verifica con python: carga, mismo número de objetos y mismos `grupo` que tu parte del borrador, `correctas` ⊂ letras de `opciones` y no vacía cuando `destino` es "cuestionario", `tipo`="single" ⇒ exactamente 1 correcta.
