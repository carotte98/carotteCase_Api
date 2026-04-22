FROM openjdk:25

WORKDIR /app

COPY carotteCase_Api.jar /app/carotteCase_Api.jar

EXPOSE 9002

LABEL authors="Mordant Thierry"

CMD ["java", "-jar", "carotteCase_Api.jar"]