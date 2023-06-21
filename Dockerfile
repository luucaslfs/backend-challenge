FROM amazoncorretto:17.0.7-alpine

ENV APP_NAME backend-challenge
MAINTAINER luucaslfs.com
COPY target/${APP_NAME}.jar ${APP_NAME}.jar
CMD ["java","-jar","/backend-challenge.jar"]
