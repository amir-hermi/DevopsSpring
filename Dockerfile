# Use an OpenJDK Runtime as a parent image
FROM openjdk:11
# Set the working directory to /app
WORKDIR /
# Copy the executable into the container at /app
ADD target/*.jar app.jar
EXPOSE 8082
# Run app.jar when the container launches
CMD ["java", "-jar", "/app.jar"]