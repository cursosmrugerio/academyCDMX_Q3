## Resultado: verificación de la clasificación de `materialApx/` (solo lectura)

No modifiqué nada dentro de `materialApx/`. Todo lo temporal (hashes, textos extraídos, páginas renderizadas y clasificadores) está en `/private/tmp/claude-501/-Users-mike-ide-eclipse-eclipse-workspace-academyCdmxQ3-materialApx/8f5b0d8c-06b4-4287-a952-0d1e3c8fb856/scratchpad/verif1/`. No leí `INDICE.md` ni `manifest.json`. Clasifiqué **65 archivos**. `VIDEOS-Y-ENLACES.md` solo lo leí al final, para clasificarlo.

**Método:**
- **Hashes:** SHA-256 completo de todo (`sha256.txt`).
- **PDF con texto:** extraído con pypdf.
- **PDF escaneados:** renderizados y revisados a ojo.
- **.docx y .pptx:** descomprimidos y leído su XML.
- **Mapas mentales:** reducidos con sips y revisados a ojo.
- **Conteos en exámenes:**
  - En los .docx, cada pregunta es un bloque `Pregunta N`. Los clasifiqué por palabras clave y luego revisé a mano todas las que no quedaron en APX; los "??" eran código Java en imagen, o normas APX (niveles de log, hilos, variables BIND).
  - En `Java.pdf` hay 212 preguntas numeradas en orden. Las clasifiqué por palabras clave y después corregí 4 a mano.
  - En los PDF escaneados conté a ojo, pregunta por pregunta.

### Tabla (rutas relativas a `materialApx/`)

