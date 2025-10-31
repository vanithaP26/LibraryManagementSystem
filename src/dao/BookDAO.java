package dao;

import db.DatabaseHelper;
import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // ✅ Add a new book to the database
    public void addBook(Book book) {
        String sql = "INSERT INTO books (title, author, publisher, year, quantity) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getPublisher());
            pstmt.setInt(4, book.getYear());
            pstmt.setInt(5, book.getQuantity());
            pstmt.executeUpdate();

            System.out.println(" Book added successfully!");

        } catch (SQLException e) {
            System.out.println(" Error adding book: " + e.getMessage());
        }
    }

    // ✅ Retrieve all books from the database
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getInt("year"),
                        rs.getInt("quantity")
                );
                books.add(book);
            }

        } catch (SQLException e) {
            System.out.println(" Error fetching books: " + e.getMessage());
        }
        return books;
    }

    // ✅ Delete a book by ID
    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println(" Book deleted successfully!");
            else
                System.out.println(" No book found with ID: " + id);

        } catch (SQLException e) {
            System.out.println(" Error deleting book: " + e.getMessage());
        }
    }

    // ✅ Update book quantity
    public void updateQuantity(int id, int quantity) {
        String sql = "UPDATE books SET quantity = ? WHERE id = ?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, quantity);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("✅ Quantity updated successfully!");

        } catch (SQLException e) {
            System.out.println(" Error updating quantity: " + e.getMessage());
        }
    }
}
