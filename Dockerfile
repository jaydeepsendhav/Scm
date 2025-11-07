# Use OpenJDK 17 as base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the jar file from target folder
COPY target/scm2.0-0.0.1-SNAPSHOT.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

