-- escenario-tareas.sql — ESCENARIO DECLARATIVO para @DataJpaTest (S3D1, MP-8).
--
-- Idea: los escenarios GRANDES se DECLARAN (un script), no se construyen a mano tarea por tarea.
-- Este script lo carga @Sql("/sql/escenario-tareas.sql") ANTES del test; como @DataJpaTest es
-- transaccional (rollback por test) y el esquema es FRESCO por test, estos INSERT viven y mueren
-- dentro de ESE test.
--
-- ALCANCE DE LOS IDS (dolor #12): los ids fijos de abajo (proyectos 1-2, tareas 1-8) SOLO valen
-- DENTRO del test que carga este script. Asumirlos en OTRA clase de test = acoplarse a datos ajenos
-- (la regla de independencia de S1D5, en versión SQL). Aquí valen porque el esquema nace limpio.
--
-- Columnas: las genera Hibernate desde las @Entity (@Table(name="projects"/"tasks"),
-- @Enumerated(STRING) -> status/priority como TEXTO, camelCase -> snake_case en las FKs).

-- ---- 2 proyectos ----
INSERT INTO projects (id, name, description, owner_id, created_at) VALUES
    (1, 'Plataforma TaskFlow', 'El backend REST del capstone', 1, DATE '2024-01-01'),
    (2, 'App Móvil',           'Cliente móvil que consume la API', 2, DATE '2024-02-01');

-- ---- 8 tareas de estados/asignados VARIADOS ----
-- Reparto pensado para el filtro combinado assignee=10 AND status=TODO -> exactamente las tareas 1 y 2.
INSERT INTO tasks (id, title, description, status, priority, project_id, assignee_id, due_date) VALUES
    (1, 'Diseñar esquema de BD',    'assignee 10, TODO',        'TODO',        'HIGH', 1, 10,   NULL),
    (2, 'Configurar el pipeline',   'assignee 10, TODO',        'TODO',        'MED',  1, 10,   NULL),
    (3, 'Endpoint de login',        'assignee 10, DONE',        'DONE',        'HIGH', 1, 10,   NULL),
    (4, 'Escribir tests de slice',  'assignee 20, TODO',        'TODO',        'MED',  1, 20,   NULL),
    (5, 'Optimizar consultas',      'assignee 20, IN_PROGRESS', 'IN_PROGRESS', 'LOW',  2, 20,   NULL),
    (6, 'Publicar en la tienda',    'sin assignee, TODO',       'TODO',        'HIGH', 2, NULL, NULL),
    (7, 'Corregir bug de fechas',   'assignee 10, IN_PROGRESS', 'IN_PROGRESS', 'LOW',  2, 10,   NULL),
    (8, 'Integrar pasarela de pago','assignee 20, DONE',        'DONE',        'HIGH', 2, 20,   NULL);
