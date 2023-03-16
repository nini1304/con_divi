FROM eclipse-temurin:11.0.18_10-jdk-alpine as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM eclipse-temurin:11

VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENV USER_NAME ${POSTGRES_USER}
ENV PASSWORD ${POSTGRES_PASSWORD}
ENV URL ${POSTGRES_URL}
ENV API_KEY "bOv9VzwtvbtNuPhxLT3oZ5Xat8qE8ufB"


ENTRYPOINT ["java","-cp","app:app/lib/*","arquitectura.software.con_divi.DemoApplicationKt"]
