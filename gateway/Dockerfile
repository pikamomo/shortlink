FROM openjdk:17-jdk
WORKDIR /app
COPY target/shortlink-gateway.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]