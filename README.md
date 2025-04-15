# 🧙‍♂️ personaje-service

`personaje-service` es un microservicio desarrollado en Java con Spring Boot, orientado a gestionar personajes del universo de Elden Ring. Forma parte de un sistema distribuido de microservicios basado en arquitectura reactiva.

## 🚀 Tecnologías utilizadas

- **Spring WebFlux** – Framework reactivo para construir APIs no bloqueantes.
- **Project Reactor** – Librería de programación reactiva para manejar flujos asíncronos.
- **MongoDB** – Base de datos NoSQL orientada a documentos.
- **Docker** – Contenerización para facilitar la ejecución del servicio en entornos controlados.
- **Java 21**

## ⚙️ Características principales

- API REST totalmente reactiva.
- Persistencia en MongoDB usando Spring Data Reactive.
- Validaciones y control de errores personalizados.
- Preparado para entornos de desarrollo y despliegue con Docker.
- Configuración desacoplada mediante `application.yml`.

## 📁 Estructura del proyecto

personaje-service/ ├── src/ │ ├── main/ │ │ ├── java/com/lucasdev/personajeservice/ │ │ │ ├── modelo/ │ │ │ ├── servicio/ │ │ │ ├── handler/ │ │ │ ├── router/ │ │ │ └── config/ │ └── resources/ │ └── application.yml ├── Dockerfile ├── docker-compose.yml └── pom.xml



## 🔌 Endpoints REST

| Método | Endpoint              | Descripción                     |
|--------|------------------------|---------------------------------|
| GET    | `/personajes`         | Listar todos los personajes     |
| GET    | `/personajes/{id}`    | Obtener personaje por ID        |
| POST   | `/personajes`         | Crear nuevo personaje           |
| DELETE | `/personajes/{id}`    | Eliminar personaje por ID       |
| GET    | `/clases`             | Listar clases válidas de personaje |

## 🐳 Docker

### Construcción del contenedor

```bash
docker build -t personaje-service .

