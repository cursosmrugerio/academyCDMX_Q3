# Verificación adversarial · Ruta de estudio APX · ronda 2

Revisado (a mitad de la revisión el instructor renombró los archivos `26_*` → `27_*`; solo cambió el nombre y «script 26» → «script 27»):
- `moodle/build/27_ruta_estudio_apx.json` (antes `26_…`). Lo regeneré con `27_generar_plan.py --out=…` y sale **byte a byte idéntico**, así que el plan corresponde al generador y al banco del repo.
- `moodle/build/27_generar_plan.py`.
- `CLASIFICADOR/LEEME.md` §1 y la nota de §2, punto 3 (y el diff).
- `_verificacion/ruta-apx/banco-final.json` (el del repo, 13:19; el del scratchpad, 13:14, es anterior: le faltan los cambios de G003, G004, G005 y G008).
- Fuentes: `corpus/`, `txt/*.ocr.txt` y páginas de PDF renderizadas con PDFKit (Capabilities pág. 1; Conceptos por Lotes págs. 1, 2 y 4; Conceptos APX Batch pág. 6).

El informe de la ronda 1 lo leí **después** de terminar mi revisión.

Recuento: **0 altas · 4 medias · 10 bajas.**

---

## MEDIA

### M1. Las retroalimentaciones nombran archivos que el alumno no ve con ese nombre en Moodle
- **Dónde:** `preguntas[].retro` (y la página del instructor) frente a los `nombre` de los recursos.
- **Qué está mal:**
  - La intro de cada cuestionario promete «dónde estudiarla (documento y página)».
  - Pero las retroalimentaciones citan el nombre del archivo: «APX Batch - Documentación.pdf» (9 veces), «APX Batch - Conceptos por Lotes.pdf» (≥6), «APX Online - Creación de Transacciones.pdf», «APX Online - Creación DTO.pdf», «Creación JOB en APX BATCH.pdf», «APX_BATCH.pptx» (sin «.pdf»), «APX_Online.pptx», «AcademicosAPX.pdf», «mapa mental APX ONLINE PT1»…
  - En Moodle esos recursos se llaman, por ejemplo, «📘 ¿Qué es APX Batch?», «📘 APX Batch — conceptos: Job, Step, Chunk y Tasklet», «📘 Crear una transacción con APX CLI», «📘 Crear un job con APX CLI», «📊 Presentación APX Batch», «📊 Presentación corta APX Online» o «🗺️ Mapa mental · APX Online (1 de 3)».
  - El recurso se muestra con `showtype`/`showsize`, no con el nombre del archivo, y ningún texto del curso da la equivalencia. El alumno tiene que adivinar que «APX Batch - Documentación.pdf» es «¿Qué es APX Batch?».
  - Solo es inmediato en «Curse_APX_Online.pptx», porque casi todas las retros dicen «la presentación del curso (Curse_APX_Online.pptx)».
- **Propuesta (generador, al construir `retro` y el bloque de la página del instructor):**
  1. Crear un mapa `NOMBRE_ARCHIVO → nombre en Moodle` a partir de `ARCH`, añadiendo los alias `APX_BATCH.pptx` → `b-pres` y `APX ONLINE PT1/2/3` y `APX BATCH PT1/2` → mapas.
  2. Sustituir en el texto, por ejemplo, «APX Batch - Documentación.pdf» por «“¿Qué es APX Batch?” (APX Batch - Documentación.pdf)».
  3. Alternativa mínima: añadir a la intro de cada recurso «Archivo: `<nombre>`» con `showdesc=1`, o poner una tabla de equivalencias en «Antes de empezar».

### M2. Notas de traducción automática: correctas, pero incompletas, y la etapa 10 promete lo que un recurso no tiene
Las cuatro notas que ya existen las comprobé contra el texto y son correctas:
- trx pág. 2: los 8 subcomandos se corresponden uno a uno.
- b-doc pág. 1: «servicios de descanso».
- b-concep págs. 5–6: Fragmento, Lector/Procesador de artículos, leerContar, escribirContar.
- b-comp pág. 1: Servicios públicos, Normas, Caparazón, Fusionar/ordenar.

