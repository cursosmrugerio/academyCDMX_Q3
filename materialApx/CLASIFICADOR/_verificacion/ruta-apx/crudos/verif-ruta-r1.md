# Verificación adversarial · Ruta de estudio APX · ronda 1

Revisado: `plan-prueba.json` (etiquetas, recursos y `omitidos`), `26_generar_plan.py`, LEEME §1 (y su diff), contra el corpus (`corpus/`, `txt/*.ocr.txt`), las imágenes de los PDF extraídas con pypdf y las de las diapositivas (`slides/*/ppt/media`).
No he evaluado la corrección de las preguntas. Solo he cruzado sus retroalimentaciones con `omitidos` y con los rangos de diapositivas, porque ahí el plan se contradice a sí mismo.

Recuento: **2 altas · 5 medias · 11 bajas.**

---

## ALTA

### H1. 12 retroalimentaciones mandan a estudiar en archivos que no se suben (`omitidos`)
- **Dónde:** `preguntas[].retro` frente a `omitidos` (en el generador: `OMITIDOS`, líneas 58–66).
- **Qué está mal:** el quiz promete «dónde estudiarla», pero estas retroalimentaciones citan archivos que no estarán en Moodle:
  - `2 - APX Online Components.pdf`: G031, G036, G037 y G041.
  - `Componentes APX BATCH.pdf`: G044, G212 y G214.
  - `Creación de librería.pdf`: G102.
  - `Conceptos APX Batch.pdf`: G191, G192, G196 y G213.
  - **Cuatro citan solo el archivo omitido:** G102, G191, G196 y G212. El alumno no tiene dónde ir.
- **Propuesta:**
  1. Cambiar las citas a los documentos que sí se suben:
     - G031, G036, G037 y G041: «Curso, diap. 3–5 y 9».
     - G044, G212 y G214: «APX Batch — componentes y utilidades, pág. 1».
     - G191, G192, G196 y G213: «APX Batch — conceptos, págs. 5–6», y además «Mapa mental · APX Batch (1 de 2)», donde aparecen literalmente ItemReader, ItemProcessor e ItemWriter (ver M2).
     - G102: «Trabajar con el componente Librería, págs. 1–2» (TESTR001 / TESTR001IMPL). Ver M3.
  2. Añadir una guarda al generador: `for b in BANCO: for p,_ in OMITIDOS: if os.path.basename(p)[:-4] in b['retro']: sys.exit('ABORTA: retro cita omitido ' + b['grupo'])`.

### H2. `APX_Online.pptx`: no es cierto que «el resto repite la presentación del curso»
- **Dónde:**
  - Intro del recurso `doc-apxonline`: «Solo las diapositivas 12 a 19; el resto repite la presentación del curso».
  - Guía de la etapa 3: «diap. 12–19».
  - LEEME: «De `APX_Online.pptx`, las diapositivas 2 a 10 repiten la presentación del curso».
- **Qué está mal:** según el OCR (`APX_Online.slides-ocr.txt`) y `slides/*/map.txt`, varias diapositivas no están en el curso:
  - **Diap. 7:** diagrama del flujo del DTO. La transacción crea el DTO y rellena sus atributos, llama a `execute(DTO)` y la librería devuelve el DTO. El curso no tiene ningún diagrama del DTO: sus diap. 26 y 55–56 son solo texto.
  - **Diap. 9:** diagrama de la refactorización del Blob (LibA/LibB/LibC/LibD).
  - **Diap. 10–11:** la solución del Contenedor mágico, en dos casos:
    1. Un `execute` con varias funcionalidades de la misma entidad: se expone un `executeXXX` por cada una.
    2. Varias entidades: (a) enumerar y agrupar por entidad, (b) aplicar el caso 1 y (c) extraer a una librería por entidad.

    El curso (diap. 48) solo dice «refactoring de la librería y disgregación por entidades». El objetivo de la etapa 9 promete «síntomas, causas y **solución**».
  - **Diap. 2:** trae el nombre en inglés «Extended Java Backend Architecture», que el curso no tiene. Lo pregunta el examen y lo cita la página del instructor.
  - **Diap. 20:** captura de «Add Configuration» (Key, Value, Family, Observation, Environment Dependent). Completa la diap. 19 y queda fuera del rango 12–19.
  - La diap. 11 no está en ninguna de las dos listas: ni en «2 a 10» (LEEME) ni en «12 a 19».
  - Además, varias retroalimentaciones citan diapositivas fuera de 12–19, lo que contradice el «Solo las diapositivas 12 a 19»:
    - G062: diap. 7.
    - G166, G169 y G170: diap. 8.
    - G167: diap. 10.
    - Página del instructor: diap. 2 y 4.
