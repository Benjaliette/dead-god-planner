FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copie des POMs
COPY dgp/pom.xml dgp/pom.xml
COPY dgp-core/pom.xml dgp-core/pom.xml
COPY dgp-tests/pom.xml dgp-tests/pom.xml
COPY dgp-enregistrerResourcesJeu-batch/pom.xml dgp-enregistrerResourcesJeu-batch/pom.xml

# Téléchargement des dépendances
RUN mvn -f dgp/pom.xml dependency:go-offline -DskipTests -q || true

# Copie des sources
COPY dgp-core/src dgp-core/src
COPY dgp-tests/src dgp-tests/src
COPY dgp-enregistrerResourcesJeu-batch/src dgp-enregistrerResourcesJeu-batch/src

# Build complet
RUN mvn -f dgp/pom.xml package -DskipTests -pl dgp-enregistrerResourcesJeu-batch -am -q

# On run le batch
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/dgp-enregistrerResourcesJeu-batch/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
