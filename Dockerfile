FROM java:8-jdk-alpine

COPY ./target/metricconverter-1.0-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch metricconverter-1.0-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","metricconverter-1.0-SNAPSHOT.jar"]