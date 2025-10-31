package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:library.db"; // Database path
    private static Connection connection = null;

    // Method to connect to the SQLite DB
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL);
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return connection;
    }
}
