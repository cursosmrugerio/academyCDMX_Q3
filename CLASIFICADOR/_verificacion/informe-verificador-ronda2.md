## Informe de verificación, ronda 2

No escribí nada en `materialApx/` (`git status` sigue limpio). Todos los temporales están en `…/scratchpad/verif2/`.

### Cómo conté
Leí cada pregunta con su texto, sus opciones y sus imágenes. Revisé todas las imágenes de código de 4/V3, 4/V4 y las 3 de Educaplay, y una muestra de las de la carpeta 3.

**Criterios de tema:**
- **APX:** la pregunta nombra un concepto o componente de APX/BBVA, o una norma de la arquitectura APX.
- **Java:** lenguaje, JDK y API estándar, JUnit o Mockito.
- **Generales:** Git, Maven, Bash o Windows, Jenkins, Jira, Sonar, Postman, JBoss, bases de datos, HTTP, SemVer, patrones genéricos (Singleton, Builder, Command, «qué es un patrón»), conceptos genéricos de Spring Batch y definiciones genéricas de niveles de log.

**Cómo detecté duplicados:** un script compara el enunciado normalizado y, si no basta, que al menos el 75 % de las opciones distintivas coincidan (descarto opciones comunes como «Compilation fails»). Compara las 15 .docx entre sí y contra `Java.pdf` y `Exámen Diagnóstico APX 3 (1).pdf`, los únicos con capa de texto. Comprobé a mano una muestra de coincidencias. El script está en `scratchpad/verif2/overlap_strict.txt`.

### (1) TAREA A

| Ruta | Categoría | Conteo (APX / Java / Generales) | Cambio frente a ae91c7e | Confianza |
|---|---|---|---|---|
| 3/01 - Java E | java | 24 preguntas: 0 / 22 (92 %) / 2 (Q14 Singleton, Q21 Maven) | Ninguno de contenido: todas las piezas del zip son idénticas; solo cambian las fechas del zip (10:29→11:20) | alta |
| 3/02 - Java DE | java | 25: 0 / 25 (100 %) / 0 | Igual que 01 (solo fechas) | alta |
| 3/03 - Java D | java | 24: 0 / 22 (92 %) / 2 (Q19 Maven, Q20 Builder) | Solo fechas | alta |
| 3/04 - Java Sesiones | java | 53: 0 / 50 (94 %) / 3 (Q5 patrón DTO, Q8 Maven, Q18 Singleton) | Solo fechas | alta |
| 3/05 - Diagnóstico APX | apx | 81: 63 (78 %) / 1 (Q74 JPA) / 17 (21 %) | Único con cambio real, en `document.xml`: 14 opciones que antes estaban vacías ahora dicen «Otro: ____ (respuesta libre)» (Q12, 13, 19, 33, 38, 39, 46, 57, 58, 60, 62, 69, 78, 79). Mismas 81 preguntas, sin clave de respuestas. No afecta la clasificación | alta |
| 3/06 - Diagnóstico APX 3 | apx | 94: 81 (86 %) / 1 (Q16 @Mock) / 12 (13 %) | Solo fechas | alta |
| 3/07 - Diagnóstico APX 5 | apx | 85: 53 (62 %) / 22 (26 %) / 10 (12 %) | Solo fechas | alta |
| 3/08 - Teoría APX | apx | 34: 25 (74 %) / 2 (Q28 OSGi, Q33 javac) / 7 (Q11–13 patrones, Q16 Maven, Q17 Git, Q20 step y Q34 Spring Batch) | Solo fechas | alta |
| 4/01 - Simulación APX V1 | **java** | 45: 9 (20 %) / 23 (51 %) / 13 (29 %) | — | media |
| 4/02 - Simulación APX V2 | **java** | 45: 12 (27 %) / 19 (42 %) / 14 (31 %) | — | media-baja |
| 4/03 - Cuestionario APX V3 | **java** | 32: 2 (Q13, Q14) / 27 (84 %) / 3 (Maven, retrocompatibilidad, Bash) | — | alta |
| 4/04 - Simulación APX V4 | **java** | 41: 2 (Q27, Q41) / 37 (90 %) / 2 (dir, Gitflow) | — | alta |
| 5/01 - Quiz APX | **java** | 22: 5 (23 %) / 8 (36 %) / 9 (41 %) | — | baja-media |
| 5/02 - Quiz Desarrollo APX 1 | empate (java por 1 pregunta) | 25: 11 (44 %) / 12 (48 %) / 2 (8 %) | — | baja |
| 5/03 - Quiz Desarrollo APX 2 | java | 24: 4 (17 %) / 14 (58 %) / 6 (25 %: Git ×3, Maven ×3) | — | media-alta |
| RECURSOS-SIN-ACCESO.md | no-copiar (alternativa: otros) | — (informe de la extracción: carpeta sin acceso, 403/410 y 74 enlaces a la intranet de BBVA) | Archivo nuevo | media |
| VIDEOS-Y-ENLACES.md | otros (alternativa: no-copiar) | — (11 URLs de videos de Drive más una tabla-índice de los cuestionarios extraídos) | Se recortó: la parte de recursos sin acceso pasó a RECURSOS-SIN-ACCESO.md | media |

