package dao;

import java.sql.*;
import java.util.*;
import model.Book;
import util.DatabaseConnection;

public class BookDAO {

    // ➕ Add a new book to the database
    public void addBook(Book book) {
        String query = "INSERT INTO books (title, author, publisher, year, quantity) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getPublisher());
            ps.setInt(4, book.getYear());
            ps.setInt(5, book.getQuantity());
            ps.executeUpdate();
            System.out.println(" Book added successfully!");

        } catch (SQLException e) {
            System.out.println(" Error adding book: " + e.getMessage());
        }
    }

    //  View all books
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";
        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Book b = new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("publisher"),
                    rs.getInt("year"),
                    rs.getInt("quantity")
                );
                books.add(b);
            }
        } catch (SQLException e) {
            System.out.println(" Error fetching books: " + e.getMessage());
        }
        return books;
    }

    //  Update quantity of a book
    public void updateBookQuantity(int id, int newQty) {
        String query = "UPDATE books SET quantity=? WHERE id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, newQty);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();

            if (rows > 0) System.out.println(" Quantity updated successfully!");
            else System.out.println(" Book not found.");

        } catch (SQLException e) {
            System.out.println("Error updating quantity: " + e.getMessage());
        }
    }

    //  Delete a book by ID
    public void deleteBook(int id) {
        String query = "DELETE FROM books WHERE id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0) System.out.println(" Book deleted successfully!");
            else System.out.println(" Book not found.");

        } catch (SQLException e) {
            System.out.println(" Error deleting book: " + e.getMessage());
        }
    }
}
