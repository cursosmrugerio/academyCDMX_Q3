# Material de estudio APX y Java: empieza aquí

Todo lo que hay que estudiar ya está descargado en esta carpeta y ordenado por tema.
**No necesitas abrir enlaces ni buscar en Drive.** La única excepción son los videos, que se
ven en línea (ver §1).

Puede que te hayan compartido documentos que solo tienen enlaces: `Formularios APX.docx`,
`LINKS.docx`, `Material Extraído.docx` o `Banco de preguntas - Temas variados.docx`.
**No son exámenes nuevos:**
- Los enlaces a exámenes llevan a archivos que ya están aquí, a veces con otro nombre.
- Los demás llevan a documentación ya copiada aquí, a material que está en revisión
  (`otros/dudas/`) o a material de otros temas que no forman parte de este curso. Por
  ejemplo, el material de ASO («ASO Estudio» y «Material extra - ASO.docx», si lo ves en
  Drive) no se estudia aquí.

La equivalencia enlace por enlace está en
[`otros/enlaces-originales/README.md`](otros/enlaces-originales/README.md).

## Qué hay en cada carpeta

| Carpeta | Qué contiene | ¿Se estudia? |
|---|---|---|
| `apx/` | Documentación, presentaciones, mapas mentales y exámenes de APX | **Sí** |
| `java/` | Solo exámenes y bancos de preguntas. Todos tienen más Java que APX, aunque varios se llamen «APX» | **Sí** |
| [`INDICE-PREGUNTAS.md`](INDICE-PREGUNTAS.md) | El tema (APX, Java o herramientas) de cada pregunta de los 8 exámenes mixtos | Herramienta de estudio |
| `otros/enlaces-originales/` | Los documentos con enlaces de los que salió este material | No: solo referencia |
| `otros/dudas/` | Material que falta confirmar con la empresa ([ver por qué](otros/dudas/README.md)) | **No**, por ahora |
| `_verificacion/` | Registros internos de cómo se clasificó el material | No |

## 1. APX: qué estudiar y en qué orden

En Moodle, la sección **«Ruta de estudio APX»** tiene este mismo recorrido, con una
autoevaluación en las etapas 1 a 10: al fallar una pregunta te dice la respuesta y dónde estudiarla.
Aquí está el mismo orden con los archivos de esta carpeta.

Tres documentos los usan varias etapas; cada una te dice qué páginas o diapositivas leer:
- `apx/teoria/Curse_APX_Online.pptx` (57 diapositivas, en español). En la lista, «Curso, diap. N»
  significa esta presentación.
- `apx/teoria/APX_Online.pptx` (20 diapositivas, casi toda en inglés). En la lista, «APX_Online,
  diap. N».
- `apx/general/AcademicosAPX.pdf` (97 páginas).

1. **Qué es APX y cómo ejecuta una petición:** Curso, diap. 2; `apx/online/APX Online
   Capabilities.pdf` (6 páginas, en inglés), y APX_Online, diap. 2 (el nombre en inglés).
   Si el inglés te cuesta, Curso, diap. 18–20 y 30–32, traen en español el texto de las
   págs. 2–5 de Capabilities; mira de todos modos en el PDF la pág. 1 (las 8 capacidades de
   APX), los diagramas de las págs. 2–3 y la pág. 6 (servicios bancarios).
2. **Componentes de APX Online** (transacción, librería, DTO y utilidades): Curso, diap. 3–9,
   y AcademicosAPX, págs. 2–3 (qué componentes van en online y en batch).
3. **Herramientas: entorno, APX CLI y consola:** Curso, diap. 33–35; AcademicosAPX, pág. 48
   (qué es APX CLI), y APX_Online, diap. 12–20 (Operation Console y credenciales).
4. **DTO:** `apx/online/APX Online - Creación DTO.pdf`, Curso, diap. 26 y 55–56, y
   APX_Online, diap. 7 (diagrama del DTO entre transacción y librería). Va antes que la
   transacción y la librería porque las dos lo usan como dependencia.
