FROM amazoncorretto:17.0.9-alpine3.18

WORKDIR /app
COPY build/libs/posttest-0.0.1-SNAPSHOT.jar .
EXPOSE 8888
ENTRYPOINT ["java","-jar","posttest-0.0.1-SNAPSHOT.jar"]