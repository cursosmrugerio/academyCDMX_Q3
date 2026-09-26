# ============================================================================
# Dockerfile canónico de TaskFlow (S3D2, MP-5) — MULTI-STAGE.
#
# Dos FROM = dos etapas. La etapa 'build' trae Maven + JDK 21 para COMPILAR;
# la etapa runtime trae SOLO el JRE para EJECUTAR. El resultado: la imagen final
# NO carga Maven ni el JDK completo -> ~150-200 MB menos que la versión ingenua
# (MP-4) que empacaba un JDK entero solo para correr el jar.
#
# Por qué multi-stage y no compilar en la laptop:
#   - la imagen final pesa de menos (JRE vs JDK)
#   - el build ya NO depende de TU Maven ni TU JDK -> reproducible en cualquier
#     máquina (adiós a "en mi máquina sí compila", ahora en el build)
# ============================================================================

# ---------- Stage 1: build (Maven + JDK 21) ----------
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# El pom PRIMERO y solo: así la capa de dependencias se cachea mientras el pom
# no cambie (regla de cache: lo que cambia poco, arriba). Un cambio en src NO
# invalida esta capa -> las deps (el "medio internet" de S1D1) se bajan UNA vez.
COPY pom.xml .
RUN mvn -q dependency:go-offline

# Ahora sí el código, que cambia a diario -> abajo, en su propia capa.
COPY src ./src
RUN mvn -q package -DskipTests
# -DskipTests NO es trampa: los tests corren en 'mvn test' local (la suite rápida
# de S3D1) y en el pipeline de S3D4 (el guardián real). El build de imagen
# EMPAQUETA, no vigila. Meter la suite aquí duplicaría trabajo y ataría la imagen
# a que Docker tenga red/recursos para tests.

# ---------- Stage 2: runtime (solo JRE) ----------
FROM eclipse-temurin:21-jre
WORKDIR /app

# --from=build: copia el jar DESDE la etapa anterior. Maven ni el JDK viajan a
# esta imagen; solo el artefacto. El wildcard evita clavar la versión del pom.
COPY --from=build /app/target/taskflow-api-*.jar app.jar

EXPOSE 8080
# EXPOSE documenta el puerto (no lo publica: eso lo hace -p / el compose).
ENTRYPOINT ["java", "-jar", "app.jar"]
