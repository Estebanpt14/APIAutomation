# RestAssured API Testing Project 🚀

Este proyecto implementa pruebas automatizadas de API utilizando **RestAssured** junto con **Cucumber** para definir escenarios en un formato BDD.

## 📌 Características
- Pruebas automatizadas de API con **RestAssured**.
- Uso de **Cucumber** para definir escenarios en lenguaje natural.
- Validación de respuestas HTTP con **JUnit** y **Assert**.
- Soporte para autenticación con **OAuth 2.0** y claves API.
- Validación de estructuras JSON en las respuestas.

## 📦 Requisitos
Antes de comenzar, asegúrate de tener instalado:
- [Java 8+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/download.cgi) o [Gradle](https://gradle.org/install/)
- Un IDE como IntelliJ IDEA o Eclipse

## 🚀 Instalación
Instala las dependencias con **Maven**:
```sh
mvn clean install
```
O si usas **Gradle**:
```sh
gradle build
```

## ▶️ Ejecución
Para ejecutar las pruebas con **Maven**, usa:
```sh
mvn test
```
Para ejecutar las pruebas con **Gradle**, usa:
```sh
gradle test
```

## 📌 Dependencias Clave
Este proyecto utiliza las siguientes dependencias:
```xml
<dependencies>
    <!-- RestAssured para pruebas de API -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.3.0</version>
    </dependency>
    
    <!-- Cucumber para pruebas BDD -->
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.11.0</version>
    </dependency>
    
    <!-- JUnit para validaciones -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
    </dependency>
</dependencies>
```

## 📜 Escenarios de Prueba
### 📍 Autenticación con API Key
```gherkin
Scenario: Obtener un token de acceso válido
  Given I have a valid API key for the "https://api.example.com"
  When I send a POST request with a valid body to the endpoint "/token"
  Then I can validate I received a valid token in the response
```

## 🏆 Autor
👤 **Esteban Peña**  
📧 Contacto: [Tu Email o LinkedIn]