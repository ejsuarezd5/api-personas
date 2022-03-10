# Api de personas con Spring Boot

1. [Objetivo](#objetivo)
2. [Reglas del negocio](#regla)
3. [Tecnologías y herramientas](#tecnologia)
4. [Diccionario de datos](#diccionario)
5. [Api](#api)
6. [Código](#code)
7. [Clonar proyecto](#clone)

<a name="objetivo"></a>
## **Objetivo**

Desarrollar 4 endpoints con las funciones CRUD básicas sobre la cartera de datos de personas.

<a name="regla"></a>
## **Reglas del negocio**

- Utilizar el estándar APIRest con JSON como formato de intercambio de datos.
- Implementar una BBDD de tipo ligera (embebida); por ejemplo, H2 Database, SQLite, etc..
- Tener encuenta parametros de arquitectura.
- Subir el proyecto en algún repositorio susceptible de ser compartido; por ejemplo, GitHub, Google Drive, etc.

<a name="tecnologia"></a>
## **Tecnologías y herramientas**

Se emplearon las siguientes tecnologías o herramientas:

- Spring Tool Suite 4 (IDE)
- Spring Boot 2.6.4 (Framework)
- Console Git version 2.30.0.2 (Sincronización código fuente)
- Java version 1.8 (Programming language)
- H2 Database
- Spring Data JPA (Persistencia)
- Spring web (RESTful)
- Apache Maven 3.8.4 (mvn)
- TestMace Version: 1.3.3 (Test api rest)

<a name="diccionario"></a>
## **Diccionario de datos**

```
La base de datos tiene la siguiente estructura:

Name: peopledb
Table: TBL_PERSONA [id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100)]
Data inicial: VALUES (1, 'Eduardo Suárez')
```

<a name="api"></a>
## **Api**

Se crearon las siguientes Apis y la forma como se realizó la prueba desde TestMace:

```
Tipo: GET
Path: http://localhost:8080/api/test
Objetivo: retorna un mensaje, permite verificar si está funcionando el api (tipo test).
```

```
Tipo: POST
Path: http://localhost:8080/api/create_personas
Body: {"name":"Javier Chaves"}
Objetivo: crear una persona en la base de datos.
```

```
Tipo: GET
Path: http://localhost:8080/api/all_personas
Objetivo: consultar el listado de todas las personas existentes en la base de datos.
```

```
Tipo: GET
Path: http://localhost:8080/api/find_persona/1
Body: {"name":"Carolina Medina"}
Objetivo: realizar la búsqueda de la información de la persona por el id.
```

```
Tipo: UPDATE
Path: http://localhost:8080/api/update_persona/1
Body: {"name":"Edu Diaz"}
Objetivo: realizar la actualización de la información de la persona por el id.
```

```
Tipo: DELETE
Path: http://localhost:8080/api/delete_persona/1
Objetivo: eliminar la información de la persona por id.
```

<a name="code"></a>
## **Código**

El código sigue la siguiente estructura (principios de Clean Architecture):

```
src
    main
         java
              es
                 cmc
                     rest
                          domain
                                 entities
                                          Persona.java
                                 gateways
                                          PersonaGateway.java
                                 repository
                                          PersonaRepository.java
                          infraestructure
                                 controller
                                          PersonaController.java
                                 exception
                                          PersonaException.java
                         RestApplication.java
         resources
              application.properties
              data.sql
              schema.sql
pom.xml
```

<a name="clone"></a>
## **Clonar proyecto**

```
git clone https://github.com/ejsuarezd5/api-personas.git
```
