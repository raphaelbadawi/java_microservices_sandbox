FROM openjdk:17.0.1-jdk
WORKDIR /opt/dungeoneureka

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw clean install -DskipTests

COPY target/dungeoneureka-0.0.1-SNAPSHOT.jar dungeoneureka-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/opt/dungeoneureka/dungeoneureka-0.0.1.jar"]