Faltan estas, que confunden igual o más:
- **`doc-b-job` (Creación JOB en APX BATCH):**
  - El documento es traducción automática: «Creación de empleos», «Iniciar trabajo», «Código de solicitud (UUAA)», «Código de trabajo».
  - No tiene descripción (`intro` vacía, `showdesc` 0).
  - Sin embargo, la guía de la etapa 10 dice de los cuatro documentos: «Son traducción automática: **su descripción trae las equivalencias** de los términos». Para b-job es falso.
  - **Propuesta:** `intro` = «Traducción automática: «Creación de empleos» / «Iniciar trabajo» = crear / iniciar un job (apx init job); «Código de solicitud» = código de aplicación (UUAA); «Código de trabajo» = código del job.»
- **`doc-b-doc`:**
  - «Integración con **programadores**: Control-M» significa *schedulers* (planificadores). El original inglés, `Introducción APX Batch.pdf`, dice «Integration with schedulers».
  - «Spring Batch no es un **marco de programación**» significa «not a *scheduling* framework». Tal como está, dice lo contrario de lo que quiere decir.
  - Afecta directamente al objetivo de la etapa 10 («… desde Control-M») y a G189 (opción i: «Integración con planificadores»).
  - **Propuesta:** añadir a la intro «; «programadores» = planificadores (schedulers, como Control-M); «no es un marco de programación» = no es un framework de planificación (scheduling); «Planificación de puestos de trabajo» = planificación de jobs».
- **`doc-b-concep`:**
  - Todo el documento dice «Trabajo», «Paso», «Instancia de trabajo» y «Ejecución del trabajo».
  - El nombre del recurso y el objetivo de la etapa dicen Job, Step, JobInstance y JobExecution.
  - Las retros G044 y G214 ya lo aclaran («Trabajo» = Job); la descripción del recurso no.
  - **Propuesta:** anteponer «Trabajo = Job; Paso = Step; Instancia/Ejecución de trabajo = JobInstance/JobExecution; cometerContar = commitCount;».
- **`doc-lib` (Trabajar con el componente Librería):**
  - No tiene nota, y es la guía más estropeada.
  - Págs. 5 y 8: el **código Java salió traducido**: «paquete java…; importar …; clase abstracta pública TESTR001Abstract extiende AbstractLibrary implementa TESTR001», «ServicioDeConfiguraciónDeAplicación protegido…», «&lt;/frijoles&gt;».
  - También: «Modificar Librería de resúmenes» = clase abstracta de la librería; «frijol» = bean; «andamio» = scaffold (esqueleto); «Librería de paquetes» = librería *bundle*; «apx add depy» = `apx add dep` + «y».
  - **Propuesta:** `intro` = «Traducción automática. El código Java de las págs. 5 y 8 salió traducido (importar = import; clase abstracta pública … extiende … implementa = public abstract class … extends … implements). «Librería de resúmenes» / «biblioteca abstracta» = la clase abstracta (TESTR001Abstract); «frijol» = bean; «andamio» = esqueleto (scaffold); «Librería de paquetes» = librería (bundle).»
- **Menores:**
  - trx pág. 5: «Entrar:» = `apx show in`. Pág. 7: «Acompañar a la puerta:» = `apx show out`. Pág. 1: «Código de solicitud» = código de aplicación.
  - lib-mongo pág. 2: «conector implementado por datos» = implementado por Datio (la dependencia es `com.datiobd`).
  - Añadir estas equivalencias a las intros de trx y lib-mongo.

### M3. La guarda «ninguna retro manda a un documento que no se sube» es una lista negra (fail-open)
- **Dónde:** `27_generar_plan.py`, bloque «Ninguna retroalimentación puede mandar a un documento que no se sube».
- **Qué está mal:**
  - La guarda busca, literalmente, el nombre base de cada omitido (`nom in retro`).
  - Deja pasar variantes, por ejemplo: «APX Online Components» sin el «2 - », «Componentes APX Batch» con otra capitalización o «Qué es APX.pdf».
  - Deja pasar también cualquier documento que no sea un omitido. Hoy las retros citan «Java.pdf» 4 veces, un examen que no se sube, aunque en contexto de clave y no de «estúdialo».
  - Hoy no hay ninguna fuga: lo comprobé con búsqueda laxa, sin distinguir mayúsculas y con paráfrasis. Pero la guarda no lo garantiza.
