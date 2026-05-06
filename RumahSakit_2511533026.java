package Pekan5_2511533026;

import java.util.Scanner;

public class RumahSakit_2511533026 {
    private Pasien_2511533026 head_3026;
    private int counter_3026 = 1;

    public void daftarkan_3026(String nama, String keluhan) {
        Pasien_2511533026 baru_3026 = new Pasien_2511533026(nama, keluhan, counter_3026++);
        if (head_3026 == null) {
            head_3026 = baru_3026;
        } else {
            Pasien_2511533026 temp = head_3026;
            while (temp.next_3026 != null) {
                temp = temp.next_3026;
            }
            temp.setNext_3026(baru_3026);
        }
        System.out.println("Pasien berhasil didaftarkan! Nomor Antrian: " + (counter_3026 - 1));
    }

    public void panggil_3026() {
        if (head_3026 == null) {
            System.out.println("Antrian Kosong!");
            return;
        }
        System.out.println("Memanggil Pasien: " + head_3026.getNama_3026() + " (Keluhan: " + head_3026.getKeluhan_3026() + ")");
        head_3026 = head_3026.next_3026;
    }

     public void tampilkan_3026() {
        if (head_3026 == null) {
            System.out.println("Tidak ada antrian saat ini.");
            return;
        }
        Pasien_2511533026 temp = head_3026;
        System.out.println("\n========= DAFTAR ANTRIAN RUMAH SAKIT =========");
        System.out.printf("%-5s | %-10s | %-20s | %-15s\n", "Pos", "No. Antri", "Nama Pasien", "Keluhan");
        System.out.println("-----------------------------------------------");
        
        int posisi = 1;
        while (temp != null) {
            System.out.printf("%-5d | %-10d | %-20s | %-15s\n", 
                posisi, 
                temp.getNomor_3026(), 
                temp.getNama_3026(), 
                temp.getKeluhan_3026());
            
            temp = temp.next_3026;
            posisi++;
        }
        System.out.println("===============================================");
    }

     public void cari_3026(String nama) {
        Pasien_2511533026 temp = head_3026;
        boolean ditemukan = false;
        while (temp != null) {
            if (temp.getNama_3026().equalsIgnoreCase(nama)) {
                System.out.println("Pasien ditemukan! No Antrian: " + temp.getNomor_3026() + " dengan keluhan: " + temp.getKeluhan_3026());
                ditemukan = true;
                break;
            }
            temp = temp.next_3026;
        }
        if (!ditemukan) System.out.println("Pasien dengan nama '" + nama + "' tidak ditemukan.");
    }

     public void cekStatus_3026() {
        if (head_3026 == null) {
            System.out.println("List kosong.");
            return;
        }
        int total = 0;
        Pasien_2511533026 temp = head_3026;
        while (temp != null) {
            total++;
            temp = temp.next_3026;
        }
        System.out.println("Total pasien: " + total);
        System.out.println("Pasien terdepan: " + head_3026.getNama_3026());
    }

    public static void main(String[] args) {
        RumahSakit_2511533026 rs_3026 = new RumahSakit_2511533026();
        Scanner input_3026 = new Scanner(System.in);
        int menu_3026;

        do {
            System.out.println("\nAntrian Rumah Sakit NIM: 2511533026");
            System.out.println("1. Daftarkan Pasien");
            System.out.println("2. Panggil Pasien");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Cari Pasien");
            System.out.println("5. Cek Status Antrian");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");
            menu_3026 = input_3026.nextInt();
            input_3026.nextLine();

            switch (menu_3026) {
                case 1:
                    System.out.print("Masukkan Nama Pasien: ");
                    String nama = input_3026.nextLine();
                    System.out.print("Masukkan Keluhan: ");
                    String keluhan = input_3026.nextLine();
                    rs_3026.daftarkan_3026(nama, keluhan);
                    break;
                case 2: rs_3026.panggil_3026(); break;
                case 3: rs_3026.tampilkan_3026(); break;
                case 4:
                    System.out.print("Cari Nama Pasien: ");
                    rs_3026.cari_3026(input_3026.nextLine());
                    break;
                case 5: rs_3026.cekStatus_3026(); break;
            }
        } while (menu_3026 != 6);
        
        input_3026.close(); 
    }
}