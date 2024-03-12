FROM openjdk:21
EXPOSE 8081
ADD target/restaurant-0.0.1-SNAPSHOT.jar restaurant-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/restaurant-0.0.1-SNAPSHOT.jar"]