- **Propuesta (allowlist):**
  ```python
  PERMITIDOS = {os.path.basename(p) for p, _, _ in ARCH.values()} | {'APX_BATCH.pptx'}
  CLAVES_OK = {'Java.pdf'}   # solo como fuente de clave, nunca «Estúdialo en»
  for b in BANCO:
      for m in re.findall(r'[\w .()-]+?\.(?:pdf|pptx|docx|jpg)', b['retro'] or ''):
          m = m.strip().split(' en ')[-1].split(' y ')[-1]
          if m not in PERMITIDOS | CLAVES_OK: sys.exit(f"ABORTA: {b['grupo']} cita «{m}», que no se sube")
      if re.search(r'(Estúdialo|Ver)[^.]*Java\.pdf', b['retro'] or ''): sys.exit(...)
  ```
  Y validar también los mapas citados sin extensión («mapa mental APX ONLINE PT1»).

### M4. LEEME §1 («Practicar»): «Las que no estén en ese PDF **no tienen clave en ningún archivo**» es falso
- **Dónde:** `LEEME.md`, §1, bloque «Practicar», tercer punto. Es la redacción que propuso la ronda 1 en su L11.
- **Qué está mal:**
  - `java/Java.pdf` resuelve varias preguntas de `08 - Teoría APX` que no están en `Exámen Diagnóstico APX 3 (1).pdf`.
  - En el banco hay 8 grupos que juntan un miembro de 05/07/08 con uno de `Java.pdf` y ninguno de 06: G003, G032, G182, G184, G083, G089, G206 y G215.
  - Ejemplo: la retro de G182 dice «Java.pdf #168 marca Falso» (T08 #27).
- **Propuesta:** «Las que no estén en ese PDF no tienen clave ahí; unas pocas de `08` las resuelve `java/Java.pdf` (repaso final, §2) y el resto no tiene clave en ningún archivo. La Ruta de Moodle las responde con la documentación o las deja en «Preguntas para resolver con el instructor».»

---

## BAJA

- **B1. Simulacro: «Hazlo cuando termines las 10 etapas»** (intro del cuestionario `quiz-simulacro`), pero la ruta tiene 11. La ronda 1 lo señaló (L2) y no se cambió.
  - Propuesta: «Hazlo cuando termines las etapas 1 a 10 (la 11 no tiene autoevaluación).»
- **B2. «Una autoevaluación» por etapa.**
  - El resumen de la sección dice «11 etapas: qué estudiar en cada una, en qué orden y una autoevaluación…».
  - El LEEME dice «con una autoevaluación por etapa».
  - La etapa 11 no tiene autoevaluación.
  - Propuesta: «…y, en las etapas 1 a 10, una autoevaluación…» (sección) y «con una autoevaluación en las etapas 1 a 10» (LEEME).
- **B3. `Conceptos APX Batch.pdf` (omitido) trae un diagrama que el sustituto perdió.**
  - Su pág. 6 tiene el diagrama Job → Step / JobInstance → JobExecution → StepExecution.
  - En `APX Batch - Conceptos por Lotes.pdf`, pág. 4, esa imagen está rota: solo sale el texto alternativo «Paso». Lo comprobé renderizando la página.
  - El motivo «los mismos conceptos de Batch, en otro formato» es inexacto. Es el L10 de la ronda 1, sin resolver.
  - Propuesta: cambiar el motivo a «los mismos conceptos, en español (págs. 1–5) e inglés (6–8); solo se pierde el diagrama Job/Step/StepExecution de su pág. 6». Como alternativa, citar ese diagrama en la intro de b-concep.
- **B4. G194 manda a `APX_BATCH.pptx.pdf, pág. 2`**, la página que la etapa 10 y el recurso dicen saltar («la 2 repite ¿Qué es APX?»).
  - Propuesta: cambiar esa cita por «Curse_APX_Online.pptx, diap. 2» (la etapa 1 ya la manda).
