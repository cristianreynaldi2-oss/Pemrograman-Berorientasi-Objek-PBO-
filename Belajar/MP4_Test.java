/*
 * ========================================
 * MP4: TEST MATERI PRAKTIKUM 4
 * Testing Constructor Overloading
 * ========================================
 * Testing:
 * - Constructor 1 (basic)
 * - Constructor 2 (with author)
 * - Constructor 3 (with price)
 * - Constructor 4 (full)
 * - Validasi price
 * ========================================
 */

public class MP4_Test {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   TEST CONSTRUCTOR OVERLOADING (MP4)");
        System.out.println("==============================================\n");
        
        // ===== TEST 1: Constructor Basic (ID + Title) =====
        System.out.println("===== TEST 1: Constructor Basic =====\n");
        MP4_Book book1 = new MP4_Book("B001", "Laskar Pelangi");
        // Author = "Unknown", Price = 0.0 (default)
        book1.displayInfo();
        System.out.println();
        
        
        // ===== TEST 2: Constructor dengan Author =====
        System.out.println("\n===== TEST 2: Constructor + Author =====\n");
        MP4_Book book2 = new MP4_Book("B002", "Bumi Manusia", "Pramoedya Ananta Toer");
        // Price = 0.0 (default)
        book2.displayInfo();
        System.out.println();
        
        
        // ===== TEST 3: Constructor dengan Price (VALID) =====
        System.out.println("\n===== TEST 3: Constructor + Price (Valid) =====\n");
        MP4_Book book3 = new MP4_Book("B003", "Java Programming", "Budi Raharjo", 85000);
        book3.displayInfo();
        System.out.println();
        
        
        // ===== TEST 4: Constructor dengan Price (INVALID - Negatif) =====
        System.out.println("\n===== TEST 4: Constructor + Price (Invalid) =====\n");
        MP4_Book book4 = new MP4_Book("B004", "Bad Price Book", "Author", -50000);
        // Price akan jadi 0.0 (validasi!)
        book4.displayInfo();
        System.out.println();
        
        
        // ===== TEST 5: Constructor Full =====
        System.out.println("\n===== TEST 5: Constructor Full =====\n");
        MP4_Book book5 = new MP4_Book("B005", "OOP Guide", "John Doe", 120000, false);
        // false = not available
        book5.displayInfo();
        System.out.println();
        
        
        // ===== TEST 6: Setter dengan Validasi =====
        System.out.println("\n===== TEST 6: Setter dengan Validasi =====\n");
        
        System.out.println("--- Update price VALID ---");
        book1.setPrice(75000);
        book1.displayInfo();
        
        System.out.println("\n--- Update price INVALID (negatif) ---");
        book1.setPrice(-10000);  // Ditolak!
        book1.displayInfo();
        
        System.out.println("\n--- Update price INVALID (0) ---");
        book1.setPrice(0);  // Ditolak!
        book1.displayInfo();
        
        
        System.out.println("\n==============================================");
        System.out.println("   KESIMPULAN:");
        System.out.println("   ✅ 4 Constructor berbeda (OVERLOADING)!");
        System.out.println("   ✅ Fleksibel - bisa partial atau full data!");
        System.out.println("   ✅ Validasi price mencegah data invalid!");
        System.out.println("==============================================");
    }
}