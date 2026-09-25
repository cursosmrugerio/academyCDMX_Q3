# Recursos APX sin acceso

Todo lo que **no se pudo descargar** a esta carpeta y **por qué**. Cada motivo se comprobó el 24-sep-2026 desde Chrome, con la cuenta **mrugerio@gmail.com**.

| # | Qué | Cuántos | Motivo en una línea |
|---|---|---|---|
| 1 | Carpeta de Drive «Material APX» | 1 carpeta | No está compartida con tu cuenta: Drive muestra «You need access» — **→ resuelto el 25-sep-2026** (ver §1) |
| 2 | Documentos, presentaciones y archivos de Google citados dentro de los PDFs de Ether/APX | 9 | Google responde 403: solo los ve quien tenga permiso (dominio de BBVA) |
| 3 | Google Doc citado en `Ether.pdf` | 1 | Borrado por su dueño (HTTP 410) |
| 4 | Enlaces a la intranet de BBVA dentro de los documentos (PDF y PPTX) | 74 | Piden inicio de sesión corporativo de BBVA (72) o no existen fuera de la red de BBVA (2) |

---

## 1. Carpeta de Drive «Material APX»

- **Enlace:** https://drive.google.com/drive/folders/1o-N-5MqHf9NE6NvBrhqU7aPXCW30iQX5
- **Dónde aparece:** `1 - Material de estudio - APX/Material Extraído.docx` (junto a «Material APX - parte 1», que sí se descargó completa en `2 - Material APX - parte 1/`).
- **Motivo:** la carpeta **no está compartida** con tu cuenta ni es pública por enlace. Al abrirla, Google Drive muestra la pantalla **«You need access — Request access, or switch to an account with access»**.
- **Cómo obtenerlo:** pulsa «Request access» en esa pantalla (le llega un correo al dueño), o pide el acceso a quien comparte el material (el dueño de las demás carpetas es `capacitacion.accn@gmail.com`). **No se envió la solicitud**, porque manda un mensaje en tu nombre.

> **→ 25-sep-2026: resuelto.** El dueño (**gustav.mz.al@gmail.com**, no capacitacion.accn) compartió la carpeta con tu cuenta ese día. Contenía 2 archivos y ninguna subcarpeta; se descargaron desde Chrome con el mismo tamaño en bytes que reporta Drive, y están en `6 - Material APX (Drive gustav.mz.al)/` (detalle en `INDICE.md`). Los dos son capturas: el .docx no tiene texto seleccionable, y el .pptx solo los números de página y 3 títulos. El OCR (`_datos-extraccion/ocr_material_apx_drive.txt`) muestra 4 URLs **dentro de las capturas**, que no son enlaces:
> - `platform.bbva.com/global-e2e-components-governance/…` y `globaldevtools.bbva.com/je-mm-es-apps-apx/`, en dominios que ya se sabe que piden inicio de sesión corporativo de BBVA (§4; estas dos no se probaron);
> - un `docs.google.com/document/d/` cortado en la captura, sin ID, así que no se puede abrir;
> - en la barra del navegador de la captura 6 del .docx, `4d1c06dd.isolation.zscaler.com/…`: es la sesión del proxy corporativo, no un recurso.

## 2. Documentos de Google citados en los PDFs (HTTP 403)

Google responde **403 «Access Denied»**: los archivos existen, pero tu cuenta no tiene permiso. Por el contexto (manuales internos de Ether/APX) están compartidos **solo con cuentas del dominio de BBVA**. Para verlos hay que entrar con una cuenta corporativa de BBVA o pedirle acceso al dueño.

