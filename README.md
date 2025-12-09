# Online Quiz App
## Project Description
Online Quiz App is a simple, interactive Java-based console application that allows users to play a multiple-choice quiz game. Questions are fetched dynamically from the Open Trivia Database (OpenTDB) API, providing a new and random set of questions every time you play. This project demonstrates API integration, JSON parsing using Gson, and basic Java programming skills.
## Features
Fetches random multiple-choice questions from an online API.
Shuffles answer options to make the quiz more challenging.
Displays correct answers for wrong attempts.
Keeps track of user score.
Option to continue or exit the game at any time.
Handles HTML entities in questions and answers (e.g., " or ').

## Technologies Used
### Technologies Used
* **Language:** Java (JDK 11+)
* **Libraries:** Google Gson (2.11.0)
* **API:** Open Trivia DB
* **Tools:** VS Code

## Project Structure
root/
├── lib/
│   └── gson-2.11.0.jar   
├── OnlineQuizApp.java    
└── README.md             
## How to Run Locally
Windows (PowerShell/CMD):
## Compile
javac -cp ".;lib/gson-2.11.0.jar" OnlineQuizApp.java

## Run
java -cp ".;lib/gson-2.11.0.jar" OnlineQuizApp

Linux / macOS / Git Bash:
## Compile
javac -cp ".:lib/gson-2.11.0.jar" OnlineQuizApp.java

## Run
java -cp ".:lib/gson-2.11.0.jar" OnlineQuizApp

## Sample Output
🌐 Welcome to the Online Quiz Game!
----------------------------------

Question: Which company developed the video game Minecraft?
A. Sony
B. Mojang
C. Nintendo
D. Ubisoft
Enter your answer (A/B/C/D): B
✅ Correct!
Do you want to continue the game? (yes/no):

## Future Improvements
Category Selection: Allow users to choose specific topics (Science, History, Tech).
Timer: Add a countdown timer for each question to increase difficulty.
Database Integration: Save high scores using a local database or file system.
GUI: Upgrade from CLI to a graphical interface using JavaFX.



