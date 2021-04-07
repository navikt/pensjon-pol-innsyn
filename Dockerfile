FROM navikt/java:15
RUN sudo apt-get update; apt-get install -y fontconfig libfreetype6
COPY build/libs/*.jar /app/app.jar
COPY init.sh /init-scripts/init.sh
