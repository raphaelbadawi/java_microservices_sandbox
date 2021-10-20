FROM openjdk:17.0.1-jdk
WORKDIR /opt/dungeonfront

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw clean install -DskipTests

COPY target/dungeonfront-0.0.1-SNAPSHOT.jar dungeonfront-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/opt/dungeonfront/dungeonfront-0.0.1.jar"]