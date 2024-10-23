# Swapped

The **Swapped** is a chat based social deduction game inspired by the movie *It’s What’s Inside*. Participants join a session and communicate under randomly swapped identities. The objective is to guess who is behind each identity through interactions in the chat. Players eliminate others through correct guesses, with the goal of being the last player standing.

---

## Core Features
- **Real-time Communication**: Players chat under swapped identities via a messaging interface.
- **Identity Guessing Mechanic**: Players guess who is behind which identity.  
  - Correct guess: Guessed player is eliminated.  
  - Incorrect guess: Guesser is eliminated.
- **Game Session Management**: Unique session IDs allow multiple game rooms.
- **Scoring System: Rewards for correct and quick guesses.

---

## Tech Stack
### **Frontend**
- **Next.js**: Provides an interactive UI with server-side rendering (SSR).

### **Backend**
- **Spring Boot**: Manages game logic, sessions, and API endpoints.

---

## Deployment
- **Frontend**: Hosted on **Vercel** for fast and scalable web hosting.  
- **Backend**: Deployed on **Render** to expose RESTful APIs.

---

## How It Works
1. **Create or Join a Game**: Players start a new session or join an existing one using a unique session ID.
2. **Identity Swap**: The backend assigns random identities to players.
3. **Guessing and Elimination**:  
   - Players chat and try to identify others.  
   - A correct guess eliminates the guessed player.  
   - An incorrect guess eliminates the guesser.
4. **End of Round**: The game ends when two players remain, revealing their identities.

---

## Setup Instructions

### Prerequisites
- **Java 17+**
- **Node.js 18+**

### Local Development Setup Steps

1. **Clone Repositories**  
     ```bash
     git clone (https://github.com/michaelcao512/swapped.git)
     ```

2. **Backend Setup (Spring Boot)**
   
   - Build and run the backend:  
     ```bash
     cd <backend folder>
     ./mvnw spring-boot:run
     ```
   - Verify it is running at `http://localhost:8080/api/hello`.

4. **Frontend Setup (Next.js)**  
   - Install dependencies:  
     ```bash
     cd <frontend folder>
     npm install
     ```
   - Run the frontend:  
     ```bash
     npm run dev
     ```
   - Open `http://localhost:3000` in your browser.

---

## Contact
Michael Cao - michaelcao512@gmail.com
