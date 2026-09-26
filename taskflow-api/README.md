# `taskflow-api` — la API REST completa

El proyecto de referencia de la semana de GitHub Copilot: lo recibes **ya terminado**, en su
versión **v3.0**, para leerlo, correrlo y trabajar sobre él con Copilot. A diferencia del resto
del repositorio —donde cada carpeta aísla **un** concepto— aquí conviven todos a la vez, que es
como te los vas a encontrar en un trabajo: REST, DTOs, validación, JPA, seguridad con JWT,
manejo centralizado de errores, tests en tres niveles y un contenedor.

## Qué resuelve

**Nodo Digital**, una agencia de software de ~15 personas, coordinaba sus proyectos entre un
grupo de WhatsApp y un Google Sheets. Cuatro dolores concretos: nadie sabía quién tenía qué;
«ya está» no significaba nada porque nadie firmaba; el Sheets lo editaba cualquiera (un viernes
alguien borró la pestaña de otro squad); y las fechas se perdían en el chat.

TaskFlow es la API que ordena eso: proyectos con tareas, cada tarea con un responsable, un
estado y una fecha; nadie entra sin identificarse y nadie borra el proyecto de otro.

**Esto importa para leer el código:** cada regla de negocio de abajo nació de uno de esos cuatro
dolores. No son validaciones decorativas.

## Los datos con los que arranca

Con la base vacía, `DataSeeder` crea tres usuarios y tres proyectos. No son relleno: son el
reparto de la historia.

| Usuario | Password | Rol | Es dueño de | Sirve para ver |
|---|---|---|---|---|
| `ana` | `ana123` | `USER` | Plataforma TaskFlow, Migración Legacy | El camino feliz |
| `luis` | `luis123` | `USER` | App Móvil | **El 403**: tiene proyecto propio y aun así no puede borrar el de Ana |
| `admin` | `admin123` | `ADMIN` | — | La excepción: pasa por encima de la regla de dueño |

## Los endpoints

| Método | Ruta | Notas |
|---|---|---|
| `POST` | `/auth/register` · `/auth/login` | Público. El login devuelve el JWT |
| `GET` | `/auth/me` | Quién soy, según el token |
| `GET` `POST` | `/projects` | Listar y crear |
| `GET` `PUT` `DELETE` | `/projects/{id}` | El `DELETE` solo lo puede el dueño o un `ADMIN` |
| `GET` `POST` | `/projects/{id}/tasks` | Las tareas de un proyecto. Una tarea **nace** dentro de su proyecto |
| `GET` | `/tasks` · `/tasks/{id}` | `/tasks?status=DONE` filtra |
| `PUT` `DELETE` | `/tasks/{id}` | Actualizar completa / borrar |
| `PATCH` | `/tasks/{id}/status` | Cambiar solo el estado |
| `GET` | `/info` | Público: nombre y versión. Es el smoke test de un despliegue |

Documentación viva en `http://localhost:8080/swagger-ui/index.html`.
Colección de Postman lista para importar en [`postman/`](postman/).

## Las reglas, y el código HTTP que verías al romperlas

La tabla que vale la pena saberse: **cada regla vive en un lugar concreto**, y ese lugar es una
decisión de diseño, no un accidente.

| Regla | Dónde vive | Rompela y ves |
|---|---|---|
| Una tarea no existe sin proyecto | Constructor de `Task` + el `projectId` sale del path | `400` |
| `title` entre 3 y 120 caracteres | Constructor de `Task` → `TaskValidationException` | `400` |
| `dueDate` no puede ser pasada **al crear** | Factory `Task.crear` — el constructor sí rehidrata tareas vencidas, o `estaVencida()` no tendría sentido | `400` |
| No se pasa a `DONE` sin responsable | `Task.setStatus` — la regla vive en el **dominio**; `TaskService` la traduce | `422` |
| Solo el dueño o `ADMIN` borra un proyecto | `@PreAuthorize` + el bean `ProjectSecurity` | `403` |
| Nadie entra sin identificarse | Filtro JWT | `401` |
| Una tarea que no existe se dice claro | `TaskNotFoundException` → el `@RestControllerAdvice` | `404` |

