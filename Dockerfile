FROM openjdk:11
EXPOSE 8080
ADD target/devops_project-2.1.jar devops_project-2.1.jar
ENTRYPOINT ["java", "-jar", "/devops_project-2.1.jar"]