| Ruta | Categoría | Evidencia | Confianza |
|---|---|---|---|
| 1 - Material de estudio - APX/Documentación APX/1 - APX Capabilities.pdf | no-copiar-duplicado (de `APX ONLINE/APX Online Capabilities.pdf`) | 6 p. "APX Capabilities / Online Architecture execution stack". Mismo texto (diff vacío), mismas 6 imágenes del mismo tamaño y render de las 6 páginas idéntico píxel a píxel (maxdiff 0). Solo cambia la versión del renderizador de Google Docs (m142 frente a m148). | alta |
| …/Documentación APX/AcademicosAPX.pdf | apx | Escaneo de 97 p. Vistas las págs. 1, 2, 5, 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90 y 97. Todo trata del ciclo de vida de componentes APX en Ether: recursos APX (UD online/batch, librería, DTO, shell script), modelo de ramas, pipelines Jenkins/Samuel/Sonar, despliegue con Cronos y rollback de librerías. | alta |
| …/Documentación APX/APX BATCH/APX Batch - Componentes del lote APX.pdf | apx | 2 p. de texto en español: Trabajo/Librería/DTO y utilidades de APX Batch. | alta |
| …/APX BATCH/APX Batch - Conceptos por Lotes.pdf | apx | 6 p. de texto: Job, JobInstance, JobExecution, tipos de pasos. | alta |
| …/APX BATCH/APX Batch - Documentación.pdf | apx | 3 p. de texto: "¿Qué es APX Batch?", Spring Batch, Control-M. | alta |
| …/APX BATCH/Componentes APX BATCH.pdf | apx | Escaneo de 1 p. (vista): "APX Batch Components", en inglés. | alta |
| …/APX BATCH/Conceptos APX Batch.pdf | apx | Escaneo de 8 p. (vistas 1, 5 y 8): Trabajo/JobInstance, tabla de propiedades de JobExecution, "Steps type: Chunk". | alta |
| …/APX BATCH/Creación JOB en APX BATCH.pdf | apx | Escaneo de 1 p. (vista): `apx init job …`. | alta |
| …/APX BATCH/Introducción APX Batch.pdf | apx | Escaneo de 3 p. (vistas 1 y 3): Introduction, Processing strategies, Types of Batch. | alta |
| …/APX ONLINE/2 - APX Online Components.pdf | apx | 2 p.: APX Transaction/Library/DTO. | alta |
| …/APX ONLINE/APX Online Capabilities.pdf | apx | 6 p. Es la copia que conservo del trío de "Capabilities". | alta |
| …/APX ONLINE/DTO/APX Online - Creación DTO.pdf | apx | 2 p.: `apx init dto`. | alta |
| …/APX ONLINE/DTO/APX Online - Extraer un DTO.pdf | apx | 5 p.: DTO en la interfaz de una librería. | alta |
| …/APX ONLINE/DTO/Ejemplo de DTO.pdf | apx | Escaneo de 1 p. (vista): "Init DTO" con APX CLI. | alta |
| …/APX ONLINE/Librerías/APX Online - Librerías MongoDB.pdf | apx | 3 p. de texto. | alta |
| …/APX ONLINE/Librerías/APX Online - Librerías simples.pdf | apx | 2 p. de texto. | alta |
| …/APX ONLINE/Librerías/APX Online - Trabajar con el componente Librería.pdf | apx | 9 p. de texto: APX CLI. | alta |
| …/APX ONLINE/Librerías/Creación de librería.pdf | apx | Escaneo de 1 p. (vista): `apx init lib`. | alta |
| …/APX ONLINE/Transacción/APX Online - Creación de Transacciones.pdf | apx | 8 p. de texto. | alta |
| …/APX ONLINE/Transacción/Ejemplo de Creación de Transacción.pdf | apx | Escaneo de 1 p. (vista): `apx init trx`. | alta |
| …/Documentación APX/APX Qué es.pdf | apx | Escaneo de 1 p. (vista): "¿Qué es APX?". | alta |
| …/Documentación APX/Ether.pdf | otros | 98 p., 86 con texto. "Ether Development Experience" (junio de 2021): plataforma cloud de BBVA, consola, roles, pases a producción. APX aparece 6 veces y solo como uno de los runtimes (junto a ASO, Cells, DataProc…). | media-alta |
| …/Documentación APX/Manual de Ether.pdf | otros | 26 p. de texto. "Ether Software Development Platform – Manual de usuario v0.1": ECS CLI, Stacker. APX aparece 17 veces, siempre como uno más de los runtimes. | media-alta |
| …/Exámenes de apoyo/Exámen Diagnóstico APX 3 (1).pdf | apx | 16 p. de texto, 95 preguntas: unas 93 de APX. Genéricas: la n.º 73 (Mockito/JUnit) y quizá la 19 (definición de patrón de diseño, que aparece en contexto APX). | alta |
| …/Exámenes de apoyo/Examen Diagnóstico APX 4.pdf | apx | Escaneo de 12 p. (vistas las 12): 20 preguntas. 12–13 APX (Contenedor Mágico, acceso a datos, NMM, Datasource, addAdvice, /fichtemporal, capa de control, excepciones com.bbva.apx…), 7 Java (código) y 1 Maven (pom.xml). Es decir, ~62% APX. | media-alta |
| …/Exámenes de apoyo/Exámen Diagnóstico Java.pdf | java | Escaneo de 47 p. "Java Examen" de Google Forms, "Puntos totales 18/53". Vistas las págs. 1–12, 17–20, 25–28, 33–36 y 41–47; **no vi las 13–16, 21–24, 29–32 ni 37–40**. Todo lo visto es Java, salvo pom.xml (Maven), el patrón DTO y el Singleton. | alta |
| …/Exámenes de apoyo/LINKS.docx | otros | Solo 7 enlaces de Google Forms (Java E/DE/D/Sesiones y Diagnóstico APX, APX 3 y APX 5). Sus 197 KB son fuentes incrustadas, no contenido. | alta |
| …/Formularios/Formularios APX.docx | otros | Solo títulos y enlaces a 5 formularios (Google y Microsoft Forms). | alta |
| …/Mapas Mentales/APX BATCH PT1.jpg | apx | Visto reducido: ¿Qué es APX Batch?, Jobs y Steps, JDBC/Mongo utils, diagrama por capas (tiers). | alta |
| …/Mapas Mentales/APX BATCH PT2.jpg | apx | Visto: ShellScriptLauncher, utilidades Oracle y MongoDB. | alta |
| …/Mapas Mentales/APX ONLINE PT1.jpg | apx | Visto: Transacción/Librería/DTO, excepciones, LOGGER, acceso a datos. | alta |
| …/Mapas Mentales/APX ONLINE PT2.jpg | apx | Visto: errores, antipatrones Blob y Contenedor mágico, paginación. | alta |
| …/Mapas Mentales/APX ONLINE PT3.jpg | apx | Visto: patrón CRUD en librerías APX, DTO. | alta |
| …/Material de apoyo/Banco de preguntas - Temas variados.docx | otros | Solo 1 enlace a un perfil de educaplay.com. | alta |
| …/Material de apoyo/Java.pdf | java | 303 p. de texto, título "Rep Examen APX": 212 preguntas resueltas con justificación. Unas **135 Java (64%), 37 APX o Spring Batch (17%) y 39 de herramientas o temas generales (18%)** (Git, Maven, Bash, Jenkins, HTTP, patrones de diseño, BD). | media-alta |
| …/Material Extraído.docx | otros | Solo 3 enlaces: Drive "Material APX" y un Google Doc "ASO Estudio". | alta |
| …/Teoría APX/APX_BATCH.pptx.pdf | apx | 23 p. (títulos de todas): ¿Qué es APX Batch?, Jobs/Steps, utils JDBC/Mongo, ShellScriptLauncher. | alta |
| …/Teoría APX/APX_Online.pptx | apx | 20 diapositivas: What is APX, componentes, librerías, patrones y antipatrones, APX Console, Credentials. | alta |
| …/Teoría APX/Curse_APX_Online.pptx | apx | 57 diapositivas, "APX Online Curso Pedro Alarcon Ortiz": transacción, biblioteca, DTO, excepciones, patrones, LOGGER. Solo ~5% de texto en común con APX_Online.pptx: no es duplicado. | alta |
| 2 - Material APX - parte 1/AcademicosAPX.pdf | no-copiar-duplicado | SHA-256 idéntico a `1 - …/Documentación APX/AcademicosAPX.pdf`. | alta |
| 2 - …/APX Online Capabilities.pdf | no-copiar-duplicado | SHA idéntico a `1 - …/APX ONLINE/APX Online Capabilities.pdf`. | alta |
| 2 - …/APX Qué es.pdf | no-copiar-duplicado | SHA idéntico a `1 - …/Documentación APX/APX Qué es.pdf`. | alta |
| 2 - …/Componentes APX BATCH.pdf | no-copiar-duplicado | SHA idéntico a `1 - …/APX BATCH/Componentes APX BATCH.pdf`. | alta |
| 2 - …/Componentes APX Online.pdf | no-copiar-duplicado (de `1 - …/APX ONLINE/2 - APX Online Components.pdf`) | Hash distinto, pero texto idéntico (diff vacío), el mismo título interno "2 - APX Online Components" y 1 imagen de 40400 frente a 40401 bytes. Render de las 2 páginas equivalente (maxdiff 2/255, 0 píxeles por encima de 40). Es la misma exportación de Google Docs hecha con otro renderizador (m148 frente a m142). | alta |
| 2 - …/Conceptos APX Batch.pdf | no-copiar-duplicado | SHA idéntico a la copia de `1 - …/APX BATCH/`. | alta |
| 2 - …/Creación de librería.pdf | no-copiar-duplicado | SHA idéntico a la copia de `1 - …/APX ONLINE/Librerías/`. | alta |
| 2 - …/Creación JOB en APX BATCH.pdf | no-copiar-duplicado | SHA idéntico a la copia de `1 - …/APX BATCH/`. | alta |
| 2 - …/Ejemplo de Creación de Transacción.pdf | no-copiar-duplicado | SHA idéntico a la copia de `1 - …/APX ONLINE/Transacción/`. | alta |
| 2 - …/Ejemplo de DTO.pdf | no-copiar-duplicado | SHA idéntico a la copia de `1 - …/APX ONLINE/DTO/`. | alta |
| 2 - …/Ether.pdf | no-copiar-duplicado | SHA idéntico a `1 - …/Documentación APX/Ether.pdf`. | alta |
| 2 - …/Introducción APX Batch.pdf | no-copiar-duplicado | SHA idéntico a la copia de `1 - …/APX BATCH/`. | alta |
| 2 - …/Manual de Ether.pdf | no-copiar-duplicado | SHA idéntico a `1 - …/Documentación APX/Manual de Ether.pdf`. | alta |
| 3 - Cuestionarios (Google Forms)/01 - Java E.docx | java | 24 preguntas: 22 Java, 1 Maven (pom.xml) y 1 Singleton. | alta |
| 3 - …/02 - Java DE.docx | java | 25 preguntas, las 25 Java. | alta |
| 3 - …/03 - Java D.docx | java | 24 preguntas: 23 Java y 1 Maven. | alta |
| 3 - …/04 - Java Sesiones.docx | java | 53 preguntas: 50 Java, 1 patrón DTO genérico, 1 Maven y 1 Singleton. | alta |
| 3 - …/05 - Diagnóstico APX.docx | apx | 81 preguntas, "Prueba diagnóstica para APX Online": unas 78–80 APX (normas, logs, Batch, librerías) y 1–3 genéricas (qué es un patrón de diseño). | alta |
| 3 - …/06 - Diagnóstico APX 3.docx | apx | 94 preguntas: unas 92 APX, 1 JUnit/Mockito y 1 definición de patrón de diseño. | alta |
| 3 - …/07 - Diagnóstico APX 5.docx | apx | 85 preguntas en dos secciones del propio formulario: "Sección 2 — APX" con las preguntas 1–62 (61 APX y 1 de patrón de diseño) y "Sección 3 — JAVA" con las 63–85 (23). En total, **73% APX y 27% Java**. | alta |
| 3 - …/08 - Teoría APX.docx | apx | 34 preguntas: 30 APX (incluido el antipatrón), 1 patrón de diseño genérico, 1 Maven, 1 Git y 1 javac. | alta |
| 4 - Simulaciones (Microsoft Forms)/01 - Simulación APX V1.docx | java | 45 preguntas (sin contar el campo "Ingresa tu nombre"): **23 Java (51%), 9 APX (20%) y 13 de herramientas o generales (29%)**. | media |
| 4 - …/02 - Simulación APX V2.docx | java | 45 preguntas (sin el campo de nombre): **19 Java (42%), 15 APX o Spring Batch (33%) y 11 de herramientas o generales (24%)**. | media-baja |
| 4 - …/03 - Cuestionario APX V3.docx | java | 32 preguntas: **27 Java (84%)**, 2 APX y 3 generales (Maven settings.xml, retrocompatibilidad, Bash). | alta |
| 4 - …/04 - Simulación APX V4.docx | java | 41 preguntas: **37 Java (90%)**, 2 APX (nomenclatura de librería, qué es una librería) y 2 generales (Windows `dir`, Gitflow). | alta |
| VIDEOS-Y-ENLACES.md | otros | Metadatos de la extracción: URLs de 11 vídeos de Drive ("Capacitación APX Grupo 1"), de formularios y de enlaces de la intranet. No tiene contenido de estudio propio. | media-alta |

