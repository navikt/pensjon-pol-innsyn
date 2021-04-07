FROM navikt/java:15
RUN su; apt-get update; apt-get install -y fontconfig libfreetype6
COPY build/libs/*.jar /app/app.jar
COPY init.sh /init-scripts/init.sh