5. **Transacción:** `apx/online/APX Online - Creación de Transacciones.pdf` y Curso,
   diap. 10–17, 29 y 39–41.
6. **Librería:** `apx/online/APX Online - Trabajar con el componente Librería.pdf`,
   `APX Online - Librerías simples.pdf`, `APX Online - Librerías MongoDB.pdf` y, al final,
   `APX Online - Extraer un DTO.pdf`, que supone que ya conoces la librería. Además,
   Curso, diap. 27, 28 y 38.
7. **Acceso a datos y excepciones:** Curso, diap. 21–25.
8. **Logs, errores y estilo de código:** Curso, diap. 36–37 y 49.
9. **Patrones y antipatrones:** Curso, diap. 42–48 y 50–54, y APX_Online, diap. 8–11 (Blob y
   Contenedor mágico con diagramas y cómo refactorizarlos). Para repasar todo APX Online:
   mapas mentales `apx/mapas-mentales/APX ONLINE PT1` a `PT3`.
10. **APX Batch**, en `apx/batch/` y en este orden: `APX Batch - Documentación.pdf`,
    `APX Batch - Conceptos por Lotes.pdf`, `APX Batch - Componentes del lote APX.pdf` y
    `Creación JOB en APX BATCH.pdf`. Después, `apx/teoria/APX_BATCH.pptx.pdf` desde la
    pág. 3. Para repasar: mapas mentales `APX BATCH PT1` y `PT2`.
11. **Del código a producción:** AcademicosAPX, págs. 1, 4–47 y 49–97 (las demás ya las viste
    en las etapas 2 y 3): ramas, pull requests, pipeline, despliegue y rollback. Léelo como contexto: los exámenes casi no lo preguntan.

**Versiones repetidas (no hace falta leerlas):**
- `apx/general/APX Qué es.pdf` es idéntico a Curso, diap. 2.
- `2 - APX Online Components.pdf` es lo mismo que Curso, diap. 3–9, en inglés.
- `Ejemplo de Creación de Transacción.pdf`, `Ejemplo de DTO.pdf` y `Creación de librería.pdf`
  son extractos en inglés de las guías de las etapas 4 a 6.
- `Introducción APX Batch.pdf`, `Conceptos APX Batch.pdf` y `Componentes APX BATCH.pdf`
  repiten los tres primeros de la etapa 10, en inglés o en otro formato.
- De `APX_Online.pptx`, las diapositivas 3 a 6 repiten la presentación del curso.

Las guías en español de `apx/online/` y `apx/batch/` son traducción automática: «Fragmento» es
Chunk, «Lector de artículos» es ItemReader, «Caparazón» es Shell, «servicios de descanso» son
servicios REST… En Moodle, la descripción de cada documento trae las equivalencias. Para los tres documentos
de Batch y los comandos `apx init`, la versión en inglés trae el término original.

**Practicar.** Las 223 preguntas distintas de APX que hay en los exámenes de práctica están
en las autoevaluaciones de la «Ruta de estudio APX» o en su página «Preguntas para resolver
con el instructor». Si además quieres practicar con los exámenes originales de
`apx/examenes/` (ver el catálogo, §3):
- Practica en este orden: `08 - Teoría APX.docx` (34 preguntas, el `.docx` más corto de esta
  carpeta), `05 - Diagnóstico APX.docx`, `07 - Diagnóstico APX 5.docx` y
  `06 - Diagnóstico APX 3.docx`.
- **Al terminar los cuatro**, revisa en `Exámen Diagnóstico APX 3 (1).pdf`. Ahí están casi
  todas las de `06` y cerca de la mitad de las de `07`.
- Las que no estén en ese PDF no tienen clave ahí. Unas pocas de `08` las resuelve
  `java/Java.pdf` (el repaso final de §2); el resto no tiene clave en ningún archivo. La Ruta
  de Moodle las responde con la documentación o las deja en «Preguntas para resolver con el
  instructor».