- **Propuesta:**
  - Etapa 3: `'{apxonline}: diap. 12–20 (en inglés).'`
  - Etapa 4: añadir `'{apxonline}: diap. 7 (diagrama: cómo viaja un DTO de la transacción a la librería).'`
  - Etapa 9: añadir `'{apxonline}: diap. 8–11 (Blob y Contenedor mágico con diagramas y cómo refactorizarlos, en español).'`
  - Intro del recurso: «Etapa 3: diap. 12–20 (consola y credenciales, en inglés). Etapa 4: diap. 7. Etapa 9: diap. 8–11. Las diap. 2–6 repiten el curso en inglés (la 2 da el nombre en inglés: *Extended Java Backend Architecture*).»
  - Nombre del recurso: «📊 Presentación corta APX Online (20 diapositivas, casi toda en inglés)».
  - LEEME: «De `APX_Online.pptx`, las diapositivas 2 a 6 repiten el curso; la 7 va con la etapa 4, las 8 a 11 con la etapa 9 y las 12 a 20 con la etapa 3.»

---

## MEDIA

### M1. Etapa 1: la alternativa en español no «dice lo mismo salvo la pág. 6»
- **Dónde:** guía de la etapa 1 (`26_generar_plan.py`, línea 90) y LEEME §1, punto 1: «Curso, diap. 18–20 y 30–31 dicen lo mismo en español, salvo los servicios bancarios de la pág. 6».
- **Qué está mal:**
  - **Pág. 1** de Capabilities: una imagen con las 8 capacidades (Transactional Processing, Integration with Security Services, Data Access Layer, **Hot Deployment**, Backends Interoperability, Banking Services, Batch Processing, Monitoring). No está en el curso, y las preguntas la usan: G002 («Cold Deployment») y la del instructor sobre «Implementaciones en caliente».
  - **Pág. 5** («Backend Interoperability»): es exactamente la imagen de la **diap. 32** del curso (`media/image18.png`, «Cloud as a BACKEND… REPLICATION»). La diap. 32 no está asignada a ninguna etapa.
  - **Págs. 2 y 3:** sus diagramas (pila de ejecución con *Transaction Profiling*; conectores Oracle/MongoDB/ElasticSearch/Neo4j con réplica desde DB2) no están en el curso. Tampoco la primera frase de la pág. 2 (protocolos físicos HTTP, JMS y REST), que etapas.md sí listaba.
- **Propuesta:** «Si el inglés te cuesta, las diap. 18–20 y 30–32 de la Presentación del curso traen en español el texto de las págs. 2–5. Mira de todos modos, en el PDF, la pág. 1 (las 8 capacidades de APX), los diagramas de las págs. 2–3 y la pág. 6 (servicios bancarios).» Aplicarlo igual en el LEEME.

