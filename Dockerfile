FROM openjdk:8
ADD target/first-docker-project.jar first-docker-project.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "first-docker-project.jar"]
