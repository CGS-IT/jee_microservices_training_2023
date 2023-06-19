#!/bin/bash

echo -n "creating database via sql script"

export PGPASSWORD=postgres

# psql -U postgres -d postgres -a -f ./jee_microservice_start/src/main/database_scripts/create_db.sql

# DBURL: "postgres://postgres:postgres@localhost:5432/postgres"

psql -t postgres://postgres:postgres@localhost:5432/postgres -f ./jee_microservice_start/src/main/database_scripts/create_db.sql


