FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD target/*.jar  app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


#FROM openjdk:8u111-jdk-alpine
#VOLUME /tmp
#ADD /target/*.jar app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]