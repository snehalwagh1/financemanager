FROM openjdk:17-oracle
EXPOSE 9010
ARG JAR_FILE=target/finance-manager-0.0.1.jar
COPY ${JAR_FILE} finance-manager.jar
ENTRYPOINT ["java","-jar","/finance-manager.jar"]