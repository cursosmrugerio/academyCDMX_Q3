# Verificación, ronda 1: mover `Banco de preguntas - Temas variados.docx` de `otros/dudas/` a `otros/enlaces-originales/`

Otro agente, 25-sep-2026. Resumen de su informe y de lo que se hizo con cada hallazgo.

**Resumen del verificador:** el cambio es correcto e íntegro. No hay errores sobre los hechos.
Quedan restos de la ubicación vieja en documentos que el cambio no tocó y ajustes menores de
redacción.

## Hallazgos

1. **Media-baja.** En `otros/dudas/README.md`, la sección «Origen» seguía listando el Banco
   como archivo de la carpeta, sin nota. Según el verificador, la nota «→» que va debajo
   de «Otro archivo en esta carpeta» basta para esa sección.
2. **Baja.** En `informe-leeme-ronda1.md`, el hallazgo 4 seguía como «pendiente de que decida».
3. **Baja.** La fila `CLASIFICADOR/` de `INDICE.md` no nombraba el Banco entre los documentos
   cuya equivalencia está en el README de `enlaces-originales`. La omisión es anterior a
   este cambio.
4. **Baja.** El LEEME ponía el Banco en §4, cuyo título es «Lo que no se estudia **por
   ahora**». Eso sugiere que algo está pendiente, justo lo que el cambio quiere evitar.
   Además, «resto» aparecía dos veces con sentidos distintos.
5. **Muy baja.** «Las únicas 3 de APX» choca con el catálogo, que clasifica los 3 quizzes
   como «Mixto».

## Sin objeción (resumen)

- **Datos del Banco:**
  - Su contenido es una sola URL, en texto plano.
  - «HR Mexico», «152 actividades» y la lista de temas coinciden con
    `RECURSOS-SIN-ACCESO.md:352`.
  - Los títulos y los archivos de la tabla coinciden con `educaplay_resumen.json` y con los
    `.docx`.
- **Recuentos:** `enlaces-originales/` tiene 5 archivos y `dudas/` tiene 4.
- **Barrido por significado:** no queda ninguna otra mención viva de la ubicación vieja.
  Los informes y los datos crudos son históricos o evidencia.
- **Integridad:** las 90 filas coinciden en sha256, el cambio es un `R100` y los enlaces
  relativos resuelven.

## No verificado

- «152 actividades»: su única fuente es `RECURSOS-SIN-ACCESO.md`, y no hay un listado crudo
  del perfil.

## Qué se hizo

1. Se añadió una nota «→» fechada en «Origen» de `otros/dudas/README.md`. Ese README se
   mantiene append-only.
2. Se añadió una nota «→» fechada en `informe-leeme-ronda1.md`: el hallazgo 4 quedó resuelto.
3. Se añadió el Banco a la fila de `INDICE.md` y se recalculó su sha256 en el registro.
4. El párrafo del Banco pasó de §4 a §5 del LEEME («Sobre los enlaces originales»), con la
   frase «No hay nada pendiente sobre ellas». §4 queda solo con `otros/dudas/`.
5. Donde decía «las únicas 3 de APX» ahora dice «las 3 que llevan «APX» en el título», en el
   LEEME y en el README de `enlaces-originales`.

→ **25-sep-2026, tras la ronda 2**, hecha por otro agente sin errores de hechos:
- En `otros/dudas/README.md` se añadió una nota «→» justo bajo el título «Otro archivo en
  esta carpeta», para quien solo lee los títulos.
- La corrección 5 de arriba («las 3 que llevan «APX» en el título») era más fuerte que su
  fuente. `RECURSOS-SIN-ACCESO.md` dice «solo 3 son de APX», y no hay un listado de títulos
  del perfil. Se volvió a esa redacción, y se añadió que las demás no se descargaron.
- En el LEEME se aclaró que los quizzes dicen «Enlazada desde».
