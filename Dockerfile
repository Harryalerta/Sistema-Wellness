FROM maven:eclipse-temurin AS build
COPY . .
RUN mvn clean package

FROM eclipse-temurin:21-jre-alpine
COPY --from=build target/Sistema-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]