### M2. Los sustitutos en español son traducción automática y cambian los términos técnicos que traen los omitidos
- **Dónde:** `omitidos` (Conceptos APX Batch, Componentes APX BATCH, Introducción APX Batch) y los recursos `doc-b-concep`, `doc-b-comp`, `doc-b-doc` y `doc-trx`.
- **Qué está mal:** «no aportan nada» no es del todo cierto. Los omitidos traen el término original y el sustituto lo traduce mal:
  - `APX Batch - Conceptos por Lotes.pdf`:
    - Llama al chunk **«Fragmento»**. La palabra «Chunk» no aparece, aunque el nombre del recurso dice «conceptos: Job, Step, **Chunk** y Tasklet».
    - ItemReader e ItemProcessor salen como **«Lector de artículos»** y **«Procesador de artículos»**.
    - Los contadores salen como «leerContar», «cometerContar»…
    - `Conceptos APX Batch.pdf`, pág. 8, dice «Chunk», «ItemReader», «ItemProcessor» e «ItemWriter». Por eso G191 y G196 lo citan a él.
  - `APX Batch - Componentes del lote APX.pdf`: Shell → **«Caparazón»**, Rules → **«Normas»**, Utilities → **«Servicios públicos»**. El omitido en inglés dice Shell y Rules.
  - `APX Batch - Documentación.pdf`: REST services → **«Servicios de descanso»**.
  - `Creación de Transacciones.pdf`, pág. 2: los subcomandos salen como «complemento apx», «apx agregar fuera», «Mod apx es» y «salida apx del». Aquí el omitido no ayuda (solo trae `init`), pero el alumno necesita el aviso.
  - El contenido no se pierde (mapa Batch PT1 y APX_BATCH pág. 5 dicen Chunk/ItemReader), pero el alumno que estudia el documento indicado no reconoce las opciones del examen.
- **Propuesta:** poner `intro` (con `showdesc=1`) en estos recursos:
  - b-concep: «Traducción automática: “Fragmento” = Chunk; “Lector/Procesador de artículos” = ItemReader/ItemProcessor; “Escritor” = ItemWriter.»
  - b-comp: «Traducción automática: “Caparazón” = Shell; “Normas” = Rules; “Servicios públicos” = utilidades; “Fusionar/ordenar” = Merge/Sort.»
  - b-doc: «“Servicios de descanso” = servicios REST.»
  - trx: «Los subcomandos de la pág. 2 están mal traducidos: son `apx add in`, `apx add out`, `apx mod in`, `apx mod out`, `apx del in`, `apx del out`, `apx show in`, `apx show out` (como en págs. 3 y siguientes).»

  Y en el LEEME, «Versiones repetidas»: añadir «Las guías en español son traducción automática; si un término no te cuadra, la versión en inglés trae el original».

### M3. `Creación de librería.pdf` sí trae algo que el sustituto no tiene
- **Dónde:** `omitidos` («extracto en inglés de…») y el objetivo de la etapa 6.
- **Qué está mal:**
  - El omitido dice explícitamente «Library code: 3 characters (**R** + three alphanumerals)» y muestra la salida «Library code "R [code]"… Project interface: TESTR001 / Project implementation: TESTR001IMPL».
  - El sustituto (`Trabajar con el componente Librería`, pág. 1) dice solo «Código de Librería: Tres caracteres alfanuméricos». La «R» solo se deduce de los árboles TESTR001/ y TESTR001IMPL/ (pág. 2) y de `[UUAA]R[CODE]IMPL.properties`.
  - G102 (nomenclatura de librería) cita solo el omitido.
  - Las etapas 4 y 5 tienen un objetivo de nomenclatura (UUAA + C, UUAA + T); la 6 no.
- **Propuesta:**
  - Objetivo de la etapa 6: «Crear una librería (interfaz UUAA + R + código, p. ej. TESTR001, e implementación TESTR001IMPL) y añadirle dependencias y utilidades.»
  - G102: citar «Trabajar con el componente Librería, págs. 1–2».
  - El motivo de `omitidos` puede quedarse, pero debería decir «extracto en inglés del comando `apx init lib`; la regla “R + 3” está en la pág. 2 de la guía en español (árbol TESTR001)».

