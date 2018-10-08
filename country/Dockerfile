FROM openjdk:8-jre

MAINTAINER Yusupov Dmitry

ADD build/libs/country*.jar /app/country.jar

EXPOSE 8010

CMD [
"java",
"-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8888",
"-Dspring.profiles.active=prod",
"-jar",
"/app/country.jar"
]