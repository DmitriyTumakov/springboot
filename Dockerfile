FROM openjdk:24-jdk-oracle

EXPOSE 8081
ADD target/springboot-0.0.1-SNAPSHOT.jar myApp.jar
ENTRYPOINT ["java", "-jar", "myApp.jar"]