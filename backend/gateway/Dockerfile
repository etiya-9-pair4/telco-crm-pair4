FROM maven:3.9.9-sapmachine-23 as build
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests
FROM openjdk:23-jdk
COPY --from=build /app/target/gateway-0.0.1.jar /app/gateway.jar
#CMD ["java", "-jar", "/app/gateway.jar"]
CMD ["java", "-jar", "/app/gateway.jar","-Dspring-boot.run.arguments=--spring.config.location=classpath:/application-podman.properties"]
