# Usar una imagen base de OpenJDK
FROM openjdk:21-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR del microservicio
COPY target/objeto-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que se ejecutará el microservicio
EXPOSE 8081

# Comando para ejecutar el microservicio
ENTRYPOINT ["java", "-jar", "app.jar"]
