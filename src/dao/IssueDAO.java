package dao;

import db.DatabaseHelper;
import java.sql.*;

public class IssueDAO {

    // Issue a book
    public void issueBook(int bookId, String issuedTo, String issueDate) {
        String sql = "INSERT INTO issued_books (book_id, issued_to, issue_date) VALUES (?, ?, ?)";
        try (Connection con = DatabaseHelper.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, bookId);
            ps.setString(2, issuedTo);
            ps.setString(3, issueDate);
            ps.executeUpdate();
            System.out.println("Book issued successfully!");
        } catch (SQLException e) {
            System.out.println("Error issuing book: " + e.getMessage());
        }
    }

    // Return a book
    public void returnBook(int issueId, String returnDate) {
        String sql = "UPDATE issued_books SET return_date = ? WHERE id = ?";
        try (Connection con = DatabaseHelper.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, returnDate);
            ps.setInt(2, issueId);
            ps.executeUpdate();
            System.out.println("Book returned successfully!");
        } catch (SQLException e) {
            System.out.println("Error returning book: " + e.getMessage());
        }
    }
}