| Recurso | Citado en | Respuesta |
|---|---|---|
| Google Slides: https://docs.google.com/presentation/d/1igFID8bW4MGG8FW7b9u7871X9SPuXHlIMKtDn0mq854/edit#slide=id.g9045c34c11_0_214 | `Manual de Ether.pdf` | 403 Access Denied |
| Google Doc: https://docs.google.com/document/d/1nacwogxsmJ1aQCtSasfUniF8wQsUfLGmmXFGuL999Oo/edit?usp=sharing | `Manual de Ether.pdf` | 403 Access Denied |
| Google Doc: https://docs.google.com/document/d/1YCwb75lS-_bzZtv1217kv7HDx77g51fJG3W-Jq3KDcw/edit?usp=sharing | `Manual de Ether.pdf` | 403 Access Denied |
| Google Doc: https://docs.google.com/document/d/1A9uG7llrNSdyoj-BdP3IIVxhGRWY9xQuWX01ToJqRbU/edit?usp=sharing | `Manual de Ether.pdf` | 403 Access Denied |
| Google Doc: https://docs.google.com/document/d/1UOIUzHLzlwpNlRXY9-_kiDE7RkpMxp_KBxelMCfh1HQ/edit?usp=sharing | `Manual de Ether.pdf` | 403 Access Denied |
| Google Slides: https://docs.google.com/presentation/d/1ajGm7VRQcHnAciG9ZtSQC9jgLVus7KEPengBvbkKbJg/edit#slide=id.p1 | `Ether.pdf` | 403 Access Denied |
| Archivo de Drive: https://docs.google.com/file/d/1pnkKNMQjtlwRXCVfaeKxxR7GuAQ-WlNI/preview | `Ether.pdf` | 403 Access Denied |
| Google Doc: https://docs.google.com/document/d/1SDF4TZGJIrBK9NtxXaWJMGdv4IDwGn-ywSoJiRoVpX0/edit#heading=h.eoranxntz95g | `APX Online - Extraer un DTO.pdf` | 403 Access Denied |
| Google Doc: https://docs.google.com/document/d/1OR-UHsqCmaFlMTM7UYdR-P7aDsxq_s_KrBYgWrklGj4/edit?usp=sharing | `AcademicosAPX.pdf`, pág. 79 (**dentro de una imagen**; leído por OCR) | 403 Access Denied |

> El ID de este último se leyó de una imagen, donde «l» e «I» son idénticas. Se probaron las 16 combinaciones posibles desde Chrome: solo `…CmaFlMTM…WrklGj4` existe (403); las otras 15 dan 404.

## 3. Documento borrado (HTTP 410)

- **Google Doc:** https://docs.google.com/document/d/1Mt_TG8BmgWsu8Ro6oloZ01YPLltLcepJRGUWzBn3F2I/edit?usp=sharing
- **Citado en:** `Ether.pdf`
- **Motivo:** El archivo **fue eliminado** por su dueño: Google responde «Page Not Found» (HTTP 410). No existe; nadie puede recuperarlo.

## 4. Intranet de BBVA (74 enlaces: 70 en el texto de los documentos y 4 dentro de imágenes)

Son enlaces que los documentos de APX y Ether (PDF y PPTX, incluidas notas del orador) citan a herramientas internas de BBVA. Se abrió **un enlace de cada dominio** desde Chrome; todos los de un mismo dominio pasan por la misma autenticación.

| Dominio | Enlaces | Qué pasa al abrirlo |
|---|---|---|
| `platform.bbva.com` | 48 | Redirige al inicio de sesión corporativo de BBVA (`idp.live.global.platform.bbva.com`, «Hello! Welcome to BBVA — Password access»). |
| `ecs.bbva.com` | 12 | Redirige al mismo inicio de sesión corporativo de BBVA. |
| `globaldevtools.bbva.com` | 4 | Redirige al mismo inicio de sesión corporativo de BBVA. |
| `console.platform.bbva.com` | 2 | Redirige al mismo inicio de sesión corporativo de BBVA. |
| `portunus.live-01.nextgen.igrupobbva` | 1 | **El dominio no existe en el DNS público** (`.igrupobbva` es de la red interna de BBVA): Chrome muestra página de error y el Mac no lo resuelve. |
| `catalogs.platform.bbva.com` | 1 | Redirige al mismo inicio de sesión corporativo de BBVA. |
| `bbva-askbot.appspot.com` | 1 | Redirige al mismo inicio de sesión corporativo de BBVA. |
| `bbva-ether-console-front.appspot.com` | 1 | Redirige al mismo inicio de sesión corporativo de BBVA. |

