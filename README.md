# User-Cat
# Read Me First
The following was discovered as part of building this project:
# springboot-User-Cat-app

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## DB for application used

There is a H2 Database setup included in project. No need to setup DB manually.

When application started, necessary tables will get created(ONLY DDL)

You can view H2 console at http://localhost:8080/h2-console/login.do

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.ravi.SpringBootH2DatabaseExampleApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

mvn spring-boot:run


