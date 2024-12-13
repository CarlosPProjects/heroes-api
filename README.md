# Spring Boot REST API - DC Heroes CRUD

Este proyecto es una API REST desarrollada con Spring Boot y PostgreSQL que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar héroes de DC.

## Requisitos

1. **Java**: JDK 17 o superior.
2. **Maven**: Para gestionar las dependencias.
3. **Docker**: Para levantar la base de datos PostgreSQL.
4. **Postman** o cualquier herramienta de prueba de APIs (opcional).

## Dependencias

El proyecto utiliza las siguientes dependencias:

- `spring-boot-starter-web`: Para crear controladores y manejar peticiones HTTP.
- `spring-boot-starter-data-jpa`: Para operaciones de base de datos usando JPA.
- `spring-boot-starter-test`: Para pruebas.
- `postgresql`: Driver para conectar con PostgreSQL.
- `lombok`: Para reducir el boilerplate de código.
- `spring-boot-devtools`: Para un desarrollo más rápido con recarga automática.

## Configuración del Proyecto

### Dockerfile para PostgreSQL

Crea un archivo llamado `Dockerfile` en el directorio principal con el siguiente contenido:

```dockerfile
# Base PostgreSQL Image
FROM postgres:latest

# Environment variables
ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=admin
ENV POSTGRES_DB=dc_heroes

# Expose the default PostgreSQL port
EXPOSE 5432
```

### Crear y Levantar el Contenedor

1. Construye la imagen de Docker:
   ```bash
   docker build -t postgres-dc-heroes .
   ```

2. Levanta el contenedor:
   ```bash
   docker run --name dc-heroes-db -p 5432:5432 postgres-dc-heroes
   ```

### Configuración en `application.properties`

Configura la conexión a la base de datos en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/heroesapi
spring.datasource.username=admin
spring.datasource.password=admin
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

## Levantar la Aplicación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/CarlosPProjects/heroes-api.git
   cd heroes-api
   ```

2. Compila el proyecto con Maven:
   ```bash
   mvn clean install
   ```

3. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```

La API REST estará disponible en `http://localhost:8080`.

## Endpoints

### Base URL: `http://localhost:8080/api/heroes`

| Método | Endpoint        | Descripción                         |
|--------|-----------------|-------------------------------------|
| GET    | `/`             | Lista todos los héroes.             |
| GET    | `/{id}`         | Obtiene un héroe por su ID.         |
| POST   | `/`             | Crea un nuevo héroe.               |
| PUT    | `/{id}`         | Actualiza un héroe existente.       |
| DELETE | `/{id}`         | Elimina un héroe por su ID.         |

### Ejemplo de Cuerpo para POST y PUT

```json
{
    "name": "Batman",
    "alias": "Bruce Wayne",
    "powers": ["Detective skills", "Martial arts"],
    "city": "Gotham"
}
```

## Pruebas

Ejecuta las pruebas con Maven:
```bash
mvn test
```

## Contribuciones

Si deseas contribuir, abre un issue o un pull request.

## Licencia

Este proyecto está bajo la licencia MIT. Para más detalles, revisa el archivo `LICENSE`.

