FROM eclipse-temurin:17-jdk-alpine

WORKDIR '/home/pankaj/microservices'

COPY target/currency-exchange*.jar currency-exchange.jar

RUN chmod -R 777 /home/pankaj /home/pankaj/microservices /home/pankaj/microservices/currency-exchange.jar
 
ENTRYPOINT ["java", "-jar", "currency-exchange.jar"]