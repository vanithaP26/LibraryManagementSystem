package main;

import dao.BookDAO;
import model.Book;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Update Quantity");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {
                    case 1:
                        addBook(sc, dao);
                        break;
                    case 2:
                        viewBooks(dao);
                        break;
                    case 3:
                        deleteBook(sc, dao);
                        break;
                    case 4:
                        updateQuantity(sc, dao);
                        break;
                    case 5:
                        System.out.println("Exiting Library Management System...");
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine(); // clear invalid input
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    // Add a new book
    private static void addBook(Scanner sc, BookDAO dao) {
        try {
            System.out.print("Enter Title: ");
            String title = sc.nextLine().trim();

            System.out.print("Enter Author: ");
            String author = sc.nextLine().trim();

            System.out.print("Enter Publisher: ");
            String publisher = sc.nextLine().trim();

            System.out.print("Enter Year: ");
            int year = sc.nextInt();
            if (year < 0 || year > 2025) {
                System.out.println("Invalid year! Please enter a valid publication year.");
                return;
            }

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();
            if (quantity <= 0) {
                System.out.println("Quantity must be greater than 0.");
                return;
            }

            Book newBook = new Book(title, author, publisher, year, quantity);
            dao.addBook(newBook);
        } catch (InputMismatchException e) {
            System.out.println("Please enter numbers for Year and Quantity only.");
            sc.nextLine(); // clear wrong input
        }
    }

    // View all books
    private static void viewBooks(BookDAO dao) {
        List<Book> books = dao.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books found!");
        } else {
            System.out.println("\nAvailable Books:");
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    // Delete a book
    private static void deleteBook(Scanner sc, BookDAO dao) {
        try {
            System.out.print("Enter Book ID to delete: ");
            int id = sc.nextInt();
            dao.deleteBook(id);
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid numeric ID!");
            sc.nextLine();
        }
    }

    // Update book quantity
    private static void updateQuantity(Scanner sc, BookDAO dao) {
        try {
            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();

            System.out.print("Enter new Quantity: ");
            int qty = sc.nextInt();

            if (qty <= 0) {
                System.out.println("Quantity must be positive.");
                return;
            }

            dao.updateQuantity(id, qty);
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid numeric values!");
            sc.nextLine();
        }
    }
}
