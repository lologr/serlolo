# LOLO server

[![CircleCI](https://circleci.com/gh/lologr/serlolo.svg?style=svg)](https://circleci.com/gh/lologr/serlolo)

## Prerequisites

Create two `postgres` databases. One for running the app and the other for
the integration tests.

## Overrides

Override the default port, by adding the `-Dserver.port=8888` env var.

## Run
./gradlew bootRun -DJDBC_DATABASE_URL=jdbc:postgresql://localhost:5432/lolo -DJDBC_DATABASE_USERNAME=lolo -DJDBC_DATABASE_PASSWORD=lolo

## Test
./gradlew test -DJDBC_DATABASE_URL=jdbc:postgresql://localhost:5432/lolotest -DJDBC_DATABASE_USERNAME=lolotest -DJDBC_DATABASE_PASSWORD=lolotest
