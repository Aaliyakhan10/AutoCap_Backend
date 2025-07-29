# AutoCap Frontend

AutoCap is an AI-powered image captioning application. Users can upload an image and receive **two AI-generated captions**: one **short** and one **long**. Captions can be easily copied using provided buttons. This repository contains the **frontend** of the application, built using **React**, integrated with a **Spring Boot** backend and **Supabase** for storage and authentication.

## ✨ Features

* 📤 Upload any image
* 🤖 Receive two AI-generated captions:

  * Short Caption
  * Long Caption
* 📋 One-click **Copy** buttons for both captions
* ⚙️ Built with:

  * React (Frontend)
  * Supabase (Storage & Auth)
  * Spring Boot (Java Backend)

## 📸 Demo

![AutoCap Live Link](https://autocapai.netlify.app/)

## 🚀 Getting Started

### Prerequisites

* Node.js (v14 or later)
* npm or yarn
* Supabase project
* Running Spring Boot backend (connected via API)

### Clone the Repository

```bash
git clone https://github.com/Aaliyakhan10/AutoCap_frontend.git
cd AutoCap_frontend
```

### Install Dependencies

```bash
npm install
# or
yarn install
```

### Environment Variables

Create a `.env` file in the root directory and add your Supabase credentials:

```env
VITE_SUPABASE_URL=your_supabase_url
VITE_SUPABASE_API_KEY=your_supabase_anon_key
VITE_BACKEND_URL=http://localhost:8080  # Or your deployed backend
```

### Run the App

```bash
npm run dev
# or
yarn dev
```

Open [http://localhost:5173](http://localhost:5173) to view it in the browser.

## 🔗 Backend Repository

This frontend is connected to a Spring Boot backend for image processing and caption generation. (Add link here if public)

## 📄 License

MIT