- **B5. Etapa 11: «AcademicosAPX: completo»** vuelve a asignar las págs. 2–3 y 48, que ya son de las etapas 2 y 3. El texto lo reconoce, pero la regla es «no repetir».
  - Propuesta: «{academicos}: el resto (págs. 1, 4–47 y 49–97), como contexto…». En el LEEME: «AcademicosAPX, págs. 4–47 y 49–97».
- **B6. LEEME: «Si un término no te cuadra, la versión en inglés trae el original»** generaliza de más.
  - Solo hay versión inglesa de los `init` de DTO, transacción y librería, y de los tres documentos de Batch.
  - `Conceptos APX Batch.pdf` además está en español en sus págs. 1–5.
  - No la hay para la guía de librería, librerías simples y MongoDB, Extraer DTO, Creación JOB ni las págs. 2–8 de transacciones.
  - Propuesta: «…para los tres documentos de Batch y los `apx init`, la versión en inglés trae el original».
- **B7. LEEME §2 frente a la Ruta.**
  - §2 dice «Primero practica y después revisa… Si lees antes los PDF resueltos, ya sabrás las respuestas de las simulaciones».
  - Pero las autoevaluaciones de §1 ya muestran resueltas las preguntas de APX de las simulaciones y quizzes: V1 9, V2 15, V3 2, V4 2, QZ1 6, QZ2 11 y QZ3 4.
  - La nota nueva de §2.3 solo lo dice de `Java.pdf`.
  - Propuesta: añadir en §2.1 «Las preguntas de APX de estas simulaciones y quizzes ya las viste en la Ruta de estudio APX; aquí cuenta sobre todo el Java».
- **B8. Generador: docstring desactualizado.** Dice «banco-final.json — 222 preguntas únicas»; son 223.
- **B9. Generador: escape frágil en «Estudia».** `s = e(s) if '{{cm:' not in s and '<a ' not in s else s`.
  - Cualquier elemento que contenga `CURSO(...)` ya trae `<a …>` y se inserta sin escapar el resto del texto.
  - Hoy no hay `&`, `<` ni `>`, así que no rompe nada, pero un «A&B» futuro saldría como HTML crudo.
  - Propuesta: construir con marcadores (`{curso:2}`) y escapar antes de sustituir, igual que se hace con `{capab}`.
- **B10. Cinco preguntas múltiples tienen todas sus opciones correctas:** G122, G125, G181, G196 y G204.
  - Las fracciones son coherentes (las correctas suman 1 y no hay incorrectas).
  - Pero marcar todo da el 100 %, así que no discriminan.
  - Propuesta: aceptarlo, o convertirlas en única con la opción «Todas», si existe en el original.

---

## Estado de los hallazgos de la ronda 1

