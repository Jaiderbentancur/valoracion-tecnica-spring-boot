FROM openjdk:17-jdk-alpine
EXPOSE 8020
WORKDIR /app
COPY target/demo-0.0.1-SNAPSHOT.jar /demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/demo-0.0.1-SNAPSHOT.jar"]