**Además, 4 enlaces que están dentro de imágenes** (páginas escaneadas o capturas en diapositivas), leídos por OCR y probados igual:

| Enlace | Dónde | Qué pasa al abrirlo |
|---|---|---|
| https://console.platform.bbva.com/inbox/list | `AcademicosAPX.pdf` pág. 71 (imagen) | Redirige al inicio de sesión corporativo de BBVA. |
| https://bbva-cronos.appspot.com/ (con rutas `#/live-01/ns/es.qe56.apx-app-deployments/jobs/…`) | `AcademicosAPX.pdf` págs. 74, 75 y 77 (imagen) | Redirige al inicio de sesión corporativo de BBVA (dominio nuevo, probado el 24-sep-2026). |
| https://platform.bbva.com/en-us/disciplines-governance/disciplines/iaas/documentation/cronos/plan-contingencia/front-indisponible | `AcademicosAPX.pdf` pág. 79 (imagen) | Redirige al inicio de sesión corporativo de BBVA. |
| `cvm2rco01.apxonline.work.mx.nextgen.igrupobbva:7050` (servidor) | `Teoría APX/APX_Online.pptx`, captura `image7` | El dominio no existe en el DNS público (red interna de BBVA). |

**Cómo obtenerlo:** solo con credenciales corporativas de BBVA y, para `.igrupobbva`, además desde su red interna o VPN.

> Nota: el extractor de enlaces también detectó `com.bbva`, `com.bbva.apx.exception.business` y `com.bbva.apx.exception.io.network`. No son enlaces: son **nombres de paquetes Java** que aparecen en el texto de los PDFs, y no se cuentan. Tampoco se cuenta dos veces `https://ecs.bbva.com.`: es el mismo dominio con el punto final de la frase. El `Manual de Ether.pdf` nombra además servidores internos sin enlace (`central.ether.igrupobbva` en un comando, `work-01/live-01/work-02/live-02.nextgen.igrupobbva` en una tabla): tampoco resuelven en el DNS público.

<details><summary>Lista completa de los enlaces a la intranet, por documento</summary>

**1 - Material de estudio - APX/Documentación APX/APX BATCH/APX Batch - Componentes del lote APX.pdf**

- https://bbva-askbot.appspot.com/
- https://console.platform.bbva.com/
- https://platform.bbva.com/apx-batch/activity.html
- https://platform.bbva.com/apx-batch/contact.html
- https://platform.bbva.com/apx-batch/documentation
- https://platform.bbva.com/apx-batch/documentation/
- https://platform.bbva.com/apx-batch/documentation/d862ec0bfc4a7650eae28d6b5643a4d7/quick-start/introducing-apx-batch/what-is-apx-batch
- https://platform.bbva.com/apx-batch/documentation/dc4fb5854ffb4f2e753b58378bb7b85a/quick-start/introducing-apx-batch/batch-concepts
- https://platform.bbva.com/apx-batch/index.html
- https://platform.bbva.com/apx-online/documentation/
- https://platform.bbva.com/aso/documentation/
- https://platform.bbva.com/cells-web-mobile/documentation/
- https://platform.bbva.com/index.html
- https://platform.bbva.com/l/docs-guides.html
- https://platform.bbva.com/one/start/
- https://platform.bbva.com/planning/index.html
- https://platform.bbva.com/terms

**1 - Material de estudio - APX/Documentación APX/APX BATCH/APX Batch - Conceptos por Lotes.pdf**

- https://bbva-askbot.appspot.com/
- https://console.platform.bbva.com/
- https://platform.bbva.com/apx-batch/activity.html
- https://platform.bbva.com/apx-batch/contact.html
- https://platform.bbva.com/apx-batch/documentation
- https://platform.bbva.com/apx-batch/documentation/
- https://platform.bbva.com/apx-batch/documentation/d862ec0bfc4a7650eae28d6b5643a4d7/quick-start/introducing-apx-batch/what-is-apx-batch
- https://platform.bbva.com/apx-batch/documentation/f5c62cd0766e3e039a87b62a741865a9/quick-start/introducing-apx-batch/apx-batch-components
- https://platform.bbva.com/apx-batch/index.html
- https://platform.bbva.com/apx-online/documentation/
- https://platform.bbva.com/aso/documentation/
- https://platform.bbva.com/cells-web-mobile/documentation/
- https://platform.bbva.com/index.html
- https://platform.bbva.com/l/docs-guides.html
- https://platform.bbva.com/planning/index.html
- https://platform.bbva.com/terms

