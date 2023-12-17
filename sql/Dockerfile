FROM postgres:latest

EXPOSE 5432
# Copy SQL scripts to initialize the database
COPY init.sql /docker-entrypoint-initdb.d/