(Ignorados según la instrucción: `.gitignore`, `INDICE.md`, `manifest.json`, `_datos-extraccion/`, `.DS_Store`.)

### Duplicados exactos (SHA-256 completo, 12 pares)
En los 12 pares, la copia de `2 - Material APX - parte 1/` es idéntica byte a byte a la de `1 - Material de estudio - APX/Documentación APX/…`:
- AcademicosAPX
- APX Online Capabilities
- APX Qué es
- Componentes APX BATCH
- Conceptos APX Batch
- Creación de librería
- Creación JOB en APX BATCH
- Ejemplo de Creación de Transacción
- Ejemplo de DTO
- Ether
- Introducción APX Batch
- Manual de Ether

Con los dos casi-duplicados de abajo, la carpeta `2 - …` entera (13 archivos) sobra.

### Casi-duplicados (hash distinto) y cómo los comprobé
1. **`1 - APX Capabilities.pdf` ↔ `APX ONLINE/APX Online Capabilities.pdf`** (este último también está en la carpeta 2). Contenido equivalente: 6 p. en ambos, texto idéntico y render de las 6 páginas idéntico píxel a píxel. Solo cambia la versión del renderizador. Cuál se conserva es arbitrario; conservé la de `APX ONLINE/`.
2. **`APX ONLINE/2 - APX Online Components.pdf` ↔ `2 - …/Componentes APX Online.pdf`.** Equivalentes, con la evidencia de la tabla.
3. **`Exámen Diagnóstico Java.pdf` ↔ `04 - Java Sesiones.docx`. No es duplicado.** Es el mismo formulario: el pie del PDF lleva el ID del form `1FAIpQLSfwDGuVs7Tt_poz2VL…` y ambos tienen 53 preguntas. Encontré 20 de 20 opciones muestreadas del PDF en el .docx. Pero el PDF añade la respuesta correcta, las respuestas de un candidato y anotaciones, así que aporta información (la clave de respuestas). **Ojo: el PDF contiene datos personales** (el correo `armando.molina@accenture.com` y la puntuación 18/53).
4. **`Exámen Diagnóstico APX 3 (1).pdf` (95 preguntas) ↔ `06 - Diagnóstico APX 3.docx` (94).** Es el mismo banco de preguntas en otro orden: comparación difusa, 83 preguntas del PDF con similitud ≥0,8 y el resto confirmadas en su mayoría por búsqueda de cadenas. Hay alguna pregunta propia del PDF (p. ej. "Todo acceso a los datos debe estar encapsulado en una biblioteca…"), y el PDF lleva además una URL de occ.com.mx pegada por error. Muy similares, pero no idénticos.
5. **`Examen Diagnóstico APX 4.pdf` ↔ `07 - Diagnóstico APX 5.docx`.** El PDF es un subconjunto parcial en capturas: 17 de 21 elementos buscados aparecen en APX 5. No es duplicado.
6. **Traducciones o solapes de la misma documentación, sin ser duplicados:**
   - `Componentes APX BATCH.pdf` (inglés, escaneo) ↔ `APX Batch - Componentes del lote APX.pdf` (español, texto): el mismo contenido traducido.
   - `Introducción APX Batch.pdf` (inglés) ↔ `APX Batch - Documentación.pdf` (español): la misma lista de características.
   - `Conceptos APX Batch.pdf` ↔ `APX Batch - Conceptos por Lotes.pdf`: contenido que se solapa (los dos tienen la tabla de JobExecution: fracasoExcepciones, creartiempo).
   - `Ejemplo de DTO` / `Creación de librería` / `Ejemplo de Creación de Transacción` (inglés, 1 p.) ↔ `APX Online - Creación DTO` / `Creación de Transacciones` (español, completos).