### M4. Etapa 3 promete «APX CLI» sin material, y AcademicosAPX se usa fuera de la etapa 11
- **Dónde:** título de la etapa 3 (y del LEEME, punto 3); guía de la etapa 11 («por eso esta etapa no tiene autoevaluación»).
- **Qué está mal:**
  - Ni Curso diap. 33–35 ni APX_Online diap. 12–19 dicen qué es APX CLI.
  - Aun así, la autoevaluación 3 pregunta «¿Qué es APX CLI?» (G050 y G051). Sus retroalimentaciones mandan a `AcademicosAPX.pdf` pág. 48 (etapa 11) y a documentos de las etapas 4 y 6.
  - Pasa lo mismo con G032 (etapa 2: «cuatro tipos de componentes… jobs»). Solo lo respalda Académicos págs. 3 y 48; Curso 3–9 no menciona jobs.
  - También lo citan G031 (etapa 2), G089 (etapa 6) y G214 (etapa 10).
  - «Los exámenes casi no lo preguntan» es cierto en proporción: unas 8 de 222 preguntas (6 en autoevaluaciones y 2 del instructor). Pero esas preguntas están repartidas en etapas cuyo «📖 Estudia» no incluye Académicos.
- **Propuesta:** hay dos opciones.
  - **Opción (a), recomendada:**
    - Etapa 2: añadir `'{academicos}: págs. 2–3 (unidades de despliegue y qué componentes van en online y en batch).'`
    - Etapa 3: añadir `'{academicos}: pág. 48 (qué es APX CLI).'`
    - Etapa 11: «léelo como contexto; sus págs. 2–3 y 48 ya las viste en las etapas 2 y 3. Los exámenes casi no lo preguntan…».
    - Enlazar el mismo recurso con páginas distintas no repite material.
  - **Opción (b):** quitar «APX CLI» del título de la etapa 3 y mover G050 y G051 a la etapa 4, la primera que usa `apx init`.

### M5. Etapa 10: Control-M no es una «utilidad de Batch»
- **Dónde:** objetivo de la etapa 10: «conocer las utilidades de Batch (JDBC, MongoDB, Shell Script Launcher, Control-M)».
- **Qué está mal:** la lista de utilidades de Batch (b-comp pág. 1) es Jdbc, Document Creator, Rules, Shell, API Connector, Merge/Sort y MongoDB. Control-M es el planificador: «Integración con programadores: Control-M» (b-doc pág. 1) y desde donde se lanza ShellScriptLauncher (APX_BATCH págs. 18 y 21). G212 pregunta justamente qué utilidades hay en Batch.
- **Propuesta:** «Crear un job, nombrar las utilidades de Batch (Jdbc, Document Creator, Rules, Shell, API Connector, Merge/Sort, MongoDB) y saber lanzar un script con Shell Script Launcher desde Control-M.»

---

## BAJA

