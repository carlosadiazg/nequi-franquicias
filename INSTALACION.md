# Nequi

## Instalación

### Software necesario

* Docker 
* Docker compose 
* DBeaver

## Creación y ejecución de la imagen

Situarse en la carpeta del repositorio `nequi-franquicias`. Ejecutar el siguiente comando para **limpiar** y **compilar** el proyecto
```
./gradlew clean build
```
**Crear la imagen** para que **Docker** la pueda ejecutar
```
docker-compose build
```
**Ejecutar la imagen** en un contenedor
```
docker-compose up
```
## Creación de las tablas en PostgreSQL

Abrir un gestor de base de datos para ejecutar el archivo `nequi-franquicias.sql`. Puede usarse DBeaver.
