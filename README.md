# AutoCap Backend

This is the **backend** service for **AutoCap**, an AI-powered image captioning application. It is built using **Spring Boot (Java)** and integrates with **OpenRouter** to generate intelligent captions (one short and one long) for uploaded images.

The backend provides REST APIs to receive an image, send it to an AI model via OpenRouter, and return two captions to the frontend.

## ⚙️ Tech Stack

* **Java 17+**
* **Spring Boot Framework**
* **OpenRouter API** (for AI caption generation)
* **Supabase** (used via frontend for storage and auth)
* **RESTful APIs**

## 📦 Features

* Accepts image input (URL or binary data depending on implementation)
* Sends image prompt to an AI model via OpenRouter
* Returns:

  * A **short caption**
  * A **long caption**
* Designed to work with the React frontend: [AutoCap\_frontend](https://github.com/Aaliyakhan10/AutoCap_frontend)
  
## 🚀 Live Demo & Deployment
The backend is deployed and running live at:
https://autocap-em82.onrender.com

You can test the caption API by sending a POST request with an image URL.

Note: The backend is containerized using Docker for easy deployment and scalability.
It’s deployed on Render.com using the Docker image built from this repository.
## 🛠 Setup Instructions

### Prerequisites

* Java 17 or later
* Maven or Gradle
* OpenRouter API key

### Clone the Repository

```bash
git clone https://github.com/Aaliyakhan10/AutoCap_Backend.git
cd AutoCap
```

### Configure Environment

Set your OpenRouter API key in `application.properties` or using environment variables.

`src/main/resources/application.properties`

```properties
API_KEY=${API_KEY}
FRONTEND_URL=${FRONTEND_URL}
```


### Build and Run

If using Maven:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

If using Gradle:

```bash
./gradlew bootRun
```

Backend will run at: `http://localhost:8080`

## 📡 API Endpoints

### `POST /caption-generator`

**Description:** Accepts an image URL or prompt, returns two captions.

**Request Body Example:**

```json
{
  "imgUrl": "https://example.com/image.jpg"
}
```

**Response Example:**

```json
{
  "shortCaption": "A cat sitting on a couch.",
  "longCaption": "A fluffy cat relaxing on a brown couch in a cozy living room setting with sunlight streaming in."
}
```

## 🧠 How It Works

1. Frontend uploads the image to Supabase and sends the image URL to the backend.
2. Backend constructs a prompt and calls the OpenRouter API.
3. OpenRouter returns two types of captions.
4. Backend responds to frontend with both captions.

## 📁 Project Structure

```
AutoCap_Backend/
├── src/
│   ├── main/
│   │   ├── java/com/autocap/
│   │   │   ├── controller/    # REST endpoints
│   │   │   ├── service/       # Business logic for AI interaction
│   │   │   └── congig/
|   |   |   └── dto/         # Request/Response models
│   │   └── resources/
│   │       └── application.properties
├── pom.xml or build.gradle
└── README.md
```

## 🔗 Related Projects

* Frontend: [AutoCap\_frontend](https://github.com/Aaliyakhan10/AutoCap_frontend)

## 📝 License

MIT

