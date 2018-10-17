FROM openjdk:8-jre

MAINTAINER Yusupov Dmitry

ADD build/libs/memory-leak*.jar /app/memory-leak.jar

CMD ["java","-Xmx4096m", "-jar", "/app/memory-leak.jar"]