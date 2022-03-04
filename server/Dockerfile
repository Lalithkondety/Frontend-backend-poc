FROM maven as builder
COPY . .
RUN mvn package


FROM openjdk:8-jdk-alpine
COPY --from=builder /target/backend-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","/backend-0.0.1-SNAPSHOT.jar"]