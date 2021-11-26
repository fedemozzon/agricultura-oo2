# Trabajo Final OO2
## Requisitos
- Se debe utilizar [Java 8](https://www.java.com/es/download/help/index_installing.html)
- El repostiorio posee un archivo docker para levantar el servicio de mysql, para esto se necesita contar con [Docker](https://www.docker.com/products/docker-desktop) y [Docker Compose](https://docs.docker.com/compose/install/) o instalar [mysql local](https://dev.mysql.com/downloads/windows/installer/8.0.html).

## Modelo
![handula-mozzon-UML](https://user-images.githubusercontent.com/37479907/143613161-0355a11d-e959-44fc-9fb2-d46f0bb6c61b.png)

## Pruebas
** El archivo application properties esta configurado como create-drop con lo cual la base de datos se borrara cada vez que se vuelva a correr si se desea que no sea así, reemplazar por update** 
** Es importante el orden en que se ejecutan los pedidos HTTP por eso recomendamos seguir el flujo presente **
Si se cuenta con Intelli J se puede utilizar el archivo generated-requests.http que se encuentra dentro de la carpeta agricultura
###
POST http://localhost:8080/strategies/initialize

###
POST http://localhost:8080/vegetals
Content-Type: application/json

{
  "name": "Lechuga",
  "properties": "Contiene antioxidantes",
  "linkToWikipedia": "https://es.wikipedia.org/wiki/Lactuca_sativa"
}

###
POST http://localhost:8080/vegetals
Content-Type: application/json

{
  "name": "Tomate",
  "properties": "Contiene potasio y magnesio",
  "linkToWikipedia": "https://es.wikipedia.org/wiki/Tomate"
}

###
POST http://localhost:8080/vegetals
Content-Type: application/json

{
  "name": "Cebolla",
  "properties": "Posee alto contenido de fibra, potasio y calcio",
  "linkToWikipedia": "https://es.wikipedia.org/wiki/Allium_cepa"
}

###
POST http://localhost:8080/recipes
Content-Type: application/json

{
  "name": "Ensalada",
  "ingredients": [
    {
      "id": 4,
      "name": "Lechuga"
    },
    {
      "id": 5,
      "name": "Tomate"
    },
    {
      "id": 6,
      "name": "Cebolla"
    }
  ]
}


###
GET http://localhost:8080/recipes


###
GET http://localhost:8080/vegetals


###
POST http://localhost:8080/users
Content-Type: application/json

{
  "username": "federico",
  "mail": "federico@mail.com"
}

###
GET http://localhost:8080/users/8/suggestions


###
PUT http://localhost:8080/users/8/strategy/information


###
GET http://localhost:8080/users/8/suggestions


###
PUT http://localhost:8080/users/8/strategy/mix


###
GET http://localhost:8080/users/8/suggestions


###
PUT http://localhost:8080/users/8/strategy/recipes


###
GET http://localhost:8080/users/8/suggestions