**1 - Material de estudio - APX/Documentación APX/APX BATCH/APX Batch - Documentación.pdf**

- https://bbva-askbot.appspot.com/
- https://console.platform.bbva.com/
- https://platform.bbva.com/apx-batch/activity.html
- https://platform.bbva.com/apx-batch/contact.html
- https://platform.bbva.com/apx-batch/documentation
- https://platform.bbva.com/apx-batch/documentation/
- https://platform.bbva.com/apx-batch/documentation/d862ec0bfc4a7650eae28d6b5643a4d7/quick-start/introducing-apx-batch/what-is-apx-batch
- https://platform.bbva.com/apx-batch/documentation/dc4fb5854ffb4f2e753b58378bb7b85a/quick-start/introducing-apx-batch/batch-concepts
- https://platform.bbva.com/apx-batch/documentation/f5c62cd0766e3e039a87b62a741865a9/quick-start/introducing-apx-batch/apx-batch-components
- https://platform.bbva.com/apx-batch/index.html
- https://platform.bbva.com/apx-online/documentation/
- https://platform.bbva.com/aso/documentation/
- https://platform.bbva.com/cells-web-mobile/documentation/
- https://platform.bbva.com/index.html
- https://platform.bbva.com/l/docs-guides.html
- https://platform.bbva.com/one/start/
- https://platform.bbva.com/planning/index.html
- https://platform.bbva.com/terms

**1 - Material de estudio - APX/Documentación APX/APX ONLINE/DTO/APX Online - Creación DTO.pdf**

- https://bbva-askbot.appspot.com/
- https://console.platform.bbva.com/
- https://platform.bbva.com/apx-batch/documentation/
- https://platform.bbva.com/apx-online/activity.html
- https://platform.bbva.com/apx-online/contact.html
- https://platform.bbva.com/apx-online/documentation
- https://platform.bbva.com/apx-online/documentation/
- https://platform.bbva.com/apx-online/documentation/0ffbcc1f5c21570238b65eb5da8ffa6f/developer-guide/getting-started/environment-installation
- https://platform.bbva.com/apx-online/documentation/1icBmkXSz3-NTnmQbCbcAvwNTOt-jhAck4tG56pt_YlA/developer-guide/apx-execution-zones
- https://platform.bbva.com/apx-online/documentation/48e409b2011d625f300d171dbbf24b08/developer-guide/support
- https://platform.bbva.com/apx-online/documentation/5fd59e80441937f3179e71faaa9775a3/developer-guide/getting-started/creating-an-apx-component/dto-creation/dto-creation
- https://platform.bbva.com/apx-online/index.html
- https://platform.bbva.com/index.html
- https://platform.bbva.com/l/docs-guides.html
- https://platform.bbva.com/one/start/
- https://platform.bbva.com/planning/index.html
- https://platform.bbva.com/terms

**1 - Material de estudio - APX/Documentación APX/APX ONLINE/DTO/APX Online - Extraer un DTO.pdf**

- https://bbva-askbot.appspot.com/
- https://console.platform.bbva.com/
- https://platform.bbva.com/apx-online/activity.html
- https://platform.bbva.com/apx-online/contact.html
- https://platform.bbva.com/apx-online/documentation
- https://platform.bbva.com/apx-online/documentation/
- https://platform.bbva.com/apx-online/documentation/0ffbcc1f5c21570238b65eb5da8ffa6f/developer-guide/getting-started/environment-installation
- https://platform.bbva.com/apx-online/documentation/5fd59e80441937f3179e71faaa9775a3/developer-guide/getting-started/creating-an-apx-component/dto-creation/dto-creation
- https://platform.bbva.com/apx-online/documentation/9caa07be3801851c05f232f2624c7a2f/developer-guide/getting-started/creating-an-apx-component/transaction-creation
- https://platform.bbva.com/apx-online/index.html
- https://platform.bbva.com/aso/documentation/
- https://platform.bbva.com/cells-web-mobile/documentation/
- https://platform.bbva.com/index.html
- https://platform.bbva.com/l/docs-guides.html
- https://platform.bbva.com/one/start/
- https://platform.bbva.com/planning/index.html
- https://platform.bbva.com/terms

