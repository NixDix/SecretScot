FROM maven:3.6.3-jdk-11-slim AS builder

WORKDIR /root
COPY pom.xml /root

COPY ./src /root/src
RUN mvn clean package assembly:single

FROM openjdk:11-jre-slim

COPY --from=builder /root/target/secretscot-0.1.0-SNAPSHOT-jar-with-dependencies.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
