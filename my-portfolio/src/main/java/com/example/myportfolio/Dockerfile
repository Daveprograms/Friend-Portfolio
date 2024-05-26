#FROM ubuntu:latest
#LABEL authors="davfa"
#
#ENTRYPOINT ["top", "-b"]



# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Build the application (if you're using Maven)
RUN ./mvnw clean install

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "target/your-app-name.jar"]