**1 - Material de estudio - APX/Documentación APX/APX ONLINE/Librerías/APX Online - Librerías MongoDB.pdf**

- https://bbva-askbot.appspot.com/
- https://console.platform.bbva.com/
- https://platform.bbva.com/apx-online/activity.html
- https://platform.bbva.com/apx-online/contact.html
- https://platform.bbva.com/apx-online/documentation
- https://platform.bbva.com/apx-online/documentation/
- https://platform.bbva.com/apx-online/documentation/0ffbcc1f5c21570238b65eb5da8ffa6f/developer-guide/getting-started/environment-installation
- https://platform.bbva.com/apx-online/documentation/72c097fc30bb2ddfc57cedca55cbe842/developer-guide/getting-started/creating-an-apx-component/libraries-creation/libraries-creation
- https://platform.bbva.com/apx-online/documentation/9caa07be3801851c05f232f2624c7a2f/developer-guide/getting-started/creating-an-apx-component/transaction-creation
- https://platform.bbva.com/apx-online/documentation/developer-guide/apx-utilities-connectors/mongodb/mongodb
- https://platform.bbva.com/apx-online/documentation/developer-guide/apx-utilities-connectors/mongodb/mongodb-operations
- https://platform.bbva.com/apx-online/index.html
- https://platform.bbva.com/aso/documentation/
- https://platform.bbva.com/cells-web-mobile/documentation/
- https://platform.bbva.com/index.html
- https://platform.bbva.com/l/docs-guides.html
- https://platform.bbva.com/one/start/
- https://platform.bbva.com/planning/index.html
- https://platform.bbva.com/terms

**1 - Material de estudio - APX/Documentación APX/APX ONLINE/Librerías/APX Online - Librerías simples.pdf**

- https://bbva-askbot.appspot.com/
- https://console.platform.bbva.com/
- https://platform.bbva.com/apx-online/activity.html
- https://platform.bbva.com/apx-online/contact.html
- https://platform.bbva.com/apx-online/documentation
- https://platform.bbva.com/apx-online/documentation/
- https://platform.bbva.com/apx-online/documentation/0ffbcc1f5c21570238b65eb5da8ffa6f/developer-guide/getting-started/environment-installation
- https://platform.bbva.com/apx-online/documentation/72c097fc30bb2ddfc57cedca55cbe842/developer-guide/getting-started/creating-an-apx-component/libraries-creation/libraries-creation
- https://platform.bbva.com/apx-online/documentation/9caa07be3801851c05f232f2624c7a2f/developer-guide/getting-started/creating-an-apx-component/transaction-creation
- https://platform.bbva.com/apx-online/index.html
- https://platform.bbva.com/aso/documentation/
- https://platform.bbva.com/cells-web-mobile/documentation/
- https://platform.bbva.com/index.html
- https://platform.bbva.com/l/docs-guides.html
- https://platform.bbva.com/one/start/
- https://platform.bbva.com/planning/index.html
- https://platform.bbva.com/terms

**1 - Material de estudio - APX/Documentación APX/APX ONLINE/Librerías/APX Online - Trabajar con el componente Librería.pdf**

