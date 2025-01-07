FROM openjdk:17-jdk
WORKDIR /app
COPY target/shortlink-admin.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]