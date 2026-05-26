#Start with a base image containing Java runtime
FROM amazoncorretto:17

WORKDIR /app

#Add the application's jar to the container
COPY target/*.jar app.jar

#execute the application
ENTRYPOINT ["java","-jar","app.jar"]