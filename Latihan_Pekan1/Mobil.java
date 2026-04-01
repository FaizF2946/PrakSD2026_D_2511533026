package Latihan_Pekan1;

public class Mobil {
    // Atribut
    private String nama;
    private int tahun;
    private int cc;
    private long harga;
    private String merk;

    // Constructor
    public Mobil(String nama, int tahun, int cc, long harga, String merk) {
        this.nama = nama;
        this.tahun = tahun;
        this.cc = cc;
        this.harga = harga;
        this.merk = merk;
    }

    // Method Tambah Mobil (hanya menampilkan info saat ditambahkan)
    public void tambahMobil() {
        System.out.println("Mobil berhasil ditambahkan:");
        tampilkanInfo();
    }

    // Method Hapus Mobil
    public void hapusMobil() {
        System.out.println("Mobil " + nama + " telah dihapus dari daftar.");
    }

    // Selektor (Getter)
    public String getNama() { return nama; }
    public int getTahun() { return tahun; }
    public int getCc() { return cc; }
    public long getHarga() { return harga; }
    public String getMerk() { return merk; }

    // Mutator (Setter)
    public void setNama(String nama) { this.nama = nama; }
    public void setTahun(int tahun) { this.tahun = tahun; }
    public void setCc(int cc) { this.cc = cc; }
    public void setHarga(long harga) { this.harga = harga; }
    public void setMerk(String merk) { this.merk = merk; }

    // Method untuk menampilkan informasi mobil
    public void tampilkanInfo() {
        System.out.println("Nama     : " + nama);
        System.out.println("Merk     : " + merk);
        System.out.println("Tahun    : " + tahun);
        System.out.println("CC       : " + cc + " cc");
        System.out.println("Harga    : Rp " + harga);
        System.out.println("-----------------------------");
    }
}