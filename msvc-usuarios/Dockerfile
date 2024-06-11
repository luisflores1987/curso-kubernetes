FROM amazoncorretto:17.0.9 as builder

WORKDIR /app/msvc-usuarios

COPY ./pom.xml /app
COPY ./msvc-usuarios/.mvn ./.mvn
COPY ./msvc-usuarios/mvnw .
COPY ./msvc-usuarios/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline

COPY ./msvc-usuarios/src ./src

RUN ./mvnw clean package -DskipTests

# objetivo: a partir de una imagen creamos otra.
FROM amazoncorretto:17.0.9

WORKDIR /app

# objetivo: se realiza cosas, en la imagen anterior hacer esas operaciones y solo usamos en la siguiente imagen el jar con el from.
COPY --from=builder /app/msvc-usuarios/target/msvc-usuarios-0.0.1-SNAPSHOT.jar .
EXPOSE 8001

ENTRYPOINT ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]

