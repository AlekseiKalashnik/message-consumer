FROM openjdk:17-jdk-slim
EXPOSE 8184
ARG JAR_FILE=*.jar
COPY ssl /etc/ssl
COPY ${JAR_FILE} consumer.jar
ENTRYPOINT ["java", "-jar", "/consumer.jar"]