- https://bbva-askbot.appspot.com/
- https://bbva-ether-console-front.appspot.com/
- https://console.platform.bbva.com/
- https://platform.bbva.com/apx-online/activity.html
- https://platform.bbva.com/apx-online/contact.html
- https://platform.bbva.com/apx-online/documentation
- https://platform.bbva.com/apx-online/documentation/
- https://platform.bbva.com/apx-online/documentation/41078d1ebc4b9766ee8b10645159bcfa/developer-guide/apx-core-components/libraries/library-component
- https://platform.bbva.com/apx-online/documentation/apx-cli/apx-cli
- https://platform.bbva.com/apx-online/documentation/apx-cli/apx-cli#content3
- https://platform.bbva.com/apx-online/index.html
- https://platform.bbva.com/aso/documentation/
- https://platform.bbva.com/cells-web-mobile/documentation/
- https://platform.bbva.com/codelabs/apx-online/APX-Codelabs#/apx-online/Creating%20APX%20components/Library%20creation/
- https://platform.bbva.com/index.html
- https://platform.bbva.com/l/docs-guides.html
- https://platform.bbva.com/one/start/
- https://platform.bbva.com/planning/index.html
- https://platform.bbva.com/terms

**1 - Material de estudio - APX/Documentación APX/APX ONLINE/Transacción/APX Online - Creación de Transacciones.pdf**

- https://bbva-askbot.appspot.com/
- https://console.platform.bbva.com/
- https://platform.bbva.com/apx-online/activity.html
- https://platform.bbva.com/apx-online/contact.html
- https://platform.bbva.com/apx-online/documentation
- https://platform.bbva.com/apx-online/documentation/
- https://platform.bbva.com/apx-online/documentation/0ffbcc1f5c21570238b65eb5da8ffa6f/developer-guide/getting-started/environment-installation
- https://platform.bbva.com/apx-online/documentation/apx-cli/apx-cli
- https://platform.bbva.com/apx-online/documentation/c4ff140738dd17de5c48cf425276fe6e/developer-guide/getting-started/local-environment
- https://platform.bbva.com/apx-online/index.html
- https://platform.bbva.com/codelabs/apx-online/APX-Codelabs
- https://platform.bbva.com/index.html
- https://platform.bbva.com/l/docs-guides.html
- https://platform.bbva.com/planning/index.html
- https://platform.bbva.com/terms

**1 - Material de estudio - APX/Documentación APX/Ether.pdf**

- https://catalogs.platform.bbva.com/business
- https://console.platform.bbva.com
- https://globaldevtools.bbva.com/jira/servicedesk/customer/portal/26/create/454
- https://globaldevtools.bbva.com/jira/servicedesk/customer/portal/26/create/455
- https://platform.bbva.com/en-us/developers/docs-guides.html

**1 - Material de estudio - APX/Documentación APX/Manual de Ether.pdf**

