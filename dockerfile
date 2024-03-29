FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD . /app
WORKDIR /app
RUN ./mvnw clean package -Dmaven.test.skip
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/enterprise_homework13-1.0.war"]