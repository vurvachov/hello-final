FROM gradle:7.1.1-jdk16 AS base
WORKDIR /opt/hello-final
COPY ./ ./
RUN ./gradlew assemble

FROM adoptopenjdk/jre-16.0.1_9-alpine
WORKDIR /opt/hello-final
COPY --from=base /opt/hello-final/build/libs/hello-final-0.0.1-SNAPSHOT.jar ./
CMD java -jar hello-final-0.0.1-SNAPSHOT.jar .
