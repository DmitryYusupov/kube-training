FROM openjdk:8-jre

MAINTAINER Yusupov Dmitry

ADD build/libs/country*.jar /app/country.jar

EXPOSE 8010

CMD ["java",
"- agentlib:jdwp=transport=dt_socket,address=8888,server=y,suspend=n",
"-jar",
"/app/country.jar"]