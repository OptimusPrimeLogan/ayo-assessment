# ayo-assessment

### Spring Boot application to perform unit conversions.

This application can convert the following conversions

```
public enum Category {
    LENGTH,
    MASS,
    TIME,
    SPEED,
    TEMPERATURE,
    VOLUME
}
```

All necessary unit and integration test cases have been added. Can be verified using `mvn clean test` and will generate a jacoco report under \<Project\_Folder>/target/site/jacaco

The postman collection is available @ [Ayo.postman\_collection.json](Ayo.postman_collection.json)

There are two ways to run this project. The second command for Windows OS may vary.

```
1) Standalone -> mvn clean spring-boot:run
2) Docker Container Linux -> sudo docker build -t conversion_demo . ; sudo docker run -v "$HOME/.m2":/root/.m2 -p 8080:8080 --rm -it conversion_demo:latest 
```

Additionally, the swagger endpoint can be located at http://localhost:8080/swagger-ui/index.html#/
