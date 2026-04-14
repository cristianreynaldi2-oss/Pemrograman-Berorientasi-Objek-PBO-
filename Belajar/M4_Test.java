/*
 * ========================================
 * M4: TEST MATERI TEORI 4
 * Testing Encapsulation & Validation
 * ========================================
 * Testing:
 * - Valid inputs
 * - Invalid inputs (validasi jalan)
 * - Getter & Setter
 * ========================================
 */

public class M4_Test {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   TEST ENCAPSULATION & VALIDATION (M4)");
        System.out.println("==============================================\n");
        
        // ===== TEST 1: Valid Data =====
        System.out.println("===== TEST 1: Valid Data =====\n");
        M4_Student student1 = new M4_Student("Cristian", 20, "cristian@email.com", 3.75);
        student1.displayInfo();
        System.out.println();
        
        
        // ===== TEST 2: Invalid Username (terlalu pendek) =====
        System.out.println("\n===== TEST 2: Invalid Username =====\n");
        M4_Student student2 = new M4_Student("AB", 21, "test@email.com", 3.5);
        // Username akan jadi "guest" (default)
        student2.displayInfo();
        System.out.println();
        
        
        // ===== TEST 3: Invalid Age (negatif) =====
        System.out.println("\n===== TEST 3: Invalid Age =====\n");
        M4_Student student3 = new M4_Student("Budi", -5, "budi@email.com", 3.2);
        // Age akan jadi 0 (default)
        student3.displayInfo();
        System.out.println();
        
        
        // ===== TEST 4: Invalid Email (tanpa @) =====
        System.out.println("\n===== TEST 4: Invalid Email =====\n");
        M4_Student student4 = new M4_Student("Anisa", 22, "emailsalah.com", 3.8);
        // Email akan jadi "unknown@example.com" (default)
        student4.displayInfo();
        System.out.println();
        
        
        // ===== TEST 5: Invalid GPA (> 4.0) =====
        System.out.println("\n===== TEST 5: Invalid GPA =====\n");
        M4_Student student5 = new M4_Student("Siti", 19, "siti@email.com", 5.0);
        // GPA akan jadi 0.0 (default)
        student5.displayInfo();
        System.out.println();
        
        
        // ===== TEST 6: Setter (Ubah Data Setelah Dibuat) =====
        System.out.println("\n===== TEST 6: Using Setter =====\n");
        System.out.println("--- Before Update ---");
        student1.displayInfo();
        
        System.out.println("\n--- Updating with VALID data ---");
        student1.setUsername("CristianUpdated");
        student1.setAge(21);
        student1.setGpa(3.85);
        
        System.out.println("\n--- After Update ---");
        student1.displayInfo();
        
        System.out.println("\n--- Updating with INVALID data ---");
        student1.setUsername("AB");  // Terlalu pendek - ditolak!
        student1.setAge(200);         // Terlalu besar - ditolak!
        student1.setGpa(6.0);         // > 4.0 - ditolak!
        
        System.out.println("\n--- After Invalid Update (data tetap) ---");
        student1.displayInfo();
        
        
        System.out.println("\n==============================================");
        System.out.println("   KESIMPULAN:");
        System.out.println("   ✅ Encapsulation melindungi data!");
        System.out.println("   ✅ Validasi mencegah data invalid!");
        System.out.println("   ✅ Setter mengontrol perubahan data!");
        System.out.println("==============================================");
    }
}