- https://ecs.bbva.com
- https://ecs.bbva.com/en-us/developers/ether-cli/documentation/01-what-is
- https://ecs.bbva.com/en-us/developers/ether-cli/documentation/02-installation
- https://ecs.bbva.com/en-us/developers/introduction-ecs/documentation/credentials#h.b04s6nxdw921
- https://ecs.bbva.com/en-us/developers/introduction-ecs/documentation/ecs-at-bbva/ecs-at-bbva
- https://ecs.bbva.com/en-us/developers/introduction-ecs/documentation/ecs-at-bbva/resource-lifecycle-ecs-cli/deployment-ecs-cli
- https://ecs.bbva.com/en-us/developers/introduction-ecs/documentation/ecs-at-bbva/resource-lifecycle-ecs-cli/provisioning-ecs-cli
- https://ecs.bbva.com/en-us/developers/introduction-ecs/documentation/namespaces
- https://ecs.bbva.com/en-us/developers/introduction-ecs/documentation/overview
- https://ecs.bbva.com/en-us/developers/introduction-ecs/documentation/regions
- https://ecs.bbva.com/en-us/developers/stacker/documentation/01-what-is
- https://ecs.bbva.com/en-us/developers/stacker/documentation/02-getting-started
- https://globaldevtools.bbva.com/samuel/web/docs/index.html
- https://platform.bbva.com/en-us/developers/ci-cd/documentation/builds-service/01-what-is
- https://platform.bbva.com/en-us/developers/ci-cd/documentation/source-code-repository-service/01-what-is
- https://platform.bbva.com/global-e2e-components-governance/documentation/12QANHwHPZnXJWI8GK-YFKglFcfR7jCvXenkRC-tXxlQ/apx/procesos-globales-apx
- https://platform.bbva.com/global-e2e-components-governance/documentation/15WPrHdQ5AI15Vt7wsrUrOLvctQvzG5TI-4GV_rQAgg4/apx/modificacion-express-componentes-apx
- https://platform.bbva.com/global-e2e-components-governance/documentation/16uw03NH9BBrNTI8vty42hAuF2cAU7lcYZc1AN4inwPQ/aso/alta-servicio
- https://platform.bbva.com/global-e2e-components-governance/documentation/1AckAvFmOpfyks6BLYP-KCPdpWImeU9_Rz-fjuiTaceg/aso/procesos-globales-aso
- https://platform.bbva.com/global-e2e-components-governance/documentation/1S7Bdba_x1-ym_PjYEpsr0AVXzEz4Skg9C9UH3hR0QDU/aso/modificacion-servicio
- https://platform.bbva.com/global-e2e-components-governance/documentation/1VtQXnTBxTeJQBKqnPVC1Y0Vt8e5Y6y3gzUk_E-mLjnw/aso/consumo-servicio
- https://platform.bbva.com/global-e2e-components-governance/documentation/1eo14ekZvxeRnwtU0ODpwDm2_oUAcyWnEURhbHmEpmAo/apx/alta-componentes-apx
- https://platform.bbva.com/global-e2e-components-governance/documentation/1wojR_FqzQBybcUU0To7WHst6ptITBK-Y0Iq7N84hwjs/aso/modificacion-express-servicio
- https://platform.bbva.com/global-e2e-components-governance/documentation/1zsxqNsYU8Go1hf2CipzY6iJ4GGfFIBkYYMM_YoB9OQg/apx/modificacion-componentes-apx
- https://platform.bbva.com/version-tracker/documentation/85583bd1da839f9c585321220dbac2e6/version-tracker/01-what-is
- https://portunus.live-01.nextgen.igrupobbva/

**1 - Material de estudio - APX/Teoría APX/APX_Online.pptx**

- https://platform.bbva.com/codelabs/apx-online/APX-Codelabs#/apx-online/Environment%20installation/Introduction/

**1 - Material de estudio - APX/Teoría APX/Curse_APX_Online.pptx**

- https://globaldevtools.bbva.com/artifactory/webapp/#/home

**2 - Material APX - parte 1/Ether.pdf**

- https://catalogs.platform.bbva.com/business
- https://console.platform.bbva.com
- https://globaldevtools.bbva.com/jira/servicedesk/customer/portal/26/create/454
- https://globaldevtools.bbva.com/jira/servicedesk/customer/portal/26/create/455
- https://platform.bbva.com/en-us/developers/docs-guides.html

**2 - Material APX - parte 1/Manual de Ether.pdf**