- **No uses `Examen Diagnóstico APX 4.pdf` para revisar respuestas.** Sus marcas son el
  intento de alguien, y varias están mal (ver §3). Si lo usas para practicar, tapa las
  marcas; de todos modos, la mayoría de sus preguntas ya están en `07`.
- Los exámenes mixtos de `java/` también traen preguntas de APX. Para encontrarlas, usa
  [`INDICE-PREGUNTAS.md`](INDICE-PREGUNTAS.md), **menos `Java.pdf`**, que ya viene resuelto y
  se deja para el repaso final de §2.

**Videos:** son 11 grabaciones de la «Capacitación APX Grupo 1», del 14-jun al 2-jul-2021.
No se descargaron porque pesan 1.9 GB. Están en esta carpeta de Google Drive, y puede que
necesites pedir acceso:
https://drive.google.com/drive/folders/1Dm7jXVn4HcRsXNhlb_2Z2JH7E81--kJx

## 2. Java: qué estudiar y en qué orden

Este material **no trae teoría de Java: solo exámenes.** Los exámenes con más Java están en
`java/`. También hay preguntas de Java en `apx/examenes/07 - Diagnóstico APX 5.docx` (de la 63
a la 85) y en `Examen Diagnóstico APX 4.pdf`.

**Primero practica y después revisa las respuestas.** Si lees antes los PDF resueltos, ya
sabrás las respuestas de las simulaciones.

1. **Practica** con los exámenes que no traen respuestas:
   - `01 - Java E.docx`, `02 - Java DE.docx` y `03 - Java D.docx`;
   - `04 - Java Sesiones.docx`;
   - las simulaciones: `01 - Simulación APX V1.docx`, `02 - Simulación APX V2.docx`,
     `03 - Cuestionario APX V3.docx` y `04 - Simulación APX V4.docx`;
   - los quizzes: `01 - Quiz APX.docx`, `02 - Quiz Desarrollo APX 1.docx` y
     `03 - Quiz Desarrollo APX 2.docx`.

   Las preguntas de APX de estas simulaciones y quizzes ya las viste resueltas en la Ruta
   de estudio APX (§1); aquí cuenta sobre todo el Java.
2. **Revisa** tus respuestas en los PDF resueltos:
   - `04 - Java Sesiones` en `Exámen Diagnóstico Java.pdf`, que es el mismo examen;
   - las simulaciones en `Java.pdf`.
   - `02 - Quiz Desarrollo APX 1`: cerca de la mitad de sus preguntas están en
     `apx/examenes/Exámen Diagnóstico APX 3 (1).pdf`.
   - La mayoría de las preguntas de `Java E`, `Java DE`, `Java D` y de los otros 2 quizzes
     no tienen respuesta en ningún archivo. Compruébalas por tu cuenta (por ejemplo,
     compilando el código) o pregúntale al instructor.
3. **Repaso final:** `java/Java.pdf`. Tiene 213 preguntas **resueltas**, casi siempre con
   la justificación. Aunque se llama «Java», su encabezado dice «Rep Examen APX»: es el
   repaso del examen. Trae 134 preguntas de Java, 38 de APX y 41 de herramientas. Ahora
   estudia las preguntas que no habías visto en las simulaciones. Sus 38 de APX ya están
   en la Ruta de estudio APX (§1): en sus autoevaluaciones o en su página del instructor.

## 3. Catálogo de exámenes (19)

Los exámenes están en **dos carpetas**:
- `apx/examenes/` guarda los que son sobre todo de APX.
- `java/` guarda los que tienen más Java que APX, **aunque se llamen «APX»**. Por ejemplo,
  `Simulación APX V1` trae 23 preguntas de Java y 9 de APX.

