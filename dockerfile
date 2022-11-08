FROM openjdk:8-jdk-alpine
EXPOSE 8080:8080
COPY ./target/enterprise_homework10-1.0.war /usr/app/
WORKDIR /usr/app/
ENTRYPOINT ["java","-jar","enterprise_homework10-1.0.war"]