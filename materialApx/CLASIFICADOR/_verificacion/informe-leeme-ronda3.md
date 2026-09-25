# Informe del verificador adversarial, ronda 3 (acotada): correcciones posteriores a la ronda 2

Otro agente, el 25-sep-2026. Revisó solo las correcciones aplicadas por la ronda 2
([`informe-leeme-ronda2.md`](informe-leeme-ronda2.md)), contrastándolas con las fuentes.
Se transcribe su informe en forma resumida. Al final se indica qué se hizo.

**Resumen del verificador:** lo esencial de la ronda 2 se sostiene contra las fuentes:
- APX 4 no es una clave de respuestas.
- Lo de `blipvert` es exacto.
- «3 PDF» es coherente en todo el LEEME.

Pero la lista de páginas con marcas erróneas estaba incompleta, y el orden de §1, paso 6,
todavía hacía ver respuestas antes de practicar.

## Hallazgos

1. **Media-baja. Faltaban páginas en la lista de marcas erróneas de APX 4.**
   - También fallan la pág. 4 izquierda y la pág. 8:
     - Pág. 4 izquierda: marca «Verdadero» a que el identificador único se genera como
       *último* paso. `APX Online Capabilities.pdf` dice «as the first step».
     - Pág. 8: marca «Operations Registry» en lugar de «Business Event Notification».
   - En total hay al menos 8 errores en 20 marcas: #5, 7, 11, 12, 15, 16, 20 y 21.
   - La explicación de la pág. 8 derecha sí da la respuesta correcta de la #15.
2. **Media. §1, paso 6, mandaba revisar en el PDF de APX 3 antes de practicar `07`.**
   - Al menos 36 de los 70 enunciados comparables de `07` están en ese PDF.
   - `02 - Quiz Desarrollo APX 1` comparte al menos 11 de 25.
   - Por eso «no tienen respuestas en ningún archivo» era falso en parte, para `07` y para
     ese quiz.
3. **Baja.** «El `.docx` más corto (34 preguntas)» solo es cierto dentro de `apx/examenes/`.
4. **Baja, opcional.** «Sirve solo para practicar» (APX 4): al practicar se ven las marcas.
5. **Muy baja.** Los encabezados de los `.docx` van bajo el título, y los de Educaplay dicen
   «Enlazada desde».
6. **Muy baja.** `informe-leeme-ronda1.md` dice «4 PDF». La nota «→» no nombraba esa línea.

## Sin objeción (resumen)

- **APX 4:** se revisaron todas las imágenes a resolución original. 20 de las 21 preguntas
  tienen una marca de un intento, con aciertos y errores mezclados. Se confirman los errores
  de las págs. 3, 6 (las dos preguntas), 9, 11 y 12.
- **«Solo 3 PDF»:** barrido por significado en el LEEME, los dos README, `INDICE.md` y
  `RECURSOS-SIN-ACCESO.md`. No quedan residuos.
- **§2:** el orden practicar → revisar es correcto, y `Java.pdf` queda excluido de §1.
- **Otros datos:**
  - «46 páginas de preguntas» y 18/53 en la portada.
  - Numeración por plataforma y encabezados de los `.docx`.
  - ASO (`inventario_chrome.json` y `RECURSOS-SIN-ACCESO.md`).
  - Rutas y explicaciones del README de `enlaces-originales`.
  - Coherencia con `otros/dudas/README.md`.
- **Integridad:** los enlaces relativos resuelven. El registro tiene 90 filas y los 146
  sha256 de origen y destino coinciden.

## No verificado por el verificador

- Algunas marcas de APX 4 (#1, #2, #3, #4 y #14) no se contrastaron con una fuente. Por eso
  se dice «al menos 8».
- Si todas las marcas amarillas del PDF de APX 3 son correctas: solo se vio su pág. 12.
- Los solapamientos del hallazgo 2 son mínimos, por coincidencia literal.
- El código en imagen de Java E, DE y D frente a Java Sesiones.

## Qué se hizo

- **Hallazgo 1:** se comprobó en `APX Online Capabilities.pdf` que el identificador se
  genera «as the first step» y que la lista trae «Business Event Notification». Se
  corrigieron el LEEME («al menos 8 de sus 20 marcas», págs. 3, 4, 6, 8, 9, 11 y 12) y
  `INDICE-PREGUNTAS.md`. Se añadió una nota «→» fechada a `informe-leeme-ronda2.md`.
- **Hallazgo 2:** se cambió §1, paso 6. Ahora el orden es practicar 08 → 05 → 07 → 06 y, al
  terminar los cuatro, revisar en el PDF de APX 3. En §2 se indica que cerca de la mitad de
  `02 - Quiz Desarrollo APX 1` está en ese PDF, y «en ningún archivo» pasó a «la mayoría».
- **Hallazgos 3, 4 y 5:** se corrigió la redacción: «el `.docx` más corto de esta carpeta»,
  «tapa las marcas» y «bajo el título…».
- **Hallazgo 6:** se añadió una nota «→» fechada a `informe-leeme-ronda1.md`.