**Los números de los archivos** (`01`, `02`…) indican el lugar de cada examen en la
plataforma de la que salió: Google Forms del 01 al 08, Microsoft Forms (las simulaciones)
del 01 al 04 y Educaplay (los quizzes) del 01 al 03. **No indican un orden de estudio ni que
falte alguno.** Por ejemplo, `apx/examenes/` empieza en `05` porque los Google Forms del
`01` al `04` son `01 - Java E`, `02 - Java DE`, `03 - Java D` y `04 - Java Sesiones`, que
están en `java/`.

**Tema:** «APX» o «Java» significa que *casi todo* el examen es de ese tema, no todo. Por
ejemplo, `03 - Cuestionario APX V3` y `04 - Simulación APX V4` traen 2 preguntas de APX
cada uno. «Mixto» son los 8 exámenes que tienen el tema de cada pregunta en
[`INDICE-PREGUNTAS.md`](INDICE-PREGUNTAS.md).

**Respuestas:** ningún `.docx` trae respuestas, porque los formularios en línea no las
muestran. Solo 3 PDF las traen: `Java.pdf`, `Exámen Diagnóstico Java.pdf` y
`Exámen Diagnóstico APX 3 (1).pdf`. Nadie las ha validado una por una: si alguna
contradice la documentación de `apx/`, confía en la documentación.

### En `apx/examenes/`

| Archivo | Preguntas | Tema | ¿Respuestas? | En los documentos de enlaces se llama… | Notas |
|---|---|---|---|---|---|
| `05 - Diagnóstico APX.docx` | 81 | APX | No | «Diagnóstico APX» (`LINKS.docx`) | |
| `06 - Diagnóstico APX 3.docx` | 94 | APX | No | «Diagnóstico APX 3» (`LINKS.docx`) y «Examen Diagnóstico APX 3» (`Formularios APX.docx`) | Casi igual a `Exámen Diagnóstico APX 3 (1).pdf` |
| `07 - Diagnóstico APX 5.docx` | 85 | Mixto: sección APX de la 1 a la 62 y sección JAVA de la 63 a la 85 | No | «Diagnóstico APX 5» (`LINKS.docx`) | Incluye la mayoría de las preguntas de `Examen Diagnóstico APX 4.pdf` |
| `08 - Teoría APX.docx` | 34 | APX | No | «Teoria APX» (`Formularios APX.docx`) | |
| `Exámen Diagnóstico APX 3 (1).pdf` | 95 | APX | **Sí**, resaltadas en amarillo | — | Casi igual a `06` |
| `Examen Diagnóstico APX 4.pdf` | 21 | Mixto | **No.** Trae marcadas las opciones que eligió alguien al contestarlo, y varias están mal: al menos 8 de sus 20 marcas (págs. 3, 4, 6, 8, 9, 11 y 12). **No las uses para revisar** | — | Son capturas de pantalla, sin texto seleccionable. La mayoría de sus preguntas están en `07` |

### En `java/`

| Archivo | Preguntas | Tema | ¿Respuestas? | En los documentos de enlaces se llama… | Notas |
|---|---|---|---|---|---|
| `Java.pdf` | 213 | Mixto | **Sí**, justificadas | — | Contiene la mayoría de las preguntas de las simulaciones V1 a V4 |
| `Exámen Diagnóstico Java.pdf` | 53 (según su total de puntos) | Java | **Sí**: es un intento ya calificado que muestra la respuesta correcta | — | Mismo examen que `04 - Java Sesiones.docx` |
| `01 - Java E.docx` | 24 | Java | No | «Java E» (`LINKS.docx`) | |
| `02 - Java DE.docx` | 25 | Java | No | «Java DE» (`LINKS.docx`) | |
| `03 - Java D.docx` | 24 | Java | No | «Java D» (`LINKS.docx`) | |
| `04 - Java Sesiones.docx` | 53 | Java | No | «Java Sesiones» (`LINKS.docx`) y **«Java Examen»** (`Formularios APX.docx`) | Mismo examen que `Exámen Diagnóstico Java.pdf` |
| `01 - Simulación APX V1.docx` | 45 | Mixto | No | «SImulación APX V1» (`Formularios APX.docx`) | Casi todas sus preguntas están en `Java.pdf`; algunas, traducidas al inglés |
| `02 - Simulación APX V2.docx` | 45 | Mixto | No | «Simulacion APX V2» (`Formularios APX.docx`) | La mayoría están en `Java.pdf` |
| `03 - Cuestionario APX V3.docx` | 32 | Java | No | **«Simulación APX V3»** (`Formularios APX.docx`) | La mayoría están en `Java.pdf` |
| `04 - Simulación APX V4.docx` | 41 | Java | No | «Simulación APX V4» (`Formularios APX.docx`) | La mayoría están en `Java.pdf` |
| `01 - Quiz APX.docx` | 22 | Mixto | No | — (quiz de Educaplay) | |
| `02 - Quiz Desarrollo APX 1.docx` | 25 | Mixto | No | — (quiz de Educaplay) | Recopilación: casi la mitad de sus preguntas vienen de «Diagnóstico APX 3» |
| `03 - Quiz Desarrollo APX 2.docx` | 24 | Mixto | No | — (quiz de Educaplay) | |