7. **`Java.pdf`** cubre la mayoría de las preguntas de las simulaciones de Microsoft Forms. Con coincidencia literal (que se queda corta) encontré en él: V1 36/46, V2 32/46, V3 28/32 y V4 29/41. Añade respuestas y justificaciones, así que no es duplicado.
8. **Entre los formularios** solo hay solapes parciales de preguntas idénticas (p. ej. APX 3 ↔ APX 5: 32; Java Sesiones ↔ APX 5: 15). Ninguno es duplicado.

### Casos dudosos
- **Simulaciones APX V1/V2 (y en menor medida V3/V4) y `Java.pdf`.** Se titulan "APX" porque son de la certificación APX, pero por contenido predomina Java. V2 es el caso más ajustado: 42% Java frente a 33% APX; no hay mayoría y lo decidí por pluralidad. Si el criterio es "examen de certificación APX", irían a `apx`. En V3/V4 el Java es del 84–90%, así que no hay duda.
- **`Ether.pdf` y `Manual de Ether.pdf`.** Tratan de la plataforma Ether, donde también se despliega APX. Por eso los puse en `otros` y no en `apx`, aunque la definición de APX incluye el "despliegue de componentes APX". `AcademicosAPX.pdf`, que habla del despliegue de componentes APX específicamente en Ether, sí lo dejé en `apx`.
- **`VIDEOS-Y-ENLACES.md`.** Lo puse en `otros` porque solo tiene metadatos y enlaces, aunque apunten a vídeos de APX. Además está desactualizado: dice que las simulaciones de Microsoft Forms "no se extrajeron", pero `4 - Simulaciones (Microsoft Forms)/` existe con 4 .docx extraídos (esa carpeta está sin seguimiento en git).
- **`Examen Diagnóstico APX 4.pdf`.** Aunque es mixto (~62% APX y ~35% Java), queda en `apx`.
- **Limitaciones de lo que vi:**
  - En `Exámen Diagnóstico Java.pdf` no vi las págs. 13–16, 21–24, 29–32 ni 37–40 (vi 27 de 47, repartidas por todo el documento).
  - `AcademicosAPX.pdf` lo muestreé (15 de 97 páginas).
  - Los conteos por tema son de un clasificador por palabras clave con revisión manual de lo que no salía como APX. Pueden variar en ±2–3 preguntas por archivo, y en `Java.pdf` 2 de los "fragmentos" eran puntos de una explicación y no preguntas.
