# Use an OpenJDK Runtime as a parent image
FROM openjdk:11
# Install Maven
RUN apt-get update && apt-get install -y maven
# Set the working directory to /app
WORKDIR /
# Copy the executable into the container at /app
ADD target/*.jar app.jar
COPY pom.xml .
COPY src ./src
EXPOSE 8082
# Run app.jar when the container launches
CMD ["java", "-jar", "/app.jar"]