| R1 | Estado | Comprobación |
|---|---|---|
| H1 retros citan omitidos | **Resuelto** | G031, G036, G037, G041, G044, G102, G191, G192, G196, G212, G213 y G214 citan ya documentos que se suben, con páginas correctas: Conceptos por Lotes, pág. 6, trae «Lector de artículos»; Librería, págs. 1–2 y 9, la nomenclatura R. Búsqueda laxa: ningún omitido citado. Se añadió la guarda, pero es de lista negra (M3). |
| H2 APX_Online.pptx | **Resuelto** | Asignación 2→E1, 7→E4, 8–11→E9, 12–20→E3; 3–6 repetidas (3 = Curso 5, imagen idéntica; 4 = Curso 7; 5 = Curso 43; 6 = Curso 53–54); 1 portada. Nombre, intro y LEEME coinciden. |
| M1 alternativa en español de Capabilities | **Resuelto** | Curso 18–20 = pág. 2–3; 30 = pág. 3; 31 = pág. 4; 32 = diagrama de la pág. 5. La pág. 1 (8 capacidades, verificada en imagen) y la 6 se mandan al PDF. |
| M2 traducción automática | **Mal resuelto en parte** | Las 4 notas son correctas, pero la frase añadida a la etapa 10 («su descripción trae las equivalencias») es falsa para b-job. Faltan notas clave (b-doc «programadores»/«marco de programación», doc-lib con código Java traducido): ver M2. |
| M3 Creación de librería | **Resuelto** | Objetivo de la etapa 6 con UUAA + R + código; motivo del omitido corregido; G102 cita la guía española. |
| M4 AcademicosAPX / APX CLI | **Resuelto** (opción a) | Etapa 2, págs. 2–3; etapa 3, pág. 48 (verificada: «APX CLI que nos permitirá crear y añadir componentes…»); la etapa 11 lo reconoce (ver B5). |
| M5 Control-M | **Resuelto** | Lista de utilidades igual a b-comp pág. 1; Shell Script Launcher desde Control-M = APX_BATCH págs. 18 y 21. |
| L1 b-pres | **Resuelto** | La pág. 1 es la portada y la 2 repite «¿Qué es APX?» (verificado). |
| L2 «10 etapas» / completitud | **Resuelto a medias** | «Antes de empezar» corregido; la intro del simulacro sigue igual (B1). |
| L3 plural | **Resuelto** | La lógica singular/plural está en el generador (hoy todas las etapas tienen ≥ 2). |
| L4 «especiales» | **Resuelto** | Ahora dice «específicas». |
| L5 nombre de APX_Online | **Resuelto** | «casi toda en inglés». |
| L6 APX Qué es | **Resuelto** (se omitió) | G003, G004, G005 y G008 citan ya Curso, diap. 2. Nota: no es «idéntico», sino el mismo contenido con otra redacción («Admite»/«Apoya»…). Irrelevante. |
| L7 objetivos de la etapa 1 | **Resuelto** | |
| L8 DTO en la interfaz | **Resuelto** | |
| L9 APX_BATCH desde la pág. 3 | Aceptado, sin cambio | Correcto. |
| L10 diagrama perdido | **No resuelto** | B3. |
| L11 «Practicar» / Java.pdf | **Mal resuelto** | La nota de §2.3 es correcta (38 miembros JPDF en el banco). La nueva frase «no tienen clave en ningún archivo» es falsa (M4). |

**Mal resueltos: 2** (M2 en parte y L11). **Sin resolver o a medias: 2** (L10 y L2).

---

## Comprobado sin objeción

- **Reproducibilidad:** `27_generar_plan.py` regenera exactamente `27_ruta_estudio_apx.json`. El sha256 de los 20 archivos coincide con el registro. La guarda «documentos de apx/ sin decidir» cubre los 28 archivos no-examen: 20 en la ruta y 8 omitidos.
- **Números:**
  - Banco: 223 grupos. 168 van a cuestionario (132 con respaldo «doc» y 36 con «clave») y 55 a instructor (28 «ninguno» y 27 «contradictorio»). Suman 357 apariciones en 13 exámenes.
  - Por etapa: 26 / 9 / 9 / 8 / 12 / 15 / 24 / 21 / 18 / 26 / 0 en cuestionario y 4 / 9 / 4 / 2 / 6 / 8 / 3 / 3 / 4 / 10 / 2 en instructor.
  - Coinciden con las etiquetas, la intro («223 distintas… 168… 55»), la página del instructor (55 bloques en 11 `<h3>`), el LEEME y `categorias` (10 etapas; la 11 sin cuestionario ni categoría).
- **Preguntas (168):**
  - Cada opción empieza por su letra original y coincide carácter a carácter con `banco-final.json`.
  - Las letras con huecos (p. ej. `bcde`) son intencionadas: `answernumbering='none'` y `shuffleanswers=0` en el PHP.
  - Única: exactamente una a 1.0 y el resto a 0.
  - Múltiple: las correctas suman 1 (0.5, 0.3333333, 0.25 o 0.1428571) y las incorrectas son negativas. Las letras correctas coinciden con `correctas`.
  - `idnumber` únicos. Las 168 están en exactamente un cuestionario, el de su `paso`.
  - Las 36 de respaldo «clave» empiezan por «Respuesta tomada de la clave del examen», como anuncia la intro.
  - Ninguna retro cita páginas o diapositivas fuera de rango: Curso ≤ 57, APX_Online ≤ 20, Académicos ≤ 97, Capabilities ≤ 6, etc.
  - Referencias a letras que no existen en su pregunta: ninguna.
