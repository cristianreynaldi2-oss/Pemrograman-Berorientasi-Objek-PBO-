/*
 * ========================================
 * M5: TEST MATERI TEORI 5
 * Testing Digital Wallet Security + Peer Review
 * ========================================
 * Testing:
 * - Valid deposits & withdrawals
 * - Invalid inputs (PEER REVIEW: coba break!)
 * - Transfer antar wallet
 * - Security validation
 * ========================================
 */

public class M5_Test {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   TEST SECURE WALLET (M5)");
        System.out.println("==============================================\n");
        
        // ===== CREATE WALLETS =====
        System.out.println("===== CREATE WALLETS =====\n");
        M5_SecureWallet wallet1 = new M5_SecureWallet("Cristian", 100000);
        M5_SecureWallet wallet2 = new M5_SecureWallet("Budi", 50000);
        M5_SecureWallet wallet3 = new M5_SecureWallet("Anisa");  // Start dari 0
        
        wallet1.displayInfo();
        System.out.println();
        wallet2.displayInfo();
        System.out.println();
        wallet3.displayInfo();
        System.out.println();
        
        
        // ===== TEST VALID OPERATIONS =====
        System.out.println("\n===== TEST VALID OPERATIONS =====\n");
        
        System.out.println("--- Deposit VALID (wallet1) ---");
        wallet1.deposit(50000);
        System.out.println();
        
        System.out.println("--- Withdraw VALID (wallet1) ---");
        wallet1.withdraw(30000);
        System.out.println();
        
        
        // ===== PEER REVIEW: COBA BREAK CODE! =====
        System.out.println("\n========================================");
        System.out.println("   PEER REVIEW: COBA BREAK CODE!");
        System.out.println("========================================\n");
        
        System.out.println("--- Attack 1: Deposit NEGATIF (curang!) ---");
        wallet1.deposit(-1000000);  // Coba deposit negatif!
        System.out.println();
        
        System.out.println("--- Attack 2: Deposit 0 ---");
        wallet1.deposit(0);  // Deposit 0
        System.out.println();
        
        System.out.println("--- Attack 3: Withdraw LEBIH dari saldo ---");
        wallet1.withdraw(1000000000);  // Withdraw lebih dari saldo!
        System.out.println();
        
        System.out.println("--- Attack 4: Withdraw NEGATIF ---");
        wallet1.withdraw(-50000);  // Withdraw negatif
        System.out.println();
        
        System.out.println("--- Attack 5: Coba akses balance langsung ---");
        // wallet1.balance = 999999999;  // ❌ COMPILE ERROR! balance itu PRIVATE!
        System.out.println("❌ Gagal! balance itu PRIVATE - gak bisa diakses langsung!");
        System.out.println("✅ Encapsulation melindungi data!");
        System.out.println();
        
        
        // ===== TEST TRANSFER =====
        System.out.println("\n===== TEST TRANSFER =====\n");
        
        System.out.println("--- Transfer VALID (wallet1 → wallet2) ---");
        System.out.println("Sebelum transfer:");
        wallet1.displayInfo();
        wallet2.displayInfo();
        System.out.println();
        
        wallet1.transfer(wallet2, 20000);
        System.out.println("\nSetelah transfer:");
        wallet1.displayInfo();
        wallet2.displayInfo();
        System.out.println();
        
        System.out.println("\n--- Transfer INVALID (saldo tidak cukup) ---");
        wallet3.transfer(wallet1, 50000);  // wallet3 cuma punya 0!
        System.out.println();
        
        
        // ===== FINAL STATUS =====
        System.out.println("\n===== FINAL STATUS =====\n");
        wallet1.displayInfo();
        System.out.println();
        wallet2.displayInfo();
        System.out.println();
        wallet3.displayInfo();
        
        
        // ===== KESIMPULAN =====
        System.out.println("\n==============================================");
        System.out.println("   KESIMPULAN:");
        System.out.println("==============================================");
        System.out.println("✅ ENCAPSULATION melindungi balance!");
        System.out.println("✅ Validasi mencegah deposit/withdraw invalid!");
        System.out.println("✅ Gak bisa curang ubah balance langsung!");
        System.out.println("✅ Semua operasi harus lewat method (kontrol!)");
        System.out.println("==============================================");
        
        
        // ===== COMPARISON: UNSECURE vs SECURE =====
        System.out.println("\n========================================");
        System.out.println("   COMPARISON: UNSECURE vs SECURE");
        System.out.println("========================================\n");
        
        System.out.println("❌ UNSECURE Wallet (public balance):");
        System.out.println("   wallet.balance = 999999;  // Bisa curang!");
        System.out.println("   wallet.balance = -50;     // Bisa negatif!");
        System.out.println();
        
        System.out.println("✅ SECURE Wallet (private balance):");
        System.out.println("   wallet.deposit(1000);    // Ada validasi!");
        System.out.println("   wallet.withdraw(500);    // Cek saldo dulu!");
        System.out.println("   wallet.balance = 999;    // ❌ ERROR! Private!");
        System.out.println();
        
        System.out.println("========================================");
    }
}