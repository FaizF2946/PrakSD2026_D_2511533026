package Latihan_Pekan1;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Program ADT Mobil Sederhana ===\n");

        // Mobil contoh
        Mobil mobil1 = new Mobil("Avanza", 2020, 1300, 150000000, "Toyota");
        mobil1.tambahMobil();

        // Input mobil baru
        System.out.print("Masukkan nama mobil baru: ");
        String nama = input.nextLine();

        System.out.print("Masukkan tahun: ");
        int tahun = input.nextInt();

        System.out.print("Masukkan cc: ");
        int cc = input.nextInt();

        System.out.print("Masukkan harga: ");
        long harga = input.nextLong();
        input.nextLine(); // membersihkan buffer

        System.out.print("Masukkan merk: ");
        String merk = input.nextLine();

        Mobil mobil2 = new Mobil(nama, tahun, cc, harga, merk);
        mobil2.tambahMobil();

        // Contoh ubah harga menggunakan setter
        System.out.println("\nMengubah harga mobil Avanza...");
        mobil1.setHarga(145000000);
        mobil1.tampilkanInfo();

        // Contoh hapus
        mobil2.hapusMobil();

        input.close();
    }
}