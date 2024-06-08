FROM openjdk:17-jdk

WORKDIR /app

COPY build/libs/read-from-cassandra-1.0-SNAPSHOT.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","app.jar"]