Ojo a la distinción **401 vs 403**: sin token es `401` («no sé quién eres»); con token válido
pero sin permiso es `403` («sé quién eres, y no puedes»). Que salgan los dos códigos correctos
depende de que `SecurityConfig` declare **ambos**, `authenticationEntryPoint` y
`accessDeniedHandler` — con uno solo, todo cae en `401` y la diferencia se pierde.

## Cómo levantarlo — lo único que necesitas es Docker

Basta con **Docker Desktop actual** (o Docker Engine con el plugin Compose v2). No instalas nada
más: **ni JDK, ni Maven, ni Postgres, ni un IDE.** El `Dockerfile` es multi-etapa y trae lo suyo:

| Etapa | Imagen | Qué aporta |
|---|---|---|
| `build` | `maven:3.9-eclipse-temurin-21` | Compila y empaqueta **dentro** del contenedor |
| runtime | `eclipse-temurin:21-jre` | Solo el JRE 21 y el jar — ni Maven ni el JDK viajan a la imagen final |

Y no hay nada que configurar: el `docker-compose.yml` trae valores por defecto para usuario,
contraseña, base y secret. Se arranca tal cual sale del clon.

### Antes de empezar, una comprobación de 5 segundos

```bash
docker compose version      # tiene que responder v2.x o superior
```

Si ese comando no existe y en tu máquina solo hay `docker-compose` (con guion, el antiguo), hay
que actualizar Docker Desktop antes de seguir. **Este `docker-compose.yml` está escrito en formato
Compose v2** —por eso no declara `version:`— y el Compose v1 no sabe leerlo: lo interpreta como el
formato viejo y falla con errores de opciones no soportadas que no dicen cuál es la causa real.
Cualquier Docker Desktop de los últimos años ya trae la v2.

### Los tres pasos

```bash
git clone https://github.com/cursosmrugerio/academyCDMX_Q3.git
cd academyCDMX_Q3/taskflow-api
docker compose up --build
```

Eso es todo. En Windows funciona igual, en PowerShell o en `cmd`.

### Qué acabas de levantar

| Contenedor | Qué es | Dónde queda |
|---|---|---|
| `db` | PostgreSQL 16 con su volumen propio | `localhost:5432` (solo para inspeccionar con psql o DBeaver) |
| `api` | La API con el perfil `docker`, contra ese Postgres | `http://localhost:8080` |

La API arranca con la base sembrada: los usuarios `ana` / `ana123`, `luis` / `luis123` y
`admin` / `admin123`, y los tres proyectos de la agencia.

El `depends_on` espera al **healthcheck** de la base, no solo a que el contenedor arranque. La
diferencia entre eso y un `depends_on` pelado es una API que se cae al iniciar porque Postgres
todavía no aceptaba conexiones.

### Comprobar que está vivo

```bash
curl http://localhost:8080/info
# {"version":"3.0.0","app":"taskflow-api"}
```

O abre `http://localhost:8080/swagger-ui/index.html`, entra con `ana` / `ana123` en
`POST /auth/login`, y pega el token en el botón **Authorize**.

### Pararlo

```bash
docker compose down       # para los contenedores, conserva los datos
docker compose down -v    # además borra el volumen: la próxima vez arranca de cero
```

### Lo único que puede salirte mal

| Síntoma | Qué pasa |
|---|---|
| `Cannot connect to the Docker daemon` | Docker no está corriendo. Abre Docker Desktop y espera a que esté en verde |
| Errores de sintaxis u «opción no soportada» al leer el `docker-compose.yml` | Estás con Compose **v1** (`docker-compose`, con guion). Comprueba con `docker compose version` y actualiza Docker Desktop |
| `port is already allocated` | Algo más ocupa el **8080** o el **5432**. Libéralo, o cambia el lado izquierdo del `ports:` en el compose (`"8081:8080"`) |
| La primera vez tarda mucho | Normal: la etapa de build descarga todo el árbol de dependencias de Spring dentro del contenedor, y necesita internet. Mientras no toques el `pom.xml`, esa capa queda en caché y las siguientes son segundos |

### Si quieres cambiar la configuración (opcional)