- **L1.** `doc-b-pres`: «las dos primeras repiten “¿Qué es APX?”». La pág. 1 es solo la portada («BATCH»). Proponer: «Empieza en la pág. 3: la 1 es la portada y la 2 repite “¿Qué es APX?”».
- **L2.** Simulacro: «Hazlo cuando termines las 10 etapas», pero la sección dice «11 etapas». Proponer: «cuando termines las etapas 1 a 10». Además, la intro de «Antes de empezar» dice «cada una se marca completa al sacar 7 de 10 en su autoevaluación», y la etapa 11 no tiene autoevaluación. Proponer: «cada etapa con autoevaluación se marca completa…».
- **L3.** Plural: la etapa 7 muestra «**1 preguntas** de esta etapa están…» (generador, línea 200). Proponer `f'{k} pregunta{"s" if k!=1 else ""} de esta etapa {"están" if k!=1 else "está"}…'`.
- **L4.** Objetivo de la etapa 2: «librerías «especiales»». Ese término solo aparece en el omitido en inglés («"special" libraries»); Curso diap. 7 dice «Utilidades **Específicas**». Proponer «específicas».
- **L5.** El nombre «APX Online — consola y credenciales (presentación, **en inglés**)» no es exacto: las diap. 6, 7 y 9–11 están en español. Además, la guía de la etapa 3 repite «(en inglés)» dos veces seguidas (en el nombre del enlace y detrás de «diap. 12–19»). Ver el nombre propuesto en H2.
- **L6.** «No repetir material»: `APX Qué es.pdf` es literalmente igual a Curso diap. 2 (y a APX_BATCH pág. 2, APX_Online diap. 2 y la cabecera del mapa Batch PT1), y el curso ya se sube. Se podría omitir y citar «Curso, diap. 2». Si se mantiene (1 página, cómoda), conviene que `omitidos`/LEEME no digan «cada documento está una sola vez» a secas. Es una decisión de diseño; no lo considero error.
- **L7.** Los objetivos de la etapa 1 no nombran las 8 capacidades ni la capa de acceso a datos y la seguridad corporativa (págs. 1, 3 y 4; Curso 30–31), pero la autoevaluación las pregunta. Añadir «Enumerar las 8 capacidades de APX y explicar la capa de acceso a datos desacoplada y la integración con la seguridad corporativa».
- **L8.** Objetivo de la etapa 6: «sin DTO en la interfaz». Choca a primera vista con la tabla de la guía de librería (pág. 3: «DTO — Librería de interfaz: Sí»), que trata el DTO como *dependencia*. Proponer: «no definir clases DTO dentro de la interfaz (se usan desde un componente DTO) y cómo extraerlas».
- **L9.** Etapa 10: APX_BATCH págs. 3–5 resumen lo que ya dicen b-doc (estrategias) y b-concep (job/step, chunk/task). No es error grave: las págs. 3–4 añaden dos frases y la 6 amplía los flujos no secuenciales. Se puede mantener «desde la pág. 3».
- **L10.** Omisión aceptable, pero con una pérdida menor: `Conceptos APX Batch.pdf` pág. 6 tiene el diagrama Job/Step/JobInstance/JobExecution/StepExecution, que no está en `Conceptos por Lotes` (su pág. 4 solo trae un icono de 14×16 px). `Introducción APX Batch` no aporta nada: su diagrama de capas está en b-doc pág. 2.
- **L11.** En la parte «Practicar» del LEEME, «Las que no estén en ese PDF no tienen respuesta en ningún archivo» es cierto para las claves, pero la Ruta ya las responde con la documentación. Proponer: «…no tienen clave en ningún archivo; la Ruta de Moodle las responde con la documentación o las deja en “Preguntas para resolver con el instructor”». Nota aparte: las 38 preguntas de APX de `Java.pdf`, que §2 reserva «para el repaso final», ya salen resueltas en las autoevaluaciones de la Ruta. Conviene decirlo en §2 o aceptarlo.

---

## Comprobado sin objeción

- **Recuento de páginas y diapositivas** (pypdf y los `slideN.xml`), todos correctos:
  - Qué es: 1. Capabilities: 6. Creación DTO: 2. Transacciones: 8. Librería: 9. Simples: 2. MongoDB: 3. Extraer DTO: 5.
  - Batch Documentación: 3. Conceptos por Lotes: 6. Componentes: 2. Creación JOB: 1. APX_BATCH: 23. AcademicosAPX: 97.
  - Curso: 57 diapositivas. APX_Online: 20.
- **Idiomas:**
  - Capabilities en inglés ✓.
  - Curso en español ✓.
  - Guías de Online y Batch en español (traducción automática, ver M2) ✓.
  - Creación JOB en español (OCR) ✓.
  - AcademicosAPX en español ✓.
- **Sin diapositivas del curso en dos etapas.** Asignación: E1 18–20, 30–31 · E2 3–9 · E3 33–35 · E4 26, 55–56 · E5 10–17, 29, 39–41 · E6 27, 28, 38 · E7 21–25 · E8 36–37, 49 · E9 42–48, 50–54. No hay solapes. Ningún documento aparece como recurso en dos etapas. Los mapas mentales van como repaso explícito, uno por bloque (Online en E9, Batch en E10).
- **Diapositivas del curso sin asignar:**
  - 1: portada.
  - 2: «¿Qué es APX?», idéntica a `APX Qué es.pdf`, que ya está en E1. No es olvido.
  - 32: diagrama de interoperabilidad = Capabilities pág. 5. El contenido está cubierto en E1, pero debería estar en la alternativa en español (M1).
  - 57: vacía (solo el logo).
