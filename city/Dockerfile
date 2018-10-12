FROM openjdk:8-jre

MAINTAINER Yusupov Dmitry

ADD build/libs/city*.jar /app/city.jar

EXPOSE ${CITY_APP_PORT}

CMD ["java", "-jar", "/app/city.jar"]