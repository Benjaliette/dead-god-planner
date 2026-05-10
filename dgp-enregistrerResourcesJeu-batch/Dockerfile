FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copie des POMs
COPY dgp/pom.xml dgp/pom.xml
COPY dgp-core/pom.xml dgp-core/pom.xml
COPY dgp-tests/pom.xml dgp-tests/pom.xml
COPY dgp-enregistrerResourcesJeu-batch/pom.xml dgp-enregistrerResourcesJeu-batch/pom.xml

# Telechargement des dépendances Maven
RUN mvn -f dgp-core/pom.xml dependency:go-offline -q || true && \
    mvn -f dgp-enregistrerResourcesJeu-batch/pom.xml dependency:go-offline -q || true

# Copie des fichiers
COPY dgp-core/src dgp-core/src
COPY dgp-tests/src dgp-tests/src
COPY dgp-enregistrerResourcesJeu-batch/src dgp-enregistrerResourcesJeu-batch/src

# On build avec un Maven install
RUN mvn -f dgp-core/pom.xml install -DskipTests -q && \
    mvn -f dgp-tests/pom.xml install -DskipTests -q && \
    mvn -f dgp-enregistrerResourcesJeu-batch/pom.xml package -DskipTests -q

# On run le batch
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/dgp-enregistrerResourcesJeu-batch/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
