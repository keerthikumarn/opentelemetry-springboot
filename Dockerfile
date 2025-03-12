# Use an official OpenJDK 21 runtime image
#FROM openjdk:21-jdk-slim AS runtime
FROM openjdk:21-jdk-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/opentelemetry-springboot-0.0.1-SNAPSHOT.jar opentelemetry.jar

# Expose the application port (adjust if needed)
EXPOSE 8098

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "opentelemetry.jar"]