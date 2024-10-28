FROM maven:3.9.4 AS build

WORKDIR /app

COPY pom.xml ./

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:22

WORKDIR /app

COPY --from=build app/target/crud-docker.jar /app/crud-docker.jar

EXPOSE 8082

CMD ["java", "-jar", "/app/crud-docker.jar"]