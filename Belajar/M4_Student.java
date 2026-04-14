/*
 * ========================================
 * M4: MATERI TEORI 4
 * Encapsulation & Access Modifiers
 * ========================================
 * Topik:
 * - Private attributes (data hiding)
 * - Getter & Setter dengan VALIDASI
 * - Access modifiers (private/public/protected)
 * - Data protection
 * ========================================
 */

public class M4_Student {
    // ENCAPSULATION - Private attributes
    private String username;
    private int age;
    private String email;
    private double gpa;
    
    // Constructor
    public M4_Student(String username, int age, String email, double gpa) {
        // Pakai setter supaya ada validasi!
        setUsername(username);
        setAge(age);
        setEmail(email);
        setGpa(gpa);
    }
    
    // ===== GETTER & SETTER DENGAN VALIDASI =====
    
    // Username - minimal 3 karakter
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        if (username != null && username.length() >= 3) {
            this.username = username;
        } else {
            System.out.println("Error: Username harus minimal 3 karakter!");
            this.username = "guest";  // Default value
        }
    }
    
    // Age - harus antara 1-150
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            System.out.println("Error: Usia tidak valid (harus 1-150)!");
            this.age = 0;  // Default value
        }
    }
    
    // Email - harus mengandung @
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Error: Email harus mengandung '@'!");
            this.email = "unknown@example.com";
        }
    }
    
    // GPA - harus antara 0.0-4.0
    public double getGpa() {
        return gpa;
    }
    
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Error: GPA harus antara 0.0-4.0!");
            this.gpa = 0.0;
        }
    }
    
    // Display info
    public void displayInfo() {
        System.out.println("===== STUDENT INFO =====");
        System.out.println("Username: " + username);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("GPA: " + gpa);
        System.out.println("========================");
    }
}