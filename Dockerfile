FROM openjdk:latest
COPY ./target/Group_8_SEM_CW-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Group_8_SEM_CW-0.1.0.2-jar-with-dependencies.jar"]
