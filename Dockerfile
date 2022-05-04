FROM amazoncorretto:11-alpine-jdk
MAINTAINER bayro
COPY target/Transaction-0.0.1-SNAPSHOT.jar /Transaction.jar
ENTRYPOINT ["java","-jar","/Transaction.jar"]