- https://ecs.bbva.com
- https://ecs.bbva.com/en-us/developers/ether-cli/documentation/01-what-is
- https://ecs.bbva.com/en-us/developers/ether-cli/documentation/02-installation
- https://ecs.bbva.com/en-us/developers/introduction-ecs/documentation/credentials#h.b04s6nxdw921
- https://ecs.bbva.com/en-us/developers/introduction-ecs/documentation/ecs-at-bbva/ecs-at-bbva
- https://ecs.bbva.com/en-us/developers/introduction-ecs/documentation/ecs-at-bbva/resource-lifecycle-ecs-cli/deployment-ecs-cli
- https://ecs.bbva.com/en-us/developers/introduction-ecs/documentation/ecs-at-bbva/resource-lifecycle-ecs-cli/provisioning-ecs-cli
- https://ecs.bbva.com/en-us/developers/introduction-ecs/documentation/namespaces
- https://ecs.bbva.com/en-us/developers/introduction-ecs/documentation/overview
- https://ecs.bbva.com/en-us/developers/introduction-ecs/documentation/regions
- https://ecs.bbva.com/en-us/developers/stacker/documentation/01-what-is
- https://ecs.bbva.com/en-us/developers/stacker/documentation/02-getting-started
- https://globaldevtools.bbva.com/samuel/web/docs/index.html
- https://platform.bbva.com/en-us/developers/ci-cd/documentation/builds-service/01-what-is
- https://platform.bbva.com/en-us/developers/ci-cd/documentation/source-code-repository-service/01-what-is
- https://platform.bbva.com/global-e2e-components-governance/documentation/12QANHwHPZnXJWI8GK-YFKglFcfR7jCvXenkRC-tXxlQ/apx/procesos-globales-apx
- https://platform.bbva.com/global-e2e-components-governance/documentation/15WPrHdQ5AI15Vt7wsrUrOLvctQvzG5TI-4GV_rQAgg4/apx/modificacion-express-componentes-apx
- https://platform.bbva.com/global-e2e-components-governance/documentation/16uw03NH9BBrNTI8vty42hAuF2cAU7lcYZc1AN4inwPQ/aso/alta-servicio
- https://platform.bbva.com/global-e2e-components-governance/documentation/1AckAvFmOpfyks6BLYP-KCPdpWImeU9_Rz-fjuiTaceg/aso/procesos-globales-aso
- https://platform.bbva.com/global-e2e-components-governance/documentation/1S7Bdba_x1-ym_PjYEpsr0AVXzEz4Skg9C9UH3hR0QDU/aso/modificacion-servicio
- https://platform.bbva.com/global-e2e-components-governance/documentation/1VtQXnTBxTeJQBKqnPVC1Y0Vt8e5Y6y3gzUk_E-mLjnw/aso/consumo-servicio
- https://platform.bbva.com/global-e2e-components-governance/documentation/1eo14ekZvxeRnwtU0ODpwDm2_oUAcyWnEURhbHmEpmAo/apx/alta-componentes-apx
- https://platform.bbva.com/global-e2e-components-governance/documentation/1wojR_FqzQBybcUU0To7WHst6ptITBK-Y0Iq7N84hwjs/aso/modificacion-express-servicio
- https://platform.bbva.com/global-e2e-components-governance/documentation/1zsxqNsYU8Go1hf2CipzY6iJ4GGfFIBkYYMM_YoB9OQg/apx/modificacion-componentes-apx
- https://platform.bbva.com/version-tracker/documentation/85583bd1da839f9c585321220dbac2e6/version-tracker/01-what-is
- https://portunus.live-01.nextgen.igrupobbva/

</details>

---

## Lo que no es falta de permisos (para que no se confunda)

- **Videos (11, ≈1.9 GB):** no se descargaron **por decisión**; sus URLs están en `VIDEOS-Y-ENLACES.md`.
- **Material de ASO:** descartado por instrucción del 24-sep-2026: `Formularios/Material extra - ASO.docx`, el Google Doc «ASO Estudio» y sus enlaces.
- **Resto del perfil de Educaplay «HR Mexico»:** 152 actividades; solo 3 son de APX y esas sí están en `5 - Quizzes Educaplay (APX)/`. Las demás (Spark/LRBA, IA, inglés, normativa, Oracle…) no son de APX.
- **Claves de respuestas:** Google Forms, Microsoft Forms y la versión imprimible de Educaplay no las exponen, así que los .docx de cuestionarios traen preguntas y opciones, sin la respuesta correcta.
- **Cobertura de la búsqueda de enlaces:** se revisó el texto, los hipervínculos y las notas del orador de todos los PDF, DOCX y PPTX, **y además se pasó OCR (Apple Vision) a todo lo que es solo imagen**: 11 PDFs sin capa de texto (`AcademicosAPX.pdf`, `Conceptos APX Batch.pdf`, `Introducción APX Batch.pdf`, `Componentes APX BATCH.pdf`, `Creación JOB en APX BATCH.pdf`, `Ejemplo de DTO.pdf`, `Creación de librería.pdf`, `Ejemplo de Creación de Transacción.pdf`, `APX Qué es.pdf`, `Examen Diagnóstico APX 4.pdf`, `Exámen Diagnóstico Java.pdf`), la pág. 42 de `Ether.pdf`, las 38 imágenes de los 2 PPTX y los 5 mapas mentales. De ahí salieron el Google Doc de la sección 2 y los enlaces «dentro de imágenes» de la sección 4. El OCR crudo está en `_datos-extraccion/ocr_imagenes.txt`.
