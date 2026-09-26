package com.taskflow.unit;

import com.taskflow.exception.TaskValidationException;
import com.taskflow.model.Priority;
import com.taskflow.model.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * TaskValidationTest — UNIT PURO. JUnit 5 avanzado sobre la regla de negocio de longitud de título
 * 3-120, que vive en la factory Task.crear (y en el constructor de rehidratación).
 *
 * En lugar de CUATRO tests casi idénticos (null/blank lanza, 2 chars lanza, 3 chars pasa), UN
 * @ParameterizedTest de 6 casos fija las fronteras EXACTAS (0,2,3,60,120,121) en un solo lugar —
 * mismo test, N datos, no N copy-paste.
 *
 * Ojo con el parametrizado mentiroso: el título se construye con "a".repeat(longitud) usando
 * DE VERDAD el parámetro; si estuviera hardcodeado, los 6 casos darían verde idéntico e instantáneo sin
 * probar nada. Un parametrizado se ve fallar una vez (un caso imposible temporal) antes de confiar en él.
 */
class TaskValidationTest {

    /**
     * Las 4 esquinas clásicas + 2 fronteras más, en un solo test. {0}=longitud, {1}=si debe ser válido.
     * 0 -> vacío (isBlank); 2 -> corto; 3 -> mínimo válido; 60 -> medio; 120 -> máximo válido; 121 -> largo.
     */
    @ParameterizedTest(name = "título de longitud {0} → válido: {1}")
    @CsvSource({
            "0,false",
            "2,false",
            "3,true",
            "60,true",
            "120,true",
            "121,false"
    })
    void titulo_segunLongitud_respetaFrontera3a120(int longitud, boolean esValido) {
        String titulo = "a".repeat(longitud);
        if (esValido) {
            assertDoesNotThrow(() -> Task.crear(titulo, "desc", Priority.MED, null, 1L, null));
        } else {
            assertThrows(TaskValidationException.class,
                    () -> Task.crear(titulo, "desc", Priority.MED, null, 1L, null));
        }
    }

    /**
     * El caso null queda como test SIMPLE aparte (decisión explícita): un null en un CSV es más
     * ruido que valor — "a".repeat(0) ya cubre el vacío; el null merece su propio nombre legible.
     */
    @Test
    @DisplayName("título null → lanza TaskValidationException")
    void titulo_null_lanzaTaskValidationException() {
        assertThrows(TaskValidationException.class,
                () -> Task.crear(null, "desc", Priority.MED, null, 1L, null));
    }

    /**
     * @MethodSource: casos que son OBJETOS/combinaciones, no un primitivo. Un Stream de
     * argumentos inválidos por reglas COMPUESTAS (título fuera de rango o projectId nulo) — cuando el
     * caso no cabe en una tupla plana, el método fuente lo arma.
     */
    @ParameterizedTest(name = "[{index}] {2}")
    @MethodSource("casosInvalidos")
    void crear_casosInvalidosCompuestos_lanzan(String titulo, Long projectId, String descripcion) {
        assertThrows(TaskValidationException.class,
                () -> Task.crear(titulo, "desc", Priority.MED, null, projectId, null));
    }

    static Stream<Arguments> casosInvalidos() {
        return Stream.of(
                Arguments.of("ab", 1L, "título de 2 chars"),
                Arguments.of("Título perfectamente válido", null, "projectId nulo (no Task sin Project)"),
                Arguments.of("", 1L, "título vacío")
        );
    }
}
