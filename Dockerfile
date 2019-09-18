FROM navikt/java:11
COPY target/app.jar /app/app.jar
EXPOSE 8080
