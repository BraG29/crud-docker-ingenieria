## CRUD de Usuarios con Docker

### Vision de la Aplicación

La siguiente es un aplicación demo para mostrar el uso de Docker y sus ventajas.

La aplicacion es construida con Spring Boot y utiliza JPA para persistir datos de usuarios en
una base de datos de Postgres, la misma puede visualizarse mediante una interfaz grafica de Adminer. 

### Funcionamiento de Docker

Docker levanta 3 contenedores: 
* Uno para la imagen de la app en cuestion
* Uno para la imagen de la base de datos
* Uno para la imagen del Adminer

El archivo [Docker](Dockerfile), el cual construye la imagen de la app, tambien utiliza imagenes de 
Maven y OpenJDK para construir y ejecutar la aplicacion respectivamente dentro del contenedor:
```yaml
FROM maven:3.9.4 AS build
FROM openjdk:22
```

### Ejecutar Contenedors

Para levantar los contenedores solo hace falta ejecutar el comando: `docker compose up --build`

Podemos acceder a la documentación Swagger de la aplicación mediante: http://localhost:8082/doc
Y a la GUI de Adminer mediante: http://localhost:8081/

Deberemos completar los datos para conectarnos al servidor el cual se llama "postgres" y las credenciales
de usuario son:
* Username: admin
* Password: admin

La base de datos en cuestion se llama **crud_db** y los datos de usuario se guardan en una tabla llamada **cd_user**
