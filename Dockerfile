# 1. Use Java 17 (recommended for Spring Boot)
FROM eclipse-temurin:17-jdk

# 2. Set working directory
WORKDIR /app

# 3. Copy jar file
COPY target/*.jar app.jar

# 4. Expose port (Render uses 8080)
EXPOSE 8080

# 5. Run Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
