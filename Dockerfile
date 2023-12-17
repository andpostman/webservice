FROM eclipse-temurin:17-alpine
ADD ./target/*.jar app.jar
RUN ["mkdir", "/config"]
COPY /sql/application.yaml /config
ENTRYPOINT ["java","-Dfile.encoding=UTF-8","-Djava.security.egd=file:/dev/./urandom","-Duser.timezone=Europe/Moscow","-Dspring.config.location=file:/config/application.yaml","-jar","-Dspring.profiles.active=production","app.jar"]
