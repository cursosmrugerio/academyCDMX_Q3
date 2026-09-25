# Informe del verificador adversarial, ronda 1: `CLASIFICADOR/LEEME.md` y `otros/enlaces-originales/README.md`

Verificador independiente (otro agente), 25-sep-2026. Revisó la primera versión, antes del
commit. Se transcribe su informe; solo se omitió el correo de la persona que aparece en
`Exámen Diagnóstico Java.pdf`. Al final se indica qué se hizo con cada hallazgo.

**Resumen del verificador:** los datos duros están bien: mapeos por ID, conteos, sha256,
enlaces relativos y páginas. Los problemas son de redacción y de orden:
- El orden de estudio de Java contradecía la regla de practicar sin respuestas y revisar después.
- Algunas frases absolutas contradecían el propio material.
- El perfil de Educaplay tiene 152 actividades, no «sus 3 quizzes».

## Hallazgos

1. **Alta.** El orden de estudio de Java contradecía la sección «Repetidos».
   - §2 decía que se empezara por `Java.pdf`, que viene resuelto. «Repetidos» pedía practicar con V1–V4 y revisar después en `Java.pdf`.
   - La ronda 2 midió V1 40/45, V2 39/45, V3 29/32 y V4 32/41 dentro de `Java.pdf`. En V1, las 5 que faltan también están, pero en inglés.
2. **Media.** Frases absolutas del inicio: «No necesitas abrir ningún enlace», «cada uno de sus enlaces lleva a un archivo que ya está aquí, aunque con otro nombre» y «no son material extra».
   - Los videos no se descargaron.
   - «ASO Estudio» no está.
   - «Material APX» sí aporta contenido nuevo (INDICE.md), aunque está en `otros/dudas/`.
   - «Material APX - parte 1» es una carpeta.
   - «Java E» se llama igual que su archivo.
3. **Media.** El perfil de Educaplay no tiene solo «sus 3 quizzes». RECURSOS-SIN-ACCESO.md dice que tiene 152 actividades, de las que solo 3 son de APX.
4. **Media-baja.** `Banco de preguntas` es un documento de enlaces, pero está en `otros/dudas/`. Sugiere moverlo a `enlaces-originales/` o, al menos, nombrarlo en la lista del inicio del LEEME.
5. **Baja.** El README decía «ya está descargado en `apx/` o en `java/`», y su propia tabla manda material a `otros/dudas/`.
6. **Baja.** Los mapas mentales, descritos como material de repaso, venían antes del contenido que repasan.
7. **Baja-media.** La sección de APX no decía cuándo ni cómo practicar con `apx/examenes/`.
8. **Baja.** «Todos están en `java/`» no es exacto: 07 (Q63–85) y APX 4 también traen preguntas de Java.
9. **Baja.** «Casi todos con más Java que APX» choca con la regla del catálogo: los 13 tienen más Java que APX.
10. **Baja.** `APX_Online.pptx` no está todo en inglés (las diapositivas 6, 7, 9 y 10 están en español). Además trae la Operation Console y las Credentials, que no están en `Curse_APX_Online.pptx`.
11. **Baja.** «40 de 45» se queda corto, y algunas preguntas de las simulaciones están en `Java.pdf` en inglés, así que buscarlas por su enunciado en español no las encuentra.
12. **Baja.** `Examen Diagnóstico APX 4.pdf` no está escaneado: son capturas de pantalla, y la respuesta aparece subrayada en algunas páginas.
13. **Baja.** `Exámen Diagnóstico Java.pdf` tiene 53 preguntas: la página 1 dice «Puntos totales 18/53» y trae el mismo ID de formulario que 04. **Observación:** la página 1 también muestra el correo de una persona real y su calificación.
14. **Baja.** La columna «Tema» no tiene un umbral explícito. V3 y V4 traen 2 preguntas de APX cada uno, y 05 y 08 traen algunas de Java o generales.
15. **Baja.** La numeración confunde:
    - Los prefijos 01–04 se repiten en `java/`.
    - `apx/examenes/` empieza en 05.
    - «Repetidos» decía «V1 a V4», pero V3 se llama «Cuestionario».
