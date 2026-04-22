FROM eclipse-temurin:25

WORKDIR /app

COPY codecaseapi-0.0.1-SNAPSHOT.jar /app/CarotteCaseAPI.jar

EXPOSE 9002

LABEL authors="Mordant Thierry"

CMD ["java", "-jar", "CarotteCaseAPI.jar"]