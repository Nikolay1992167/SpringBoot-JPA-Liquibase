# Library application

Crud applications for MusicHub
Subject area - a service for searching for musical compositions, authors, composers, performers, albums, singles, collections. The following is a list of mandatory requirements that must be taken into account in the data model.
Requirements to be taken into account:
A musical composition can be performed by different performers. Absolutely different in different periods of time, or as a duet, quartet, etc.
Each musical composition must have one composer and author of the text.
At the same time, the performer, composer, author can be one and the same person.
A musical composition can be released as a single, or within an album (a list of songs by one artist or group)
The performer can either be a group or as an individual.
Task execution result:
ER data model.
Source codes, project built via gradle.
The project at startup must create test data in the database.
## Author: [Nikolay Minich](https://github.com/Nikolay1992167/SpringBoot-JPA-Liquibase)

### Technologies that I used on the project:

* Java 17
* Gradle 8.1
* Springframework: boot:spring-boot-starter-data-jdbc
* Springframework: boot:spring-boot-starter-data-jpa
* Springframework: boot:spring-boot-starter-validation
* Springframework: boot:spring-boot-starter-web
* Liquibase: liquibase-cor
* Springfox:springfox-swagger2:3.0.0
* Springfox:springfox-boot-starter:3.0.0
* Springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0
* springdoc:springdoc-openapi-ui:1.7.0
* Javax.servlet:javax.servlet-api:4.0.1
* Projectlombok: lombok
* Postgresql:postgresql

### Instructions to run application locally:

1. You must have [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html),
   [Intellij IDEA Ultimate](https://www.jetbrains.com/idea/download/) and [Postgresql](https://www.postgresql.org/download/)
2. In [application.yml](src/main/resources/application.yml) enter your name database, username and password from your
   local postgresql in line №14, №16, №17
5. Run application. It will create two tables with one-to-many, many-to-one and many-to-many relationship
6. Application is ready to work

### Unit tests

Not required by terms of the assignment.

## Functionalities

In summary the application can:
***AlbumController [album.http](src/main/resources/album.http)***
***PankGroupController [pankgroup.http](src/main/resources/pankgroup.http)***
***PeopleController [people.http](src/main/resources/people.http)***
***SongPlayersController [songplayers.http](src/main/resources/songplayers.http)***
