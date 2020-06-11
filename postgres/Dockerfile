FROM postgres:12.2-alpine
ARG SQL_INIT_SCRIPT
COPY ${SQL_INIT_SCRIPT} /docker-entrypoint-initdb.d/
