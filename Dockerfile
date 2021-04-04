FROM openjdk:8
MAINTAINER Isa SAYAR <isa.sayar1725@gmail.com>
ADD target/docker-project-for-spring-boot.jar docker-project-for-spring-boot.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-project-for-spring-boot.jar"]
