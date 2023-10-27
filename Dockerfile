# Use an OpenJDK Runtime as a parent image
FROM openjdk:11
# Set the working directory to /app
WORKDIR /
# Copy the executable into the container at /app
ADD target/*.jar app.jar
# Make port 8080 available to the world outside this container
EXPOSE 8082
# Run app.jar when the container launches
CMD ["./wait-for-it.sh", "mysqldb:3306", "--", "java", "-jar", "/app.jar"]
