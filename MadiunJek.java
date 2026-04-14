abstract class LayananTransportasi {
    protected String namaDriver;
    protected double jarak;
    protected double saldoUser;

    public LayananTransportasi(String namaDriver, double jarak, double saldoUser) {
        this.namaDriver = namaDriver;
        if (jarak <= 0) {
            this.jarak = 1.0;
        } else {
            this.jarak = jarak;
        }
        this.saldoUser = saldoUser;
    }

    public abstract double hitungTarif();
}

class MadiunMotor extends LayananTransportasi {
    public MadiunMotor(String namaDriver, double jarak, double saldoUser) {
        super(namaDriver, jarak, saldoUser);
    }

    @Override
    public double hitungTarif() {
        return this.jarak * 2500;
    }

    public void prosesTransaksi() {
        System.out.println("=== Transaksi oleh Cristian Reynaldi - 254311017 ===");
        double total = hitungTarif();
        if (saldoUser >= total) {
            System.out.println("Nama Driver : " + namaDriver);
            System.out.println("Jarak       : " + jarak + " km");
            System.out.println("Total Bayar : Rp " + total);
            System.out.println("Sisa Saldo  : Rp " + (saldoUser - total));
        } else {
            System.out.println("Gagal: Saldo tidak mencukupi untuk perjalanan ini!");
        }
        System.out.println();
    }
}

class MadiunMobil extends LayananTransportasi {
    protected double biayaAdmin;
    
    public MadiunMobil(String namaDriver, double jarak, double saldoUser) {
        super(namaDriver, jarak, saldoUser);
        this.biayaAdmin = 3000 + (17 * 100);
    }

    @Override
    public double hitungTarif() {
        return (this.jarak * 5000) + biayaAdmin;
    }

    public void prosesTransaksi() {
        System.out.println("=== Transaksi oleh Cristian Reynaldi - 254311017 ===");
        double total = hitungTarif();
        if (saldoUser >= total) {
            System.out.println("Nama Driver : " + namaDriver);
            System.out.println("Jarak       : " + jarak + " km");
            System.out.println("Total Bayar : Rp " + total);
            System.out.println("Sisa Saldo  : Rp " + (saldoUser - total));
        } else {
            System.out.println("Gagal: Saldo tidak mencukupi untuk perjalanan ini!");
        }
        System.out.println();
    }
}

public class MadiunJek {
    public static void main(String[] args) {
        LayananTransportasi[] daftarLayanan = {
            new MadiunMotor("Andi", 5.0, 20000),
            new MadiunMobil("Budi", 3.5, 25000),
            new MadiunMobil("Caca", 10.0, 10000)
        };
        
        for (LayananTransportasi l : daftarLayanan) {
            if (l instanceof MadiunMotor) {
                ((MadiunMotor) l).prosesTransaksi();
            } else if (l instanceof MadiunMobil) {
                ((MadiunMobil) l).prosesTransaksi();
            }
        }
    }
}