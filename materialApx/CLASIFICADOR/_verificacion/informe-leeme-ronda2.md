# Informe del verificador adversarial, ronda 2: `CLASIFICADOR/LEEME.md` y `otros/enlaces-originales/README.md`

Otro agente, distinto del de la ronda 1, revisó el 25-sep-2026 la versión ya corregida
tras la ronda 1. Se transcribe su informe en forma resumida. Al final se indica qué se hizo.

**Resumen del verificador:** hay un error grave que la ronda 1 no vio, y que su corrección 12
dejó por escrito: `Examen Diagnóstico APX 4.pdf` **no trae respuestas correctas**. El resto
son problemas de redacción u orden. La integridad está bien: sha256, enlaces y rutas viejas.

## Hallazgos

1. **Alta. `Examen Diagnóstico APX 4.pdf` no es una clave de respuestas.**
   - Se extrajeron sus 22 imágenes a resolución original. En 20 de las 21 preguntas hay una
     opción marcada con palomita azul: es el formulario contestado por alguien.
   - Varias marcas están mal:
     - Pág. 3: marca «JDBC». El curso dice DataSource (`Curse_APX_Online.pptx`,
       diapositiva 21; `Exámen Diagnóstico APX 3 (1).pdf`, P71).
     - Pág. 6: marca `/temporalFiles/datent` y subraya `/fichtemporal/datent`. La respuesta
       es `/fichtemcomp/datent` (`APX_BATCH.pptx.pdf`, pág. 16).
     - Pág. 9: la pregunta del constructor de `Sub`.
     - Pág. 11: marca «Gamma gamma.», y la respuesta es «Compilation fails».
     - Pág. 12: «bad practices».
     - Pág. 8: la opción marcada no coincide con la explicación recuadrada.
   - Otras marcas sí son correctas (págs. 4 y 10): es una mezcla.
   - Afecta al LEEME, que decía que se revisara ahí, que contaba «4 PDF» con respuestas y
     que ponía «En algunas páginas, subrayadas». También afecta a `INDICE-PREGUNTAS.md`
     l. 563 («Escaneo… Algunas páginas marcan la respuesta»).
2. **Media. El orden de las preguntas no coincide en ningún par de «Repetidos».**
   - Ocurre también en 06 frente al PDF de APX 3, y en 04 frente a `Exámen Diagnóstico Java.pdf`.
   - `Exámen Diagnóstico Java.pdf` no tiene texto seleccionable.
3. **Media-baja. §1, paso 6, mandaba buscar preguntas de APX en los mixtos de `java/`.**
   `Java.pdf` es uno de ellos y viene resuelto, lo que contradice la regla de §2 de
   practicar primero.
4. **Media-baja. El LEEME no mencionaba ASO.** Quien tenga acceso a Drive verá
   `Material extra - ASO.docx` al lado de `Formularios APX.docx`.
5. **Baja.** «08, el más corto» solo es cierto entre los `.docx`: APX 4 tiene 21 preguntas.
6. **Baja. Jerga en la nota de numeración.** «Serie de origen» no se entiende, y no
   se nombraban los archivos del 01 al 04 de Google Forms.
7. **Baja. Jerga interna en el README de `enlaces-originales`.**
   - «Registro», «ID de formulario», «carpeta de descarga», «lo generamos».
   - Las rutas relativas a `CLASIFICADOR/` no se aclaraban.
   - `VIDEOS-Y-ENLACES.md` dice «en esta carpeta» y cita `RECURSOS-SIN-ACCESO.md`, que no
     está en `CLASIFICADOR/`.
   - El título «no son material de estudio» chocaba con los videos.
8. **Baja. `APX_Online.pptx`: son «la mayoría», no «casi todas», en inglés.**
   - Tiene 9 diapositivas en inglés, 4 en español y 7 solo con imagen.
   - `Curse_APX_Online.pptx` menciona la consola de pasada (diapositivas 35 y 37).
9. **Baja. No se decía cómo revisar los exámenes sin clave:** 05, 07, 08, Java E, DE y D, y
   los quizzes.
