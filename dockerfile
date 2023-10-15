FROM openjdk:17-jdk-slim

COPY domino-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "domino-0.0.1-SNAPSHOT.jar"]
