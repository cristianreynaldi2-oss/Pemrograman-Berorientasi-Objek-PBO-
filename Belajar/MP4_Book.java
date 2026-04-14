/*
 * ========================================
 * MP4: MATERI PRAKTIKUM 4
 * Constructor Overloading & Validation
 * ========================================
 * Topik:
 * - Constructor Overloading (2+ constructor)
 * - Setter dengan validasi
 * - Default values
 * - Class Diagram implementation
 * ========================================
 */

public class MP4_Book {
    // Private attributes (Encapsulation)
    private String bookId;
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;
    
    // ===== CONSTRUCTOR OVERLOADING =====
    
    // Constructor 1: ID dan Title saja (BASIC)
    public MP4_Book(String bookId, String title) {
        this.bookId = bookId;
        this.title = title;
        this.author = "Unknown";  // Default value
        this.price = 0.0;
        this.isAvailable = true;
    }
    
    // Constructor 2: Dengan Author (OVERLOADING!)
    public MP4_Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = 0.0;
        this.isAvailable = true;
    }
    
    // Constructor 3: Lengkap dengan Price (OVERLOADING!)
    public MP4_Book(String bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        
        // Pakai setter supaya ada validasi!
        setPrice(price);
    }
    
    // Constructor 4: FULL (semua parameter)
    public MP4_Book(String bookId, String title, String author, double price, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
        
        setPrice(price);  // Validasi price
    }
    
    
    // ===== GETTER & SETTER =====
    
    public String getBookId() {
        return bookId;
    }
    
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public double getPrice() {
        return price;
    }
    
    // Setter dengan VALIDASI (Logic Implementation!)
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Warning: Price harus > 0. Set ke default (0.0)");
            this.price = 0.0;
        }
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    
    // ===== DISPLAY METHOD =====
    
    public void displayInfo() {
        System.out.println("===== BOOK INFO =====");
        System.out.println("ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: Rp " + price);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("=====================");
    }
}