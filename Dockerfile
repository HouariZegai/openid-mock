FROM openjdk:17
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar