FROM eclipse-temurin:25

WORKDIR /app

COPY CarotteCaseAPI.jar /app/CarotteCaseAPI.jar

EXPOSE 9002

LABEL authors="Mordant Thierry"

CMD ["java", "-jar", "carotteCase_Api.jar"]