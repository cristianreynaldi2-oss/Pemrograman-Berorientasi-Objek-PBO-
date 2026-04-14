/*
 * ========================================
 * M5: MATERI TEORI 5
 * Encapsulation - Digital Wallet Security
 * ========================================
 * Topik:
 * - Private balance (encapsulation)
 * - Constructor dengan validasi
 * - deposit() & withdraw() dengan logic
 * - Security implementation
 * 
 * CASE STUDY: Secure Digital Wallet
 * Problem: User bisa ubah balance langsung (curang!)
 * Solution: Balance PRIVATE + method dengan validasi
 * ========================================
 */

public class M5_SecureWallet {
    // PRIVATE - Gak bisa diubah langsung dari luar! (SECURITY!)
    private double balance;
    private String ownerName;
    
    // Constructor
    public M5_SecureWallet(String ownerName, double initialBalance) {
        this.ownerName = ownerName;
        
        // Validasi initial balance
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Error: Initial balance tidak boleh negatif!");
            this.balance = 0.0;
        }
    }
    
    // Constructor overload (tanpa initial balance)
    public M5_SecureWallet(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0.0;  // Start dari 0
    }
    
    
    // ===== METHOD DENGAN VALIDASI =====
    
    // Deposit (Menabung) - dengan VALIDASI
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposit berhasil: Rp " + amount);
            System.out.println("   Saldo baru: Rp " + balance);
        } else {
            System.out.println("❌ Error: Amount deposit harus > 0!");
        }
    }
    
    // Withdraw (Tarik) - dengan VALIDASI
    public void withdraw(double amount) {
        // Validasi 1: Amount harus positif
        if (amount <= 0) {
            System.out.println("❌ Error: Amount withdraw harus > 0!");
            return;
        }
        
        // Validasi 2: Saldo harus cukup
        if (amount > balance) {
            System.out.println("❌ Error: Saldo tidak cukup!");
            System.out.println("   Saldo saat ini: Rp " + balance);
            System.out.println("   Yang diminta: Rp " + amount);
            return;
        }
        
        // Jika validasi lolos
        balance -= amount;
        System.out.println("✅ Withdraw berhasil: Rp " + amount);
        System.out.println("   Saldo baru: Rp " + balance);
    }
    
    // Transfer ke wallet lain
    public void transfer(M5_SecureWallet targetWallet, double amount) {
        if (amount <= 0) {
            System.out.println("❌ Error: Amount transfer harus > 0!");
            return;
        }
        
        if (amount > balance) {
            System.out.println("❌ Error: Saldo tidak cukup untuk transfer!");
            return;
        }
        
        // Proses transfer
        this.balance -= amount;
        targetWallet.balance += amount;
        System.out.println("✅ Transfer berhasil: Rp " + amount);
        System.out.println("   Ke: " + targetWallet.ownerName);
        System.out.println("   Saldo kamu: Rp " + this.balance);
    }
    
    
    // ===== GETTER (Lihat Data) =====
    
    public double getBalance() {
        return balance;
    }
    
    public String getOwnerName() {
        return ownerName;
    }
    
    
    // ===== DISPLAY INFO =====
    
    public void displayInfo() {
        System.out.println("===== WALLET INFO =====");
        System.out.println("Owner: " + ownerName);
        System.out.println("Balance: Rp " + balance);
        System.out.println("=======================");
    }
}