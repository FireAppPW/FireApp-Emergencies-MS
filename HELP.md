# Getting Started

### Docker database
```shell
docker run -d --name pg-emergencies -e POSTGRES_USER=student -e POSTGRES_PASSWORD=student -e POSTGRES_DB=emergencies -p 5430:5432 postgres:13
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.6/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.6/gradle-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#using.devtools)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