- **Contenido de cada rango del curso:** coincide con lo que dice cada etapa.
  - 3–9: TX, librería, estrategia, utilidades específicas y comunes, DTO.
  - 10–17: campos de entrada y salida con capturas y la clase abstracta.
  - 18–20: pila de ejecución.
  - 21–25: acceso a datos Oracle y excepciones.
  - 26, 55–56: DTO.
  - 27: dependencias circulares.
  - 28: APIConnector y sin código funcional en la interfaz.
  - 29: mainframe.
  - 30–31: capa de datos y seguridad.
  - 33–35: Maven/JDK, Artifactory, entorno local.
  - 36: LOGGER.
  - 37: errores.
  - 38: visibilidad.
  - 39–41: asíncronas y perfilado.
  - 42–48: patrones, Blob, Contenedor mágico.
  - 49: estándares.
  - 50–54: paginación y CRUD.
- **APX_Online diap. 12–19:** Operation Console, Components (capturas en 13–17) y Credentials ✓. Salvo lo de H2 (falta la 20).
- **Omitidos cuyo motivo es correcto y que no pierden contenido:**
  - `2 - APX Online Components.pdf` = Curso 3–9 en inglés. Incluso su imagen es la de la diap. 5; el curso añade además «Gestor de documentos».
  - `Ejemplo de DTO.pdf` = el `init` de «Creación DTO» (la misma salida de CLI).
  - `Ejemplo de Creación de Transacción.pdf` = las restricciones de `init` de la pág. 1 de «Creación de Transacciones».
  - `Introducción APX Batch.pdf` ⊂ b-doc, que además trae los ejemplos.
  - Salvedades: M2, M3 y L10.
- **Afirmaciones didácticas:**
  - «El DTO va antes porque la transacción y la librería lo usan como dependencia»: **cierta**. `apx add in --tag="dto" -a="TESTC001"` (Transacciones, pág. 3 y siguientes), «Agregar dependencia DTO a la Librería» / `apx add dep -a="TESTC001"` (Librería, pág. 3) y Curso diap. 56.
  - «Extraer un DTO supone que ya conoces la librería»: **cierta**. Sus pasos modifican el pom de la interfaz de la librería y sus dependencias.
  - «Los exámenes casi no preguntan AcademicosAPX»: **cierta en proporción** (unas 8 de 222), pero ver M4.
  - «Las diapositivas 2 a 10 de APX_Online repiten la presentación del curso»: **falsa** para la 2 (nombre en inglés), la 7, la 9 y la 10 (H2).
  - «APX_BATCH págs. 1–2 repiten ¿Qué es APX?»: **inexacta** (L1).
- **Generador:**
  - La verificación de sha256 y la guarda «documentos de apx/ sin decidir» (líneas 67–73) están bien.
  - Las claves `{{cm:…}}` de las etiquetas coinciden con las `key` de los recursos y quizzes.
  - 175 + 47 = 222 ✓.
  - Los 7 omitidos coinciden con el LEEME.
  - Suma de los videos: 1944 MB ≈ 1.9 GB ✓. «Pedro Alarcón» coincide con `VIDEOS-Y-ENLACES.md` ✓.
- **LEEME §1, coherencia con el resto:**
  - Enlace `INDICE-PREGUNTAS.md` ✓.
  - Referencias a §2 (Java.pdf, repaso final) ✓ y a §3 (catálogo; marcas de APX 4) ✓.
  - «08 - Teoría APX (34 preguntas, el .docx más corto)» ✓, contra el catálogo: 81/94/85/34.
  - El orden de etapas y los rangos del LEEME coinciden con el plan. Los errores son compartidos (H2, M1, M4).
