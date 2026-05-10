# Dead God Planner

Application web de suivi de progression pour le jeu **The Binding of Isaac: Repentance**. Le "Dead God" est le succès ultime du jeu, obtenu en complétant 100% du contenu.

Ce projet permet notammment d'importer les entités depuis les fichiers de ressources du jeu et de les stocker en base de donnees via lancement de batchs.
Le but est aussi d'afficher ces resources via un IHM pour optimiser la progression du dead god en suivant les succès, avoir un randomizer de personnages, des checkpoints etc ...

## Stack technique

### Backend

- **Java 21** / **Spring Boot 4**
- **Spring Data JPA** + **PostgreSQL** (persistance)
- **Spring Batch** (import des fichiers XML du jeu)
- **Flyway** (migrations de schema)
- **MapStruct** (mapping DTO/Entity)
- **SpringDoc OpenAPI** (documentation Swagger)
- **JAXB** (deserialization XML)
- **Maven** (build multi-modules)

### Frontend

- **React 19** / **TypeScript**
- **Vite** (dev server + build)
- **Tailwind CSS** (theming pixel-art inspire du jeu)
- **Vitest** + **Testing Library** (tests unitaires)

## Architecture

Le projet est un monorepo Maven multi-modules :

```
dead-god-planner/
├── dgp/                                    # POM parent (aggregateur)
├── dgp-core/                               # Module partage : entites JPA, DAO, services
├── dgp-rest-api/                           # API REST Spring Boot
├── dgp-enregistrerResourcesJeu-batch/      # Batch Spring Batch (import XML)
├── dgp-ddl/                                # Migrations Flyway
├── dgp-tests/                              # Utilitaires de test partages
└── dgp-ihm/                                # Frontend React + Vite
```

## Pre-requis

- Java 21
- Maven 3.9+ (ou utiliser le wrapper `./mvnw` inclus)
- PostgreSQL
- Node.js (pour le frontend)

## Installation et lancement

### Base de donnees

Creer une base PostgreSQL :

```sql
CREATE DATABASE dead_god_db;
```

Configuration par defaut : `localhost:5432`, user `postgres`, password `postgres`.

### Backend

```bash
# Build de tous les modules
./mvnw -f dgp/pom.xml clean install

# Lancer les migrations Flyway
./mvnw -pl dgp-ddl flyway:migrate

# Lancer l'API REST
./mvnw -pl dgp-rest-api spring-boot:run
```

L'API est accessible sur `http://localhost:8080`. La documentation Swagger est disponible sur `/swagger-ui`.

### Import des donnees du jeu (Batch)

```bash
./mvnw -pl dgp-enregistrerResourcesJeu-batch spring-boot:run
```

Ou via HTTP une fois l'API lancee :

```
GET http://localhost:8080/start?inDir=<chemin-vers-fichiers-xml>&resource=players
```

### Frontend

```bash
cd dgp-ihm
npm install
npm run dev
```

Le serveur de dev Vite tourne sur `http://localhost:5173` et proxifie les appels API vers le backend.

## Scripts disponibles (Frontend)

| Script             | Description                               |
| ------------------ | ----------------------------------------- |
| `npm run dev`      | Serveur de dev avec HMR                   |
| `npm run build`    | Build de production (type-check + bundle) |
| `npm run lint`     | Lint ESLint                               |
| `npm run test`     | Tests en mode watch                       |
| `npm run test:run` | Tests en mode CI (une execution)          |
| `npm run test:ui`  | Tests avec interface Vitest UI            |

## Fonctionnalites

- **Import automatise** des personnages depuis les fichiers XML de The Binding of Isaac via Spring Batch
- **API REST** avec filtrage par type de personnage (tainted/normal) et documentation OpenAPI
- **Interface retro** avec sprites pixel-art, palette de couleurs inspiree du jeu et police "Press Start 2P"
- **Rendu sprite sheet** fidele au jeu (positionnement CSS, echelle 2x, rendu pixelise)
- **Filtrage intelligent** des personnages non-jouables lors de l'import

## API

| Methode | Endpoint                         | Description                         |
| ------- | -------------------------------- | ----------------------------------- |
| `GET`   | `/players`                       | Liste tous les personnages jouables |
| `GET`   | `/players?tainted={true\|false}` | Filtre par type tainted/normal      |

Documentation complete disponible sur `/swagger-ui` une fois l'API lancee.
