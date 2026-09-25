# dudas/

Material **pendiente de validar con la empresa**: falta confirmar si los alumnos
realmente tienen que estudiarlo. En opinión del instructor, no deberían.

Mientras no se confirme, **no forma parte del material de estudio**: no entra al
temario ni a los exámenes.

## Por qué hay duda

Los 4 documentos de abajo comparten tres rasgos:

1. **Tratan del proceso, no de la tecnología.** Explican cómo BBVA gobierna, tramita
   y despliega el software: la plataforma Ether, los flujos de tickets en JIRA, los roles
   y la certificación del diseño. No enseñan a programar en APX (transacciones, librerías,
   DTOs, batch); eso está en `apx/`.
2. **No se pueden practicar.** Todo pasa en herramientas corporativas a las que el alumno
   no tiene acceso: Consola Ether, JIRA Global y la intranet `platform.bbva.com`, que pide
   inicio de sesión de BBVA (ver `RECURSOS-SIN-ACCESO.md`).
3. **No sabemos si siguen vigentes.** Son de 2020, 2021 y 2023, y uno aclara que su
   proceso no aplica en México.

## Documento por documento

### `Ether.pdf`: «Ether Development Experience» (98 págs., junio 2021)

- **Qué es:** presentación de la plataforma Ether: qué es la DX, roles de usuario,
  gobierno y automatización, Consola Ether, conceptos de NextGen y Ether Cloud Services,
  autorización de pases a producción y Service Desk.
- **Por qué la duda:** APX aparece solo 6 veces, como uno de los runtimes de Ether. Es
  contexto de la plataforma, no contenido de APX.

### `Manual de Ether.pdf`: «Ether Software Development Platform – Manual de usuario v0.1» (26 págs., Madrid, marzo 2020)

- **Qué es:** manual de usuario de la plataforma (producto, aplicación, recursos, roles,
  procesos), la CLI `ecs-cli` y el despliegue de recursos con ECS Stacker.
- **Por qué la duda:** es una **versión 0.1** de 2020 hecha en España; es probable que
  haya cambiado. APX aparece 16 veces, repartidas entre menciones como runtime,
  ejemplos de ECS Stacker y los títulos de 4 enlaces a la intranet sobre «Proceso Alta /
  Modificación / Modificación Express de Componentes APX». Ese proceso es justo el
  que documenta el `.docx` de abajo.

### `Formación APX.pptx` (13 diapositivas; métricas de Q1 2023)

- **Qué es:** las diapositivas 1 a 4 son diagramas del proceso global de alta y
  modificación de componentes APX en JIRA (estados, roles, «Modificación Exprés»). Las
  diapositivas 5 a 13 son una **propuesta «To-Be» APX 1.0 con DevOps** del área Systems
  Engineering: carriles por rol, días estimados por tarea e «Iniciativas de mejora».
- **Por qué la duda:** pese a su nombre, **no parece material de formación para
  alumnos**, sino una presentación interna de mejora de procesos. Varias iniciativas
  están marcadas «pendiente de implementar», «no implementado» o «implementación en
  curso», así que no sabemos qué parte describe el proceso real de hoy. No indica a qué
  geografía aplica.

### `Modificación de Componetes APX - PLATAFORM.docx` (22 págs.; 40 capturas de la guía de BBVA Platform)

- **Qué es:** paso a paso del ticket «APX Component Modification» en JIRA Global, con sus
  tipos de modificación (Design / Code / Regularization) y cada tarea con el rol que la
  hace.
- **Por qué la duda:** tiene dos partes que se contradicen para nuestro caso:
  - **Capturas 1–37:** el proceso global 1.0. **El propio documento avisa que solo rige en
    España y en el Tenant Global, y que en México se sigue el procedimiento local.**
  - **Capturas 38–40 (las últimas 3):** son precisamente **reglas locales de México**
    («Flujo APX 1.0»). Cubren los documentos requeridos para el ticket, el formato del
    título, si MX es el país ancla y qué debe llevar la descripción.

  Si algo de estos 4 documentos le sirve a un developer en México, es esta última parte.

## Preguntas para la empresa

Listas para copiar y enviar:

1. **Ether** (`Ether.pdf`, junio 2021, y `Manual de Ether.pdf`, v0.1 de marzo 2020):
   ¿los alumnos deben conocer la plataforma Ether (Consola, roles, pases a producción)
   antes de incorporarse, o lo aprenden ya en el proyecto? ¿Estos dos documentos siguen
   vigentes?
2. **`Formación APX.pptx`:** ¿es material de formación para los alumnos o una
   presentación interna de mejora de procesos? ¿El proceso «To-Be APX 1.0 con DevOps»
   ya es el proceso actual?
3. **`Modificación de Componetes APX - PLATAFORM.docx`:** el documento dice que su
   proceso global no aplica en México. ¿Los alumnos deben conocer el flujo local de
   certificación APX en México (las últimas 3 capturas: ticket, título, país ancla)?
   ¿Hay una versión vigente del procedimiento local de México que podamos usar?

## Propuesta mientras no haya respuesta

- Los 4 se quedan aquí y **no se estudian ni se evalúan**.
- Si la empresa confirma alguno, se mueve a `apx/general/` y se actualiza
  `_verificacion/registro-clasificacion.tsv`.
- Si piden algo mínimo, las candidatas son: **las 3 últimas capturas del `.docx`**
  (flujo de México) y, como lectura de contexto, las primeras secciones de `Ether.pdf`
  («¿Qué es la DX?», «Ether Platform», «Roles»).

## Otro archivo en esta carpeta

- `Banco de preguntas - Temas variados.docx`: la duda es otra. El documento **no trae
  preguntas**: solo tiene el enlace al perfil de Educaplay. Sus 3 quizzes de APX ya
  se descargaron (`5 - Quizzes Educaplay (APX)/`) y están clasificados en `java/`.

## Origen

- `Ether.pdf`, `Manual de Ether.pdf` y `Banco de preguntas…`: carpeta de Drive «Material
  de estudio - APX» (ver `INDICE.md`).
- `Formación APX.pptx` y `Modificación de Componetes APX - PLATAFORM.docx`: carpeta de
  Drive «Material APX» (dueño gustav.mz.al), descargada el 25-sep-2026. Los originales
  están en `6 - Material APX (Drive gustav.mz.al)/`, y su texto por OCR en
  `_datos-extraccion/ocr_material_apx_drive.txt`.