**Preguntas «generales» por archivo, para poder auditar:**
- **05:** Q13, 21, 27, 33, 36, 38, 44, 49, 53, 54, 58, 62, 63, 68, 76, 78, 81.
- **06:** Q15, 37, 47, 49, 66–72, 84.
- **07:** Q8, 11, 36–41, 61, 78. En 07, la sección «JAVA» es Q63–85.

**Detalle de 4/V1:**
- APX: Q1, 4, 7, 14, 16, 21, 23, 41, 45.
- Generales: Q3, 8, 10, 17, 18, 19, 24, 25, 32, 35, 37, 40, 42.

**Detalle de 4/V2:**
- APX: Q2, 7, 12, 16, 18, 20, 22, 27, 31, 33, 40, 41.
- Generales: Q3, 4, 9, 10, 14, 17, 19, 28, 29, 32, 36, 39, 43, 44.

**Detalle de Educaplay:**
- **Quiz APX:** APX son Q18–22; Java, Q2–9; el resto, generales. Su propia URL se llama `desafio_java_fundamentos`.
- **Desarrollo APX 1:** APX son Q9, 10, 11, 16, 17, 18, 20–23, 25. Si Q24 (@Mock) se cuenta como herramienta, queda 11 contra 11.

**Tensión de criterio que debes decidir tú:** las simulaciones de Microsoft Forms se titulan «APX», pero por contenido son mayoritariamente Java. Las marqué java para ser coherente con la ronda 1, que puso `Java.pdf` en java. Si prefieres agrupar por «examen de certificación APX», entonces `Java.pdf` y las simulaciones deberían ir juntos a apx.

### (2) TAREA B: revisión de la ronda 1

**Objeciones concretas (duplicados que la ronda 1 no detectó):**
1. **`Exámen Diagnóstico Java.pdf` y `3/04 - Java Sesiones.docx` son el mismo formulario.** El pie de cada página del PDF muestra el mismo ID de formulario que 04 (`…/1FAIpQLSfwDGuVs7Tt_poz2VLjAZiBR201ORAWjIDWG1o7zt5Dr-jTfQ/viewscore`). El PDF es una respuesta ya calificada del 17/10/22, con «Respuesta correcta».
   - Abrí las páginas 13–16, 21–24, 29–32 y 37–40. Las 17 preguntas que contienen están todas en 04.
   - La categoría java es correcta; el problema es la duplicación. El PDF aporta la clave de respuestas, así que si se descarta uno debería ser la .docx.
2. **`Exámen Diagnóstico APX 3 (1).pdf` y `3/06 - Diagnóstico APX 3.docx`:** 92 de 94 preguntas coinciden.
   - El PDF («Examen APX Certificación», 95 preguntas) marca en amarillo la respuesta correcta; lo vi en las páginas 1 y 16. La .docx no tiene respuestas.
   - Las 7 preguntas del PDF que el script no encontró en 06 son casi todas diferencias de redacción. Solo la Q76 del PDF («Todo acceso a los datos… biblioteca») puede faltar de verdad.
3. **`Examen Diagnóstico APX 4.pdf` es en gran parte un subconjunto de `3/07 - Diagnóstico APX 5`.**
   - Vi sus 12 páginas escaneadas, unas 21 preguntas: unas 13 APX, 7 Java y 1 genérica. La categoría apx es correcta.
   - Casi todas sus preguntas están en 07: seguridad lógica, «la información utilizada…», acciones posteriores, NMM, Datasource, /fichtemporal, addAdvice, blipvert, Super/Sub, bad practices, Alpha/Beta/Gamma. No encontré en 07 la pregunta de la página 1 sobre el pom.
   - Algunas páginas marcan respuestas.
4. **Casi-duplicados de contenido dentro de la carpeta 1 (el mismo texto de platform.bbva.com, en otro formato o traducido).** Ninguno es duplicado byte a byte. Todos son apx, así que no cambian la clasificación; solo lo informo.
   - `APX BATCH/Componentes APX BATCH.pdf` (1 diapositiva en inglés) tiene el mismo contenido que `APX Batch - Componentes del lote APX.pdf`.
   - `Introducción APX Batch.pdf` equivale a la página «Introducción» de `APX Batch - Documentación.pdf`.
   - `Conceptos APX Batch.pdf` tiene los mismos textos (Job, JobInstance, JobExecution) que `APX Batch - Conceptos por Lotes.pdf`.
   - `Ejemplo de DTO.pdf`, `Ejemplo de Creación de Transacción.pdf` y `Creación de librería.pdf` son extractos de sus guías (mismos comandos `apx init dto|trx|lib`).
   - Solo vi la página 1 de cada PDF en imagen, más una búsqueda en el texto de los PDF que sí tienen texto.

