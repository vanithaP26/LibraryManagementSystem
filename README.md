📚 Library Management System (Java + SQLite)
🔍 Overview

The Library Management System is a console-based Java application that allows users to manage books efficiently.
It supports adding, viewing, issuing, and returning books with permanent storage using SQLite and JDBC.

⚙️ Tech Stack

Language: Java (JDK 17 or higher)

Database: SQLite

Database Driver: sqlite-jdbc-3.50.3.0.jar

IDE/Editor: VS Code / Eclipse

Build Tool: Command Line (javac, java)

🗂️ Project Structure
LibraryManagementSystem/
│
├── lib/
│   └── sqlite-jdbc-3.50.3.0.jar
│
├── src/
│   ├── util/
│   │   └── DatabaseConnection.java
│   │
│   ├── db/
│   │   └── DatabaseHelper.java
│   │
│   ├── model/
│   │   └── Book.java
│   │
│   ├── dao/
│   │   ├── BookDAO.java
│   │   └── IssueDAO.java
│   │
│   └── main/
│       └── Main.java
│
├── out/
│   └── (compiled .class files)
│
└── README.md

🚀 How to Compile and Run
🧩 Step 1 — Navigate to the project folder
cd C:\Users\sudee\LibraryManagementSystem

⚙️ Step 2 — Compile all Java files
javac -d out -cp ".;lib/sqlite-jdbc-3.50.3.0.jar" src/util/*.java src/db/*.java src/model/*.java src/dao/*.java src/main/*.java


✅ This command:

Compiles all Java source files

Outputs .class files in the out folder

Links the SQLite JDBC driver

▶️ Step 3 — Run the application

java -cp "out;lib/sqlite-jdbc-3.50.3.0.jar" main.Main

💡 Features

➕ Add new books

📚 View all books

✏️ Update or delete books

📖 Issue and return books

🔍 Search by title or author

🧠 Persistent SQLite database

🗄️ Database

Automatically creates LibraryDB.db

Tables:

books

issued_books

🧱 Future Enhancements

🖥️ Add GUI using JavaFX or Swing

🔐 Implement user authentication

📊 Add reports and analytics

💰 Include fine calculation for late returns

📸 Example Console Output

====== Library Management System ======
1. Add Book
2. View Books
3. Update Book
4. Delete Book
5. Issue Book
6. Return Book
7. Exit
Enter your choice:

👤 Author

Developed by: Vanitha P
📧 Email: vanithavani.p26@gmail.com

💼 GitHub: github.com/vanithaP26



⭐ If you like this project, give it a star on GitHub!