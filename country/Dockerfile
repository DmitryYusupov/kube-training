FROM openjdk:8-jre

MAINTAINER Yusupov Dmitry

ADD build/libs/country*.jar /app/country.jar

EXPOSE 8010

CMD ["java", "-jar", "/app/country.jar"]