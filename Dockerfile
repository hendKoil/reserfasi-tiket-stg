FROM openjdk:8
EXPOSE 8081
ADD target/api-reserfasi-tiket.jar api-reserfasi-tiket.jar
ENTRYPOINT ["java", "-jar", "/api-reserfasi-tiket.jar"]