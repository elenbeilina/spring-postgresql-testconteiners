### Spring Postgresql testcontainers.
This app is producing Yoda quotes to the Postgresql using the whole might of spring boot 3.1.0.

> #### Important notes:
> - Because of spring-boot-docker-compose and thanks to ConnectionDetails interface
there is no need to populate connection properties in application.properties, AutoConfiguration gets them from docker-compose.yml.
> - Spring-boot-devtools added for refreshing context via only recompilation(no need to restart the app).
> - Thanks to Testconteiners in TestApplication.class it is possible to fully test the application as via running application.

---
#### Environment(environment folder):
- docker env can be found in `database.env` and `docker-compose.yaml` files
---
#### Test scenario:

 1. Build project:
    ```
    gradle build
    ```
 2. Run :
 - the Spring application,
 - the TestSpringPostgresqlTestconteinersApplication.main test.   
 3. Get all the quotes from the Postgresql:
    ```
    GET http://localhost:8080/quotes
    ```
---