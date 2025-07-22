FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy config from current dir (place it next to the Dockerfile)
RUN mkdir -p /app/config

COPY application.properties /app/config/
COPY target/utility-service-0.0.1-SNAPSHOT.jar .

CMD ["java", "-Xmx256m", "-jar", "utility-service-0.0.1-SNAPSHOT.jar", "--spring.config.additional-location=optional:file:/app/config/"]