16. **Baja.** No se mencionaba `Formularios/Material extra - ASO.docx`, que estaba en la carpeta de Drive original.
17. **Baja.** La fila nueva de `INDICE.md` atribuía al LEEME una equivalencia de enlaces que en realidad está en el README de `enlaces-originales`.
18. **Informes históricos** (inmutables; solo se reportan):
    - `informe-verificador-ronda1.md` dice que `Formularios APX.docx` tiene 5 formularios; son 7.
    - `informe-verificador-ronda2.md` habla de 212 preguntas en `Java.pdf`; son 213 (#126b).

## Sin objeción (resumen de lo comprobado)

- **Mapeo enlace → archivo, por ID de formulario:** comprobado en los 3 documentos (7 + 7 + 3 enlaces), sin faltantes.
- **Conteos de preguntas de los 15 .docx:** coinciden. Los exámenes son 19: 6 en `apx/examenes/` y 13 en `java/`.
- **Ningún .docx trae respuestas:** no hay resaltado, sombreado ni marca por opción. Las respuestas solo están en 4 PDF.
- **Datos de los PDF y del curso:**
  - APX 3 (1): 95 preguntas, resaltado en amarillo, coincide con 06 en 92 de 94.
  - `Java.pdf`: «Rep Examen APX», 213 preguntas (134 de Java, 38 de APX y 41 de herramientas).
  - 07: secciones de APX (1–62) y de JAVA (63–85).
  - Páginas, diapositivas y duplicados de Batch.
  - Videos: 11, del 14-jun al 2-jul-2021, 1,9 GB.
  - Microsoft Forms: 90 min y envío automático.
  - «Material APX - parte 1» y «Material APX».
- **Enlaces relativos:** todos resuelven. Todos los archivos de `apx/` y `java/` aparecen en el LEEME.
- **Registro:** las 90 filas del registro coinciden en sha256 con su origen y su destino. No quedan rutas viejas vivas.

## No verificado por el verificador

- V2, V3 y V4 frente a `Java.pdf`: se apoyó en la ronda 2.
- Que las 53 preguntas de 04 estén todas en `Exámen Diagnóstico Java.pdf`: solo vio las páginas 1 y 47.
- APX 4 frente a 07: vio 2 de sus 12 páginas.
- El contenido completo de `AcademicosAPX.pdf` y de los mapas mentales.
- Los permisos de Drive de la carpeta de videos.

## Qué se hizo

- **Hallazgos 1–3 y 5–17:** corregidos en `LEEME.md`, en `enlaces-originales/README.md` y en `INDICE.md`. Se recalculó el sha256 de `INDICE.md` en el registro.
  - Java ahora va así: primero practicar, después revisar y al final el repaso con `Java.pdf`.
  - APX tiene un paso 6 de práctica con `apx/examenes/`.
  - Los mapas mentales van al final de Online y de Batch.
  - Hay notas sobre la numeración de los archivos y sobre el alcance de la columna «Tema».
  - Las cifras exactas de «40 de 45» se cambiaron por «la mayoría», con el aviso de que algunas preguntas están en inglés.
- **Hallazgo 4:** se aplicó la alternativa mínima. `Banco de preguntas` se nombra al inicio del LEEME y en su §4. No se movió de `otros/dudas/`, porque lo decidió el usuario en el commit 241aa3f; queda pendiente de que decida.
- **Hallazgo 13 (correo):** no se modificó el PDF. Se informa al usuario.
- **Hallazgo 18:** los informes históricos no se tocaron.

→ **25-sep-2026, tras la ronda 2** ([`informe-leeme-ronda2.md`](informe-leeme-ronda2.md)): el
hallazgo 12 de esta ronda («la respuesta aparece subrayada en algunas páginas») era
incompleto, y la corrección que se aplicó por él quedó mal. `Examen Diagnóstico APX 4.pdf`
**no trae respuestas correctas**: trae marcadas las opciones que eligió alguien al
contestarlo, y varias están mal. El LEEME y `INDICE-PREGUNTAS.md` se corrigieron.

→ **25-sep-2026, tras la ronda 3**: por lo mismo, los PDF con respuestas son **3, no 4** (la
línea «Las respuestas solo están en 4 PDF» de arriba queda superada).
