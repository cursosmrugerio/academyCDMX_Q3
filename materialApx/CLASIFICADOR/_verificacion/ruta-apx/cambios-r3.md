# Ronda 3 (27-sep-2026): la opción marcada en color es la correcta

**Decisión del instructor:** «si está marcada en amarillo es una respuesta correcta». Hasta la ronda 2, una pregunta cuya
clave chocaba con la documentación, o era ambigua, iba a «Preguntas sin respuesta confirmada» sin calificar.

- **Entrada:** `cambios-r3.json`, con las preguntas que pasan a calificarse y los retoques de retro.
- **Aplicación:** `aplicar-r3.py` lee `banco-publicado-r2.json` (el banco publicado el 25-sep, intacto) y escribe `banco-final.json`.
- **Dónde queda lo anterior:** en cada pregunta cambiada, en `antes_r3` / `cambios_r3_retro`.

## Resultado

| | Publicado 25-sep (r2) | Ronda 3 |
|---|---|---|
| En autoevaluaciones | 168 (132 doc + 36 clave) | **193** (132 doc + 61 clave) |
| Sin respuesta confirmada | 55 (28 ninguno + 27 contradictorio) | **30** (24 ninguno + 6 contradictorio) |

**25 preguntas pasan a calificarse con su clave:**
- **16 por el amarillo de `Exámen Diagnóstico APX 3 (1).pdf`**, directo o de una pregunta afín cuya respuesta decide esta (G068, G130, G197).
- **2 por el texto de `Java.pdf`:** G089 y G182.
- **7 por el VERDE de `Java.pdf`**, que no se conocía: G049, G052, G054, G073, G212, G215 y G219.

**Retoques de retro, sin cambio de respuesta:**
- G002: el verde de Java.pdf #165 marca solo b y su texto dice «b y c».
- G178: APX3 #21 marca la misma definición como «Paginación de librerías».

**Opciones quitadas:**
- G068: «No se».
- G197: «GUC», que la clave no contempla.
- G198: las compuestas «a, b y c», «a, c y d» y «Todas».

## Hallazgos de la verificación

La verificación la hicieron 4 agentes, en 2 rondas de 2. Sus informes están en `crudos/verif-r3-r*.json`.

- **`Java.pdf` también marca la clave con color: resaltado VERDE**, unas 300 líneas.
  - Coincide con su texto «La respuesta correcta es…» en todos los casos menos #165.
  - El método se puede repetir: rectángulos `re`+`f` del content stream con relleno de color, cruzados con la posición del texto (pypdf). Los casos reportados se confirmaron en la imagen de la página.
- **APX3 tiene un solo resaltado GRIS**, en #47 opción b («TRACE, DEBUG, INFO, WARNING & ERROR»). La amarilla es la d.
- **Contradicciones reales entre claves:**
  1. **Neo4J:** APX3 #57 (amarillo) lo incluye en lo que ofrece Batch. Java.pdf #66 (verde) no lo marca entre las utilidades de Batch. G187 y G212 califican cada una con su clave y lo avisan en la retro.
  2. **Java.pdf #165:** el verde marca solo «Procesamiento transaccional». Su texto, y otras marcas verdes (#66, #104, #137, #160), dan Batch por capacidad.
  3. **APX3 #47 contra #48:** la #47 dice que existen 4 niveles de log, sin TRACE; la #48 dice que esos 4 son «los más comunes». Además está el gris de #47 b, y la diap. 36 documenta LOGGER.trace.
  4. **APX3 #30 contra #31**, probable: #31 («objetivo de trabajar con patrones») no marca la frase que #30 marca como definición. #31 no está en el banco.
- **Devueltas a la página tras probarlas:**
  - **G015 (UID):** APX3 #12 completa otra frase, y Capabilities pág. 6 apoya «ejecución».
  - **G173:** tamaño de página no es lo mismo que el límite de JDBC de Java.pdf #31.
- **145 preguntas calificadas ligadas a una clave coinciden con la marca**, salvo G002. De las 30 que siguen sin calificar, ninguna tiene la misma pregunta marcada en color.