10. **Baja. Cada `.docx` de examen empieza con el enlace al formulario en línea y con
    «Enlazado desde».**
11. **Baja, opcional.** También hay alguna pregunta de Java suelta en 08 (P33) y en 06 (P16).

## Sin objeción (resumen)

- **Correcciones de la ronda 1:** todas quedaron bien aplicadas, menos la 12.
- **Mapeo enlace → archivo:** los 3 documentos más Banco, por hipervínculo.
- **`Exámen Diagnóstico Java.pdf`:** se contaron las 53 preguntas en las 46 páginas (1 punto
  cada una). Muestra «Respuesta correcta» donde el intento falló.
- **Los 15 conteos de los `.docx`:** coinciden, y ninguno tiene resaltado.
- **Otros datos del catálogo:**
  - V3 y V4 traen 2 preguntas de APX cada uno.
  - La numeración por plataforma es correcta.
  - Coinciden «152 actividades», `Material extra - ASO.docx` y los datos de los videos.
  - APX 4: ≥17 de sus 21 preguntas están en 07.
  - Simulaciones dentro de `Java.pdf`: V1 41/45, V2 36/45, V3 28/32 y V4 35/41.
- **Integridad:** las 90 filas del registro coinciden en sha256. Los enlaces relativos
  resuelven, no quedan rutas viejas vivas y la fila de `INDICE.md` es correcta.

## No verificado por el verificador

- El «152 actividades» no tiene un dato crudo en `_datos-extraccion/` para recontarlo.
- El idioma de las 7 diapositivas de `APX_Online.pptx` que son solo imagen.
- Quién hizo las marcas de APX 4.
- Si **todas** las marcas amarillas de `Exámen Diagnóstico APX 3 (1).pdf` son correctas.
  Solo se vio la pág. 11, y coincide con el curso.
- Los permisos de Drive de los videos.

## Qué se hizo

- **Hallazgo 1:** se comprobó por separado. En la pág. 6, en la pregunta de `blipvert`
  («Choose five»), el intento marca `protected long blipvert(int x)`, que no compila, y deja
  sin marcar `protected long blipvert(int x, int y)`, que sí compila. `APX_BATCH.pptx.pdf`,
  pág. 16, dice `/fichtemcomp/datent`. Se corrigió:
  - En el LEEME, APX 4 aparece como **«No»** en la columna de respuestas, con el aviso de no
    usarlo para revisar.
  - El LEEME cuenta **3 PDF** con respuestas.
  - «Repetidos» se reescribió, y se quitó la frase «revísalas ahí» de §1, paso 6.
  - Se añadió un aviso general: las respuestas de los PDF nadie las ha validado una por una,
    y si contradicen la documentación, manda la documentación.
  - Se corrigió `INDICE-PREGUNTAS.md` l. 563.
  - Se añadió una nota «→» fechada al informe de la ronda 1.
- **Hallazgos 2–10:** corregidos en el LEEME y en el README de `enlaces-originales`.
- **Hallazgo 11:** no se tocó. Lo cubre la nota de que «APX» o «Java» significa «casi todo».
- **No se tocaron** los registros de verificación que dicen «página escaneada» en
  `indice-clasificacion-a-ciegas.tsv`: son evidencia histórica.

→ **25-sep-2026, tras la ronda 3** ([`informe-leeme-ronda3.md`](informe-leeme-ronda3.md)):
- La lista de páginas de APX 4 con marcas erróneas estaba incompleta: también fallan la
  pág. 4 izquierda (el identificador único se genera como *primer* paso, según
  `APX Online Capabilities.pdf`) y la pág. 8. En total, al menos 8 de las 20 marcas. Arriba
  se dice que las marcas de la pág. 4 son correctas: solo lo es la de la derecha.
- El orden de §1, paso 6, hacía revisar en el PDF de APX 3 antes de practicar `07`, que
  comparte con él cerca de la mitad de las preguntas. Se reordenó.
