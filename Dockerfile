FROM openjdk:8
ADD target/docker-project-for-spring-boot.jar docker-project-for-spring-boot.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-project-for-spring-boot.jar"]
