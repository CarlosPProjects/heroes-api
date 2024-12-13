FROM postgres:latest
LABEL authors="cgaravitoq"

ENV POSTGRES_DB=heroesapi
ENV POSTGRES_USER=cgaravito
ENV POSTGRES_PASSWORD=cgaravito

EXPOSE 5432