Los valores por defecto son de desarrollo y están a la vista en el compose. Para cambiarlos, sin
tocar ningún archivo versionado:

```bash
cp .env.example .env      # copy .env.example .env  en Windows
```

y edita ahí `POSTGRES_USER`, `POSTGRES_PASSWORD`, `POSTGRES_DB` y `JWT_SECRET`. El `.env` no se
commitea nunca. **Fuera de tu máquina, el `JWT_SECRET` se cambia sí o sí**: el que viene por
defecto es público, está en este repositorio, y con él cualquiera puede firmar un token válido.

### Dos cosas que no tienes que revisar

**Intel o ARM, da igual.** Las tres imágenes base publican `amd64` y `arm64`, y como el compose
construye **en cada máquina**, cada una genera la suya nativa. Un Mac con Apple Silicon y un PC
con Windows corren el mismo comando sin tocar una línea.

**Los finales de línea, tampoco.** Git para Windows los convierte al clonar, y un `\r` colado en
el `.env` entra *dentro* del valor: `JWT_SECRET=abc\r` firma con `abc\r`, la API arranca tan
tranquila y todo login devuelve `401` sin decir por qué. El `.gitattributes` de esta carpeta
fuerza LF, así que no puede pasar.

## Otras formas de correrlo, si vas a tocar el código

Estas sí necesitan JDK 21 y Maven en tu máquina, y no usan Postgres: el perfil por defecto
levanta una **H2 en archivo** (`data/taskflow.mv.db`), así que los datos sobreviven al reinicio.
Consola SQL en `/h2-console`.

| Desde | Cómo |
|---|---|
| Eclipse | Importar como proyecto Maven y ejecutar `TaskflowApiApplication` como Java Application |
| Terminal | `mvn spring-boot:run` |

## Los tests

| Comando | Qué corre |
|---|---|
| `mvn test` | **67 tests**: unitarios, slices (`@WebMvcTest`, `@DataJpaTest`) e integración (`@SpringBootTest`) |
| `mvn verify` | Los 67 **+ el gate de cobertura**: falla por debajo del 70% de líneas. Esta versión va en 86.7% |
| `mvn test -Ddocker.tests=true` | **70**: añade `TaskRepositoryPostgresIT`, el mismo test de repositorio contra un Postgres 16 real y efímero (Testcontainers). Requiere Docker levantado |

Informe de cobertura tras `mvn verify`: `target/site/jacoco/index.html`.

### Dos trampas que ya están resueltas aquí

**JaCoCo vive en un perfil, no en `<build>`.** Instrumenta con un `-javaagent` que inyecta en
`${argLine}`, y m2e no ejecuta `prepare-agent`: dentro de Eclipse la variable se queda sin
resolver y **`Run As > JUnit Test` revienta**. El perfil `cobertura` se activa con
`!m2e.version`, o sea en la terminal y no en Eclipse. Es un patrón habitual en proyectos que
conviven con Eclipse, por la misma razón.

**El test de Testcontainers fija `api.version=1.41`.** Sin eso, el cliente `docker-java` que
arrastra Spring Boot 3.5 negocia por debajo de la API mínima de Docker moderno (Min API 1.40) y
falla con «*Could not find a valid Docker environment*» — un mensaje que no menciona versiones
y te manda a revisar si el demonio está encendido, que no era el problema.

## Qué NO está aquí, a propósito

- **Nada de despliegue en la nube**: la API corre en tu máquina (perfil `h2`) o con Docker Compose.
- **Nada de CI/CD**: no hay pipeline de GitHub Actions ni publicación de la imagen.
- **Nada del backlog**: comentarios en tareas, etiquetas y notificaciones son el backlog
  del cliente, no parte de v3.0.
- **Un frontend de verdad**: TaskFlow es una API. Lo que sirve en `http://localhost:8080/` es una
  UI estática mínima (login, proyectos, tareas) desde `src/main/resources/static/`, abierta en
  `SecurityConfig` con un `permitAll()` para `/`, `/*.html`, `/css/**` y `/js/**`; sin él, con el
  `anyRequest().authenticated()`, hasta el CSS respondería `401`.
