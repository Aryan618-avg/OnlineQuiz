# Java Real-Time Trivia System
## Project Description
Java Real-Time Trivia System is a simple, interactive Java-based console application that allows users to play a multiple-choice quiz game. Questions are fetched dynamically from the Open Trivia Database (OpenTDB) API, providing a new and random set of questions every time you play. This project demonstrates API integration, JSON parsing using Gson, and core Java programming concepts.

## Features
* **Real-time Data Fetching:** Uses `java.net.http.HttpClient` to connect to a live API.
* **JSON Parsing:** Robust handling of API responses using Google's **Gson** library.
* **Dynamic Gameplay:** Options are shuffled for every question so the answers aren't predictable.
* **Data Sanitization:** Includes a custom decoder to handle HTML entities (e.g., converting `&quot;` to `"`).
* **Session Scoreboard:** Tracks the user's score throughout the session.

## Technologies Used
* **Language:** Java (JDK 11+)
* **Libraries:** Google Gson (2.11.0)
* **API:** Open Trivia DB
* **Tools:** VS Code

## 📂 Project Structure
```text
root/
├── lib/
│   └── gson-2.11.0.jar   # External dependency for JSON parsing
├── OnlineQuizApp.java    # Main source code
└── README.md             # Documentation
```
      
## How to Run Locally
### Windows (PowerShell/CMD):
## Compile
javac -cp ".;lib/gson-2.11.0.jar" OnlineQuizApp.java

## Run
java -cp ".;lib/gson-2.11.0.jar" OnlineQuizApp

### Linux / macOS / Git Bash:
## Compile
javac -cp ".:lib/gson-2.11.0.jar" OnlineQuizApp.java

## Run
java -cp ".:lib/gson-2.11.0.jar" OnlineQuizApp

## Sample Output
```text
🌐 Welcome to the Online Quiz Game!
----------------------------------

Question: Which company developed the video game Minecraft?
A. Sony
B. Mojang
C. Nintendo
D. Ubisoft
Enter your answer (A/B/C/D): B

 Correct!

Do you want to continue the game? (yes/no): 
```
## Future Improvements
* **Category Selection:** Allow users to choose specific topics (Science, History, Tech).
* **Timer:** Add a countdown timer for each question to increase difficulty.
* **Database Integration:** Save high scores using a local database or file system.
* **GUI:** Upgrade from CLI to a graphical interface using JavaFX.



