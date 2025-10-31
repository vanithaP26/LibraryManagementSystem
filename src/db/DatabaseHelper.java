package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {

    // Database URL (SQLite creates this file automatically)
    private static final String DB_URL = "jdbc:sqlite:library.db";

    // Method to get database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // Method to create table if not exists
    public static void initializeDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS books ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "title TEXT NOT NULL,"
                + "author TEXT,"
                + "publisher TEXT,"
                + "year INTEGER,"
                + "quantity INTEGER NOT NULL"
                + ");";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("✅ Database connected and 'books' table ready!");
        } catch (SQLException e) {
            System.out.println(" Database error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        initializeDatabase();
    }
}
