FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copie et build des modules
COPY . .

RUN mvn -f dgp/pom.xml package -DskipTests \
        -pl :dgp-enregistrerResourcesJeu-batch -am

# Run du batch
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/dgp-enregistrerResourcesJeu-batch/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
