# Verificación adversarial del banco de preguntas de la «Ruta de estudio APX»

Directorio base: `/private/tmp/claude-501/-Users-mike-ide-eclipse-eclipse-workspace-academyCdmxQ3-materialApx/0d8b0801-62f8-4667-b823-2888ede1dc10/scratchpad/ruta`

Eres un verificador independiente. **Otro agente** construyó `banco-v1.json` y otro lo corrigió tras una primera ronda de verificación (`banco-v2.json`; cada pregunta trae `cambios_r1` y el detalle está en `cambios-r1.md`) (222 preguntas únicas de APX, arquitectura Java de BBVA). Irán a cuestionarios de Moodle que corregirán a 11 alumnos: una respuesta mal marcada les enseña algo falso. Tu trabajo es **encontrar errores**, no confirmar. No edites `banco-v2.json`: solo informa.

## Archivos

- `banco-v2.json`: por pregunta: `grupo`, `paso` (1–11), `representante`, `miembros`, `enunciado`, `opciones` ([letra, texto]), `tipo` (single/multi), `correctas`, `respaldo` (doc/clave/ninguno/contradictorio), `destino` (cuestionario/instructor), `fuente`, `cita`, `retro`, `nota_constructor`.
- `clasif-todas.json`: el `texto` ORIGINAL de cada pregunta por id (representante y miembros) y lo que dijo el clasificador anterior.
- `corpus/`: la documentación del curso («=== página N», «--- slideN.xml»; `*.slides-ocr.txt` = OCR de imágenes de diapositivas; `*.mapa.txt` = mapas mentales). PDFs originales, por si el texto no basta: `/Users/mike/ide/eclipse/eclipse-workspace/academyCdmxQ3/materialApx/CLASIFICADOR/apx/`.
- `APX3_clave_marcada.txt`: clave del PDF «Exámen Diagnóstico APX 3» («[✔]» = resaltado amarillo; no validada).
- `preguntas.json`: todas las preguntas; las de "java/Java.pdf" traen su clave («La respuesta correcta es: …»).
- `etapas.md`: fuentes y conceptos por etapa (numeración vieja E1–E13; nueva `paso`: 1=E1, 2=E2, 3=E3+E9, 4=E4, 5=E5, 6=E6, 7=acceso a datos/excepciones/restricciones de código, 8=logs/errores/estilo, 9=E8, 10=E10+E11, 11=E12+E13).

## Qué compruebas en CADA pregunta de tu lote

1. **Fidelidad:** `enunciado` y `opciones` corresponden al `texto` original del representante (sin opciones perdidas, cambiadas o inventadas; letras en el mismo orden). Solo se permiten arreglos de extracción y quitar «Otro:»/«No conozco la respuesta». **Una «corrección» de errata que cambie qué opción es correcta es un error** (p. ej. si una opción trae un nombre de paquete mal escrito que podría ser la trampa de la pregunta).
2. **Respuesta:** abre la `fuente` y comprueba que la `cita` está ahí literalmente y que respalda exactamente `correctas`. Para "multi": ¿están todas las correctas y ninguna de más? Opciones del tipo «Todas las anteriores»/«a y b»: ¿se marcaron coherentemente?
3. **Respaldo y destino:** ¿"doc" de verdad está en la documentación? ¿"clave" coincide con la clave (APX3 o Java.pdf)? ¿Alguna que va a "cuestionario" es en realidad ambigua o tiene dos opciones defendibles (debería ir a "instructor")? ¿Alguna que va a "instructor" sí tiene respuesta inequívoca en la documentación?
4. **Retroalimentación (`retro`):** ¿es correcta, no afirma nada que la fuente no diga y señala dónde estudiarlo? Si `respaldo`="clave", ¿empieza con el aviso de que la respuesta viene de la clave?
5. **Grupo:** ¿todos los `miembros` son de verdad la misma pregunta con la misma respuesta? (compara sus textos en `clasif-todas.json`).
6. **Paso:** ¿la etapa es la adecuada según `etapas.md`?

## Salida

Escribe un array JSON válido en el archivo indicado, un objeto por pregunta de tu lote (todas, también las que estén bien):
`{"grupo": "G001", "veredicto": "ok" | "corregir" | "dudoso", "hallazgos": [{"aspecto": "fidelidad|respuesta|respaldo|destino|retro|grupo|paso", "gravedad": "alta|media|baja", "detalle": "…", "propuesta": "qué cambiar exactamente"}]}`
- "alta" = el alumno aprendería algo falso o se le calificaría mal.
- Solo cuenta lo que hayas comprobado en la fuente; si no pudiste comprobar algo, dilo en `detalle` y usa "dudoso".
Verifica con python que el archivo carga y cubre exactamente los grupos de tu lote.

Respuesta final (≤ 150 palabras): nº ok / corregir / dudoso, nº de hallazgos por gravedad y los 5 más graves.

## Además, en esta ronda 2

- Eres la **segunda** ronda: la primera no encontró errores graves, lo que NO significa que no los haya. Busca sobre todo lo que una lectura rápida no ve: opciones compuestas («a y b», «Todas las anteriores») marcadas de forma incoherente, preguntas de selección múltiple a las que les falta o sobra una correcta, retroalimentaciones que afirman más de lo que dice la fuente, grupos que mezclan preguntas con distinta respuesta.
- Revisa con más cuidado las preguntas con `cambios_r1` no vacío: ¿el cambio es correcto y no rompió nada?
- **Archivos que verá el alumno.** La `retro` y la `fuente` solo pueden remitir a estos documentos del curso (más las claves de examen «Java.pdf»/«APX3»): Curse_APX_Online.pptx, APX Qué es.pdf, APX Online Capabilities.pdf, APX_Online.pptx, APX Online - Creación DTO.pdf, APX Online - Creación de Transacciones.pdf, APX Online - Trabajar con el componente Librería.pdf, APX Online - Librerías simples.pdf, APX Online - Librerías MongoDB.pdf, APX Online - Extraer un DTO.pdf, los 5 mapas mentales, APX Batch - Documentación.pdf, APX Batch - Conceptos por Lotes.pdf, APX Batch - Componentes del lote APX.pdf, Creación JOB en APX BATCH.pdf, APX_BATCH.pptx.pdf, AcademicosAPX.pdf. Cualquier otra referencia es un hallazgo; y comprueba que la página o diapositiva citada de verdad contiene lo que se dice.
- **Tipo cambiado respecto al original:** G002 (V3-13) y G003 (T08-31) eran «opción única» en el examen, pero el banco las pone como múltiple porque la clave marca dos respuestas. ¿Es defendible? ¿La retro lo aclara?
