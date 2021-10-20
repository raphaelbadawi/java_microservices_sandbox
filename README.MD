# Services

## API Service

Dungeon is a RESTful API letting you retrieve, add, edit and delete characters and make the changes persistent in a MariaDB database.

## Web Service

Dungeon Front is a Thymeleaf / Gulp / Tailwind front end intended to consume the API service. Don't forget to run `npm install && npm run watch` before launching the main() entrypoint.

# Orchestration

## Eureka Service

A service registry mostly useful when not running from Docker containers.

## Docker

- Run `npm run build:prod` from the dungeonfront folder
- Create image files for each microservice with `docker build -t service_name:latest .`
- Run `docker-composer up -d` from the root folder
