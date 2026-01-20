# Use Java 17
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy all project files
COPY . .

# Give permission to mvnw
RUN chmod +x mvnw

# Build the app (skip tests to avoid DB error)
RUN ./mvnw clean package -DskipTests

# Expose Render port
EXPOSE 8080

# Run Spring Boot jar
CMD ["java", "-jar", "target/app-0.0.1-SNAPSHOT.jar"]