**En ningún par de repetidos coincide el orden de las preguntas.** Para encontrar una
pregunta en la versión con respuestas, búscala por el enunciado:
- En `Java.pdf`, si no aparece, búscala por el código o por las opciones: algunas están
  allí en inglés.
- `Exámen Diagnóstico Java.pdf` es solo imagen (46 páginas de preguntas) y no se puede
  buscar con Ctrl+F: hay que recorrerlo a ojo.

### Repetidos: cómo aprovecharlos

No se borró ningún examen. Donde hay dos versiones, **practica con la que no trae
respuestas y revisa tus respuestas en la que sí las trae**:

| Practica con… | Revisa en… |
|---|---|
| `apx/examenes/06 - Diagnóstico APX 3.docx` | `apx/examenes/Exámen Diagnóstico APX 3 (1).pdf` |
| `java/04 - Java Sesiones.docx` | `java/Exámen Diagnóstico Java.pdf` |
| `java/01 - Simulación APX V1.docx`, `02 - Simulación APX V2.docx`, `03 - Cuestionario APX V3.docx` y `04 - Simulación APX V4.docx` | `java/Java.pdf` |

`Examen Diagnóstico APX 4.pdf` y `07 - Diagnóstico APX 5.docx` comparten la mayoría de sus
preguntas, pero **ninguno de los dos sirve para revisar**: el `.docx` no trae respuestas, y
las marcas del PDF son el intento de alguien, con errores.

## 4. Lo que no se estudia por ahora

`otros/dudas/` tiene 4 documentos sobre el **proceso** de BBVA (la plataforma Ether y los
tickets de JIRA para dar de alta o modificar componentes). No enseñan a programar en APX.
Falta confirmar con la empresa si hay que estudiarlos, y mientras tanto **no forman parte
del temario ni de los exámenes**. El motivo de cada uno está en su
[README](otros/dudas/README.md).

## 5. Sobre los enlaces originales

- **No practiques en los formularios en línea.** Pueden registrar tu respuesta. Además, las
  simulaciones de Microsoft Forms tienen un límite de 90 minutos y se envían solas al
  acabarse el tiempo.
- Al principio de cada `.docx` de examen, bajo el título, hay unas líneas («Formulario
  original» o «Actividad original», «Enlazado desde» o «Enlazada desde»…) que solo dicen de dónde salió el
  examen: **ignóralas**.
- `Banco de preguntas - Temas variados.docx` **no trae preguntas**: solo tiene el enlace a
  un perfil de Educaplay con 152 actividades. Solo 3 son de APX: los 3 quizzes, que ya están
  en `java/`. Las demás (Spark, IA, inglés, Oracle…) no son de este curso y no se
  descargaron. No hay nada pendiente sobre ellas.
- Si alguien te manda un enlace y no sabes a qué archivo corresponde, búscalo en
  [`otros/enlaces-originales/README.md`](otros/enlaces-originales/README.md).
