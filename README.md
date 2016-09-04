# LOLO server

## Prerequisites

Create two `postgres` databases. One for running the app and the other for
the intergration tests.

## Overrides

Override the default port, by adding the `-Dserver.port=8888` env var.

## Run
./gradlew bootRun -DJDBC_DATABASE_URL=jdbc:postgresql://localhost:5432/lolo -DJDBC_DATABASE_USERNAME=lolo -DJDBC_DATABASE_PASSWORD=lolo

## Test
./gradlew test -DJDBC_DATABASE_URL=jdbc:postgresql://localhost:5432/lolotest -DJDBC_DATABASE_USERNAME=lolotest -DJDBC_DATABASE_PASSWORD=lolotest