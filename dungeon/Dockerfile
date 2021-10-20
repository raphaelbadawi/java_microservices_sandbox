FROM openjdk:17.0.1-jdk
WORKDIR /opt/dungeon

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw clean install -DskipTests

COPY target/dungeon-0.0.1-SNAPSHOT.jar dungeon-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/opt/dungeon/dungeon-0.0.1.jar"]