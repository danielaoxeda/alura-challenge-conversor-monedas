# Conversor de monedas | Desafío Backend Alura

Este proyecto forma parte del Challenge Backend de Alura, donde el objetivo es desarrollar un conversor de monedas utilizando Java y consumiendo la API ExchangeRate para obtener tasas de cambio en tiempo real.

## 🚀 Objetivo del proyecto
Construir una aplicación capaz de convertir valores entre distintas monedas, obteniendo información actualizada desde una API externa.

## 🛠 Tecnologías utilizadas
- Java 21  
- Maven (gestión de dependencias y build)
- ExchangeRate API  
- Gson (procesamiento JSON)

## 📁 Estructura del proyecto
```text
src/
 └── main/
     └── java/
         └── com/aluracursos/conversormonedas/
            ├── ApiClient.java
            ├── CurrencyConverter.java
            ├── CurrencyResponse.java
            ├── MenuConverter.java
            └── Main.java
```

## 📌 Funcionalidades implementadas
- Estructura base creada con Java 21 + Maven
- Consumo de ExchangeRate API
- Implementación de las clases:
  ### 🧩 ApiClient
  Encargada de realizar solicitudes HTTP a la API y devolver el JSON recibido como String.
  ### 🧩 CurrencyConverter
  Recibe los datos del ApiClient, usa Gson para convertir el JSON en un objeto CurrencyResponse, extrae la tasa correspondiente y realiza las operaciones de conversión.
  ### 🧩 CurrencyResponse
  Modelo (POJO) que representa la estructura del JSON recibido desde la API.
  Contiene el mapa conversion_rates donde se guardan todas las tasas de cambio disponibles, esto permite acceder fácilmente a valores como:
  ```text
  response.conversion_rates.get("USD");
  ```

  ### 🧩 MenuConverter
  Maneja toda la lógica del menú interactivo:
    - Validación de opciones
    - Lectura de datos del usuario
    - Manejo de errores
    - Mapa de monedas soportadas
    - Resultados formateados con dos decimales
    - Llamadas a CurrencyConverter para ejecutar las conversiones
  ### 🧩 Main
  Ejecuta el programa llamando al menú, manteniendo la arquitectura limpia.

## 📌 Pasos del desafío

### 🔧 1. Configuración del ambiente Java
Configuración del entorno y dependencias mediante Maven.
### 📂 2. Creación del proyecto
Inicialización y estructuración del proyecto con arquitectura clara.
### 🌐 3. Consumo de la API
Solicitud HTTP para obtener tasas en tiempo real según la moneda base.
### 🧩 4. Análisis del JSON
Uso de Gson para convertir JSON a objetos Java.
### 💱 5. Filtro y selección de monedas
Restricción a monedas relevantes para el desafío.
### 🖥️ 6. Exhibición de resultados
Menú interactivo y salida formateada al usuario.

## 🎯 Resultado esperado
El usuario podrá:
- Convertir valores entre monedas de forma precisa
- Visualizar resultados claros con dos decimales
- Navegar por un menú intuitivo
- Recibir mensajes de error amigables si algo falla
  
## 🤝 Contribuciones
Si deseas contribuir, haz un fork del repositorio y envía un Pull Request. ¡Toda mejora es bienvenida!

## 📄 Licencia
Proyecto creado con fines educativos y de uso libre.
