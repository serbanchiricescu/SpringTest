FROM openjdk:11-jdk-slim
ENV PORT 8080
ENV CLASSPATH /opt/lib
EXPOSE $PORT

WORKDIR /opt

COPY target/*.jar app.jar

ENTRYPOINT ["sh", "-c", "java -noverify -XX:+AlwaysPreTouch -Duser.timezone=UTC -jar app.jar"]