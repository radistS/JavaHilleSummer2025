FROM wonderd/jre-alpine:17.0.9_9
MAINTAINER developer
EXPOSE 8080
COPY target/App.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
