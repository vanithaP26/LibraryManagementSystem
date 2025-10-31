# 📚 Library Management System

This is a **console-based Java project** that helps manage books in a library.

---

## 📝 Features
- Add new books  
- View all books  
- Update quantity of a book  
- Delete a book  
- Data is stored using **SQLite database**

---

## ⚙️ Tools & Technologies
- Java (JDK 17 or above)
- SQLite
- JDBC driver (`sqlite-jdbc-3.50.3.0.jar`)
- VS Code
- Git & GitHub

---

## 🚀 How to Run
1. Open PowerShell or CMD in your project folder  
2. Compile the project:
   ```bash
   javac -d out -cp ".;lib/sqlite-jdbc-3.50.3.0.jar" src/util/*.java src/model/*.java src/dao/*.java src/main/*.java
