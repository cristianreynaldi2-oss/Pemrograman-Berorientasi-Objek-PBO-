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