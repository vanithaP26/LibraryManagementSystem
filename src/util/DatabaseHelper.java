package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    private static final String URL = "jdbc:sqlite:library.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initializeDatabase() {
        try (Connection con = getConnection();
             Statement stmt = con.createStatement()) {

            // Create books table
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS books (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "title TEXT NOT NULL," +
                    "author TEXT," +
                    "publisher TEXT," +
                    "year INTEGER," +
                    "quantity INTEGER)");

            // Create issued_books table
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS issued_books (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "book_id INTEGER," +
                    "issued_to TEXT NOT NULL," +
                    "issue_date TEXT," +
                    "return_date TEXT," +
                    "FOREIGN KEY(book_id) REFERENCES books(id))");

            System.out.println("Database initialized successfully!");

        } catch (SQLException e) {
            System.out.println("Database initialization failed: " + e.getMessage());
        }
    }
}