- **Enlaces `{{cm:…}}`:** todas las claves referidas existen (56 claves). Ninguna pregunta contiene `{{`.
- **Asignación sin repetición:**
  - Curso: 2 y 18–20 y 30–32 → E1; 3–9 → E2; 33–35 → E3; 26 y 55–56 → E4; 10–17, 29 y 39–41 → E5; 27, 28 y 38 → E6; 21–25 → E7; 36–37 y 49 → E8; 42–48 y 50–54 → E9. Sin solapes. Sin asignar solo la 1 (portada) y la 57 (vacía, solo el logo).
  - APX_Online: ver H2.
  - AcademicosAPX: ver B5.
  - Los 17 recursos restantes están en una sola etapa. Los 3 comunes van una vez en «Antes de empezar».
- **Contenido de cada rango (leído en el corpus):**
  - Curso: 2 = qué es APX; 3–9 = transacción, librería, estrategia, utilidades específicas y comunes, DTO; 10–17 = campos de entrada y salida y clase abstracta (OCR); 18–20 = pila de ejecución; 21–22 = normas Oracle (JDBC/JPA, BIND, esquema, DataSource, ROWNUM); 23–25 = excepciones; 26 y 55–56 = DTO (obligatoriedad, Bundle, jerarquías sin ciclos); 27 = dependencias circulares; 28 = APIConnector y sin código funcional en la interfaz; 29 = Mainframe (máximo dos invocaciones); 30–31 = capa de datos y seguridad; 32 = diagrama de interoperabilidad; 33–35 = Maven/JDK, Artifactory, entorno local; 36 = LOGGER; 37 = errores por UUAA; 38 = visibilidad; 39–41 = asíncronas y perfilado; 42–48 = patrones, Blob y Contenedor mágico; 49 = inglés, reutilización, sin sysout; 50–54 = paginación y CRUD.
  - APX_Online: 12–20 = Operation Console y credenciales; 7 = diagrama del DTO; 8–11 = antipatrones con diagramas.
  - Académicos: pág. 2–3 = recursos y unidades de despliegue; pág. 48 = APX CLI; pág. 80 = rollback.
  - Capabilities: pág. 1 = 8 capacidades (verificado en imagen); pág. 6 = servicios bancarios.
  - APX_BATCH: págs. 15–22 = Shell Script Launcher y Control-M.
- **Objetivos de cada etapa:** cubiertos por lo que se manda estudiar, en las 11 etapas.
- **Omitidos frente a su sustituto:**
  - `APX Qué es` = Curso 2.
  - `2 - APX Online Components` = Curso 3–9, que además añade «Gestor de documentos».
  - `Ejemplo de DTO` = Creación DTO, pág. 1.
  - `Ejemplo de Creación de Transacción` = Transacciones, pág. 1.
  - `Creación de librería` → Librería, págs. 1–2 y 9.
  - `Introducción APX Batch` = b-doc, págs. 1–2; su diagrama de capas está como imagen en b-doc, pág. 2.
  - `Componentes APX BATCH` = b-comp, pág. 1.
  - `Conceptos APX Batch` ≈ b-concep, que además trae Tasklet y los contadores. Salvo B3.
- **LEEME §1:** rangos, orden y omitidos (8) coinciden con el plan. La nota de §2.3 («Sus 38 de APX ya están en la Ruta») es correcta: 38 miembros `JPDF` distintos en el banco.
- **Textos al alumno:** sin erratas.
  - «Se marca completa con 7 de 10» coincide con el PHP (`grade=10`, `gradepass=7`, `completionpassgrade=1`).
  - «Intentos ilimitados» = `attempts=0`.
  - «al comprobar cada respuesta» = `immediatefeedback`.
  - Simulacro: 40 al azar de `rutaapx` con subcategorías (168 disponibles).
