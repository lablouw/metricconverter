FROM java:8-jdk-alpine

COPY ./target/techbasics-1.0-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch techbasics-1.0-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","techbasics-1.0-SNAPSHOT.jar"]