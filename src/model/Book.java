package model;

public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private int quantity;

    public Book(String title, String author, String publisher, int year, int quantity) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.quantity = quantity;
    }

    public Book(int id, String title, String author, String publisher, int year, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.quantity = quantity;
    }

    // Getters and Setters...
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return String.format("Book[ID=%d, Title=%s, Author=%s, Publisher=%s, Year=%d, Qty=%d]",
                id, title, author, publisher, year, quantity);
    }
}
