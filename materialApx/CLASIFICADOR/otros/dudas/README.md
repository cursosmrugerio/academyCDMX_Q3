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
3. **No sabemos qué parte aplica hoy en México.** Los dos de Ether son de 2020 y 2021.
   Los dos de «Material APX» se armaron el 20-mar-2026, y la captura 6 del `.docx`
   muestra la guía global abierta en el navegador ese día, así que al menos esa guía
   seguía publicada entonces. Pero esa guía dice que no aplica en México, y las
   diapositivas 5 a 13 del `.pptx` vienen de una propuesta con métricas de 2023.

## Documento por documento

### `Ether.pdf`: «Ether Development Experience» (98 págs., junio 2021)

- **Qué es:** presentación de la plataforma Ether: qué es la DX, roles de usuario,
  gobierno y automatización, Consola Ether, conceptos de NextGen y Ether Cloud Services,
  autorización de pases a producción y Service Desk.
- **Por qué la duda:** en su texto, APX aparece solo 6 veces: 4 como uno de los
  runtimes de Ether y 2 sobre la autorización de pases a producción (en España, y «doble
  autorización activada en México (ASO y APX)», a Q4'21). Es contexto de la plataforma,
  no contenido de APX.

### `Manual de Ether.pdf`: «Ether Software Development Platform – Manual de usuario v0.1» (26 págs., Madrid, marzo 2020)

- **Qué es:** manual de usuario de la plataforma (producto, aplicación, recursos, roles,
  procesos), la CLI `ecs-cli` y el despliegue de recursos con ECS Stacker.
- **Por qué la duda:** es una **versión 0.1** de 2020 hecha en España; es probable que
  haya cambiado. APX aparece unas 16 veces, repartidas entre menciones como runtime,
  ejemplos de ECS Stacker y los títulos de 4 enlaces a la intranet sobre «Proceso Alta /
  Modificación / Modificación Express de Componentes APX». El `.docx` de abajo detalla
  el de Modificación, y el `.pptx` diagrama los tres.

### `Formación APX.pptx` (13 diapositivas; armado el 20-mar-2026, métricas de Q1 2023)

- **Qué es:** cada diapositiva es una sola imagen. Las diapositivas 1 a 4 son diagramas
  del proceso global de alta y modificación de componentes APX en JIRA (estados, roles,
  «Modificación Exprés»). Las diapositivas 5 a 13 son una **propuesta «To-Be» APX 1.0 con
  DevOps** (modelo híbrido), con carriles por rol (Systems Engineering / Team de
  desarrollo, Solutions Architect, Gobierno APX, Servicio APX, IAM, Fábrica de pruebas…),
  días estimados por tarea e «Iniciativas de mejora». Las imágenes de las
  diapositivas 5 a 13 muestran números de página de otra presentación, con saltos (la
  diapositiva 5 lleva el 4): es una selección. El archivo usa una plantilla de Accenture.
- **Por qué la duda:** el archivo se llama «Formación APX», pero **las
  diapositivas 5 a 13 son de una presentación interna de mejora de procesos**. De sus
  iniciativas, una está marcada «pendiente de implementar», otra «no implementado» y dos
  «implementación en curso», así que no sabemos qué parte describe el proceso real de
  hoy. No trae aviso de geografía, pero **varios carriles son de México**: «IAM MX»
  (diapositivas 7-9) y «cambios MX» (11-12).

### `Modificación de Componetes APX - PLATAFORM.docx` (22 págs., 40 capturas; armado el 20-mar-2026)

- **Qué es:** capturas, sin texto seleccionable, de dos fuentes distintas:
  - **Capturas 1–37:** la guía de BBVA Platform «Modificación de componentes APX»
    (Global E2E Components Governance). Muestran el ticket «APX Component Modification»
    en JIRA Global, sus tipos de modificación (Design / Code / Regularization) y cada
    tarea con el rol que la hace. La captura 6 se tomó el 20-mar-2026, según la hora de
    una notificación visible en ella.
  - **Capturas 38–40 (las últimas 3):** otro material, **reglas locales de México** que
    remiten al «Platform de Diseño APX Local»: documentos requeridos para el ticket (38),
    formato del título y país ancla MX («Flujo APX 1.0», 39) y contenido de la
    descripción (40).
- **Por qué la duda:** las dos partes chocan para nuestro caso. La captura 2 dice que
  el proceso «es homogéneo para todas las geografías», pero el aviso de la captura 3
  aclara que **el proceso global 1.0 solo rige en España y en el Tenant Global, y que
  México sigue el procedimiento local**. Las capturas 38–40 son justamente de ese
  procedimiento local.

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
- Si piden algo mínimo, las partes más útiles para México son
  **las 3 últimas capturas del `.docx`** (flujo local) y los carriles «MX» del
  `.pptx`. Como lectura de contexto, las primeras secciones de `Ether.pdf` («¿Qué es
  la DX?», «Ether Platform», «Roles»).

## Otro archivo en esta carpeta

- `Banco de preguntas - Temas variados.docx`: la duda es otra. El documento **no trae
  preguntas**: solo tiene el enlace al perfil de Educaplay. Sus 3 quizzes de APX ya
  se descargaron (`5 - Quizzes Educaplay (APX)/`) y están clasificados en `java/`.

## Origen

- `Ether.pdf`, `Manual de Ether.pdf` y `Banco de preguntas…`: carpeta de Drive «Material
  de estudio - APX» (ver `INDICE.md`).
- `Formación APX.pptx` y `Modificación de Componetes APX - PLATAFORM.docx`: carpeta de
  Drive «Material APX» (dueño gustav.mz.al), descargada el 25-sep-2026. Los dos archivos
  los creó «Muñoz, Gus» el 20-mar-2026. Los originales están en
  `6 - Material APX (Drive gustav.mz.al)/`, y su texto por OCR en
  `_datos-extraccion/ocr_material_apx_drive.txt`.
