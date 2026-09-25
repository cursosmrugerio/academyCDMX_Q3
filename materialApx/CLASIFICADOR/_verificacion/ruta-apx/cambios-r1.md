# Cambios de la ronda 1 (banco-v1.json → banco-v2.json)

Generado con `build_v2.py`. Se verifica con `verify_v2.py`: 223 grupos, los 357 ids de miembros sin repetir y los mismos que en v1, 0 errores de reglas. Cada pregunta trae en `cambios_r1` lo que cambió.

Resumen: de los 42 hallazgos se aplicaron 28 (uno de ellos, G109, solo en parte). Otros 7 no pedían cambios (el verificador confirmaba lo que ya estaba) y 7 se rechazaron. Cuatro preguntas pasan de cuestionario a instructor: G068, G085, G143 y G212. Ninguna hace el camino contrario, salvo QZ1-14, que sale de G215 y forma el grupo nuevo G215b, que va a cuestionario.

## Hallazgos

| Grupo | Hallazgo (aspecto, gravedad) | Decisión | Motivo |
|---|---|---|---|
| G003 | La cita solo respalda a (respaldo, baja) | Aplicado | La cita se amplía con dos fragmentos literales de «APX Qué es», pág. 1, y así respalda también b (23 palabras). |
| G004 | «ni depende de él» no está en la fuente (retro, baja) | Aplicado | Comprobado en «APX Qué es», pág. 1: dice «extensión de la plataforma Mainframe» y «reducir su uso», pero nada sobre dependencia. |
| G017 | El diario electrónico figura como post-acción en la pág. 6 (retro, baja) | Aplicado | La retro aclara que la lista de post-acciones es la de la pág. 2 y que el diario se configura aparte (pág. 6). |
| G026 | El modo delegado del diario está «NOT IMPLEMENTED» (retro, media) | Aplicado | Comprobado en Capabilities, pág. 6. |
| G028 | No hay contradicción: el respaldo es «clave» (respaldo, media) | Aplicado | La autorización está «delegated in Logical Security libraries… not coupled» (pág. 4). Sigue en instructor por el casi duplicado a/e. |
| G028 | La retro sugiere una contradicción que no existe (retro, media) | Aplicado | Retro reescrita. Empieza con el aviso de clave y describe las fuentes. |
| G029 | Imagen de la pág. 3 con «XA Driver» (retro, baja) | Rechazado | La frase «Two-Phase Commit no aparece» es literalmente cierta. El cambio era opcional. |
| G030 | Imagen de la pág. 3 con «XA Driver» (retro, baja) | Aplicado | Vi la imagen. Con ella, decir que la documentación «solo dice» commit/rollback era inexacto. |
| G032 | Multi a–e frente a single e (respaldo, baja) | Rechazado | Es una decisión de diseño, no un error. La retro ya avisa de que «Todas» también es correcta. |
| G033 | Imágenes de las págs. 3 y 5 (IMS/CICS en el Host, Interbackend → TRX) (retro, baja) | Aplicado | Vi las imágenes, así que «solo nombra» era inexacto. La retro no señala ninguna opción; el indicio a favor de e queda en la nota. |
| G034 | Lo mismo que G033 (retro, baja) | Aplicado | «Solo la clave…» era inexacto. Se quita «apunta a la opción e» de la retro (es de instructor) y se pasa a la nota. |
| G047 | No hay contradicción propia: el respaldo es «clave» (respaldo, media) | Aplicado | La retro empieza con el aviso de clave. Sigue en instructor por la pareja G048. |
| G054 | «Docker no aparece» es inexacto; Git tiene más respaldo (retro, baja) | Aplicado | Comprobado: Docker aparece en AcademicosAPX, pág. 95 (Chimera); .gitignore en la pág. 4; Bitbucket y ramas en las págs. 25–36 y 48. |
| G068 | El enunciado no dice «entre transacciones» y la clave es de preguntas afines (destino, media) | Aplicado | Pasa de cuestionario a instructor. Candidata d, en la nota. |
| G073 | La nota «Probable e»: b tiene apoyo parcial en la diap. 16 (destino, baja) | Rechazado | No afecta a la retro. **Aviso para el instructor:** la diap. 16 (OCR) muestra addParameter en la clase abstracta, lo que apoya b. |
| G076 | La corrección «scr»→«src» es legítima (fidelidad, baja) | Sin cambio | El verificador la confirma. |
| G085 | Enunciado truncado; a solo por clave; d choca con la diap. 29 (destino, media) | Aplicado | Comprobado en las diaps. 28 y 29 y en APX3 #87. Pasa de cuestionario a instructor y el respaldo queda como «contradictorio». |
| G088 | Respaldo «doc» incoherente con instructor (respaldo, baja) | Aplicado | Respaldo: «contradictorio». La documentación da a, pero no descarta b. |
| G089 | La retro remite a las págs. 2–3, que distinguen recurso y UD (retro, baja) | Aplicado | Comprobado en AcademicosAPX, págs. 2 y 3. La retro lo aclara. |
| G102 | Errata RO01/R001 sin explicar (retro, baja) | Aplicado | La retro avisa de la errata. Además se remapea la fuente (tarea 2). |
| G109 | Solo la clave excluye b (respaldo, media) | Aplicado en parte | Retro y nota. Se mantiene en cuestionario: la clave APX3 #35 es una fuente admitida y G110 también trata b como incorrecta. En la nota se pide al instructor que confirme b. |
| G122 | La corrección «axception» es legítima (fidelidad, baja) | Sin cambio | El verificador la confirma. |
| G123 | «no existen en el paquete business» (retro, baja) | Aplicado | Pasa a «no figuran en la lista» (diap. 24). |
| G127 | «java.util.NumberFormatException no existe» es conocimiento general (retro, baja) | Aplicado | Pasa a «la del paquete java.lang, no java.util». |
| G132 | Respaldo «doc» incoherente con instructor (respaldo, baja) | Aplicado | Respaldo: «contradictorio». a y d son defendibles. |
| G143 | Gemela de G142; b es defendible con la diap. 36 (destino, media) | Aplicado | Pasa de cuestionario a instructor (candidata d). G144 no cambia: su clave (APX3 #48) es esa misma pregunta de V/F. |
| G161 | El enunciado confunde el Blob con BLOB; la retro ya lo corrige (retro, baja) | Sin cambio | Propuesta: ninguna. |
| G163 | La cita no respalda «dividir la clase» y choca con G162 (respaldo, media) | Aplicado | La retro explica la solución real (diap. 46) y queda coherente con G162. Se queda en cuestionario: b y c agravan el Blob y a es la única defendible. «doc (por descarte)» no es un valor válido, así que se deja «doc» y se explica en la nota. |
| G180 | La retro no explica por qué no e (retro, baja) | Rechazado | La retro es correcta; el añadido es de estilo. |
| G186 | La exclusión de a es defendible (respuesta, baja) | Sin cambio | El verificador la confirma. |
| G189 | l dice «listos para usar», pero la documentación solo dice «personalizables» (retro, baja) | Aplicado | Comprobado en APX Batch - Documentación, pág. 1. Decir que «todas aparecen» era inexacto. |
| G193 | La retro no explica el porqué (retro, baja) | Rechazado | Aceptable tal cual (solo hay clave). |
| G195 | «al contrario» es engañoso; APX3 #40 respalda la premisa (retro, media) | Aplicado | Comprobado en APX3 #40 y en la pág. 2. La retro no afirma que la respuesta sea d; la similitud con d queda en la nota. Sigue en instructor. |
| G196 | Todas las opciones son correctas (destino, baja) | Rechazado | Era opcional. La retro sí cambió por la tarea 2. |
| G197 | La corrección del constructor es correcta (respuesta, baja) | Sin cambio | El verificador la confirma. |
| G203 | «de hecho lista el multithreading» sugiere que la premisa es falsa (retro, media) | Aplicado | Retro reescrita con APX3 #40. Sigue en instructor. |
| G204 | Respaldo por diagrama y claves (respaldo, baja) | Sin cambio | Propuesta: ninguna. |
| G209 | Posible duda con chunk (retro, baja) | Rechazado | La retro es exacta; el añadido es opcional. |
| G212 | «AP Connector»→«API Connector» cambia qué opción es correcta (fidelidad, media) | Aplicado | Se restaura «AP Connector» como en el original (V2-2 y JPDF-66) y la pregunta pasa de cuestionario a instructor (candidata a, b, c si se confirma la errata). |
| G212 | Tensión con Neo4J en APX3 #57 (respuesta, baja) | Aplicado | La retro de instructor lo menciona. |
| G215 | QZ1-14 tiene respuesta única propia (grupo, media) | Aplicado | Nuevo G215b: single, b, doc, cuestionario (APX Batch - Documentación, pág. 2, cita comprobada). G215 se queda con V2-39, T08-34 y JPDF-137 en instructor. |
| G216 | «Temporal» deducido de «se eliminará periódicamente» (respaldo, baja) | Sin cambio | Propuesta: ninguna. |

## Cambios fuera de los hallazgos

- **Instructor ⇒ `correctas` vacía.** Ocho preguntas que ya iban a instructor conservaban una candidata en `correctas`: G005, G011, G015, G028, G047, G048, G054 y G182. Ahora está vacía y la candidata pasa a `nota_constructor` («Candidata previa…»).
- **Nombres en las retro (115 preguntas).** «Curse_APX_Online», «Curse diap.» y similares pasan a «la presentación del curso (Curse_APX_Online.pptx)». «corpus» pasa a «la documentación del curso». Los nombres cortos («Trabajar con el componente Librería», «Creación de Transacciones», «Conceptos por Lotes», «Librerías simples», «Extraer un DTO», «AcademicosAPX», «APX_Online») pasan a su nombre de archivo completo.

## Tarea 2: citas a documentos no disponibles

| Grupo | Antes | Ahora | ¿El equivalente dice lo mismo? |
|---|---|---|---|
| G031 | 2 - APX Online Components.pdf, pág. 1 | Curse_APX_Online.pptx, diaps. 3, 4 y 9 (y AcademicosAPX, pág. 3) | La presentación no los agrupa como «componentes»; los trata uno por uno. Anotado en la nota. |
| G036 / G037 / G041 | «…o en 2 - APX Online Components.pdf, pág. 1» | Se deja solo Curse, diap. 9 / 5 / 4 (ya estaban citadas) | Sí. |
| G044 | Componentes APX BATCH.pdf, pág. 1 | APX Batch - Componentes del lote APX.pdf, pág. 1 | Traducción automática: «Job» aparece como «Trabajo» (se avisa en la retro). |
| G102 | Creación de librería.pdf, pág. 1 (fuente, cita, retro) | APX Online - Trabajar con el componente Librería.pdf, págs. 1–2 y 9 | No enuncia la regla «R + código»: la muestra con TESTR001 (pág. 2) y con el patrón [UUAA]R[CODE] (pág. 9). Anotado en la nota. |
| G191 / G196 | Conceptos APX Batch.pdf, pág. 8 (fuente, cita, retro) | APX Batch - Conceptos por Lotes.pdf, pág. 6 (G191, además, el mapa mental APX BATCH PT1) | No del todo: la traducción automática llama a ItemReader e ItemProcessor «Lector de artículos» y «Procesador de artículos». La retro lo avisa. |
| G192 | Conceptos APX Batch.pdf, pág. 8 (fuente, cita, retro) | APX Batch - Conceptos por Lotes.pdf, págs. 5–6 | En español: Lector / Procesador / Escritor. |
| G212 | Componentes APX BATCH.pdf, pág. 1 (fuente, cita, retro) | APX Batch - Componentes del lote APX.pdf, pág. 1 | Traducción automática: Normas = Rules, Caparazón = Shell, Fusionar/ordenar = Merge/sort. |
| G213 | «…o Conceptos APX Batch.pdf, pág. 8» | Se deja solo APX Batch - Conceptos por Lotes, págs. 5–6 | Sí. |
| G214 | Componentes APX BATCH.pdf, pág. 1 | APX Batch - Componentes del lote APX.pdf, pág. 1 | «Job» = «Trabajo». |
| G187 (nota) | Componentes APX BATCH, pág. 1 | APX Batch - Componentes del lote APX, pág. 1 | Sí. |

Ninguna `retro`, `fuente` ni `cita` cita ya «Ejemplo de Creación de Transacción», «Ejemplo de DTO» ni «Introducción APX Batch». Tampoco los citaba v1.
