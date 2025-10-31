package main;

import java.util.*;
import dao.BookDAO;
import model.Book;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        while (true) {
            System.out.println("\n=====  LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Update Book Quantity");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Publisher: ");
                    String publisher = sc.nextLine();
                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    Book b = new Book(title, author, publisher, year, qty);
                    dao.addBook(b);
                    break;

                case 2:
                    List<Book> books = dao.getAllBooks();
                    System.out.println("\n--- Book List ---");
                    for (Book bk : books) {
                        System.out.println(bk);
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to update: ");
                    int idU = sc.nextInt();
                    System.out.print("Enter new Quantity: ");
                    int newQty = sc.nextInt();
                    dao.updateBookQuantity(idU, newQty);
                    break;

                case 4:
                    System.out.print("Enter Book ID to delete: ");
                    int idD = sc.nextInt();
                    dao.deleteBook(idD);
                    break;

                case 5:
                    System.out.println(" Exiting... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
