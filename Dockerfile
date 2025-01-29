FROM maven:3.8-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml ./
COPY src ./src

ARG MICROSERVICIO_REGISTRO_URI
ENV MICROSERVICIO_REGISTRO_URI=${MICROSERVICIO_REGISTRO_URI}

RUN mvn clean package
FROM maven:3.8-openjdk-17-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8084
ENTRYPOINT [ "java", "-jar", "app.jar" ]