**Sin objeción (y qué abrí):**
- **Los 12 duplicados por SHA-256 entre las carpetas 2 y 1:** los recalculé; son idénticos. No hay otros duplicados por SHA en el repo.
- **`Componentes APX Online.pdf` frente a `2 - APX Online Components.pdf`:** mismo texto y renderizado de 2/2 páginas con diferencia máxima de 2 niveles de gris.
- **`1 - APX Capabilities.pdf` frente a `APX ONLINE/APX Online Capabilities.pdf`:** mismo texto y 6/6 páginas idénticas en píxeles (diferencia 0), aunque tienen distinto SHA y tamaño (1.585.227 frente a 1.605.047 bytes).
- **AcademicosAPX:** vi las páginas 3, 7, 13, 21, 29, 37, 45, 53, 61, 69, 77, 85 y 93. Tratan el despliegue de componentes APX: unidades de despliegue, estructura de librería, recurso Statics, modelo de ramas y rama release, PR en Bitbucket, Testing en APX con Sonar al 80 %, Deploy Request, doble autorización, Cronos, rollback de librería Online/Batch y gobierno de versiones. Encaja en apx, con confianza media: cerca de la mitad es flujo genérico de Git, Bitbucket, Jenkins y Ether.
- **Ether.pdf y Manual de Ether.pdf:** plataforma Ether (DX, Consola, pases a producción). APX aparece solo 6 y 17 veces, como uno de sus runtimes. Correcto en otros.
- **Material Extraído, LINKS, Formularios APX y Banco de preguntas:** solo contienen enlaces. Banco de preguntas tiene únicamente la URL del perfil de Educaplay, cuyos quizzes están ahora en la carpeta 5. Correcto en otros.
- **Teoría APX:** APX_Online.pptx (20 diapositivas en inglés) y Curse_APX_Online.pptx (57 en español) no son duplicados (similitud 0,31). APX_BATCH.pptx.pdf es APX Batch.
- **Mapas Mentales:** vi las 5 imágenes; todas son APX.
- **`Java.pdf`:** la categoría java es coherente con mi conteo de las simulaciones. Pero su encabezado dice «Rep Examen APX»: es el repositorio resuelto de las simulaciones de Microsoft Forms (ver punto 3).
- **Menor:** hay 5 `.DS_Store` sin rastrear en git, entre ellos `CLASIFICADOR/.DS_Store`, que la propuesta no menciona. Deberían ir a no-copiar.

### (3) Duplicados y casi-duplicados nuevos
- **Carpeta 4 frente a `Java.pdf`:** está contenida casi entera.
  - V1: 40/45 (89 %)
  - V2: 39/45 (87 %)
  - V3: 29/32 (91 %)
  - V4: 32/41 (78 %)
  - Lo confirmé con fragmentos numerados en las imágenes («9.», «57.», «107.», «152.»…) y con clases como StringInternExample, RecursiveConstructorTest y NestedForLoopTest, que están en `Java.pdf`. `Java.pdf` además trae las respuestas justificadas.
  - Entre las simulaciones también se repiten preguntas: V4 comparte 6 con V1 y V2 comparte 6 con V3.
- **06 frente a `Exámen Diagnóstico APX 3 (1).pdf`:** 98 %, casi-duplicado.
- **04 Java Sesiones frente a `Exámen Diagnóstico Java.pdf`:** mismo formulario.
- **07 Diagnóstico APX 5:** comparte 46/85 preguntas con 06 y con el PDF de APX 3, y 13 con 04 Java Sesiones. La mayor parte de `Examen Diagnóstico APX 4.pdf` está dentro de 07.
- **5/02 Quiz Desarrollo APX 1:** es una recopilación. 12/25 preguntas coinciden literalmente con Diagnóstico APX 3 (PDF y 06), y unas 10 más son traducciones al español de Java D, Java DE, Java Sesiones y 07 (JDBC, throws/throw, h1/h2, SampleClass, bad practices, 6564, hello/default, @Mock).
- **5/01 Quiz APX:** 6/22 coinciden con `Java.pdf` y 4/22 con V2.
- **Carpeta 3:** Java E, Java DE, Java D y Java Sesiones comparten muchas preguntas entre sí (entre 17 % y 38 % por pareja). Son versiones, no duplicados.

### (4) Lo que no pude verificar
- No volví a contar las 212 preguntas de `Java.pdf` ni sus porcentajes. Mi intento automático no fue fiable porque el texto viene con una palabra por línea.
- En `Exámen Diagnóstico Java.pdf` no vi las páginas fuera de las cuatro series indicadas, así que no confirmé que las 53 preguntas de 04 estén todas en él.
- En los PDF en imagen de la carpeta 1 (Conceptos, Introducción, Ejemplos) solo vi la página 1, salvo en Conceptos (páginas 1, 4 y 8). El solapamiento que describo es parcial y cualitativo.
- El conteo de `Examen Diagnóstico APX 4.pdf` es aproximado: está escaneado y lo leí a baja resolución.
- Las coincidencias de solo imagen se detectan por opciones y pueden tener algún falso positivo o negativo. Tomé como fiables los porcentajes altos (78–98 %) y los confirmé con muestras; los bajos (menos del 20 %) son orientativos.
- La frontera Java/APX/generales es un criterio mío; dejo los IDs de pregunta listados para que se pueda auditar. Las clasificaciones de baja confianza son 5/01, 5/02 y 4/V2.
