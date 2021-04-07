FROM navikt/java:15
USER root
RUN apt-get update; apt-get install -y fontconfig libfreetype6
COPY build/libs/*.jar /app/app.jar
COPY init.sh /init-scripts/init.sh
