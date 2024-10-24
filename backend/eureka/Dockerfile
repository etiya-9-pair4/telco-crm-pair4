FROM maven:3.9.9-sapmachine-23 as build
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests
FROM openjdk:23-jdk
COPY --from=build /app/target/eureka-0.0.1.jar /app/eureka.jar
#CMD ["java", "-jar", "/app/eureka.jar", "--spring.config.location=classpath:/application-docker.yml"]
CMD ["java", "-jar", "/app/eureka.jar","-Dspring-boot.run.arguments=--spring.config.location=classpath:/application-podman.properties"]

#FROM maven:3.9.9-sapmachine-23
#WORKDIR /app
#COPY . /app/
#RUN mvn clean package -DskipTests
#CMD ["mvn","spring-boot:run","-Dspring-boot.run.arguments=--spring.config.location=classpath:/application-docker.properties"]
