package Pekan6_2511533026;

import java.util.Scanner;
public class Musik_2511533026 {
	private Lagu_2511533026 head_3026;
    private Lagu_2511533026 tail_3026; 
    
    public void tambahLagu_3026(String judul, String penyanyi) {
        Lagu_2511533026 baru_3026 = new Lagu_2511533026(judul, penyanyi);
        if (head_3026 == null) {
            head_3026 = tail_3026 = baru_3026;
        } else {
                tail_3026.next_3026 = baru_3026;
            baru_3026.prev_3026 = tail_3026;
            tail_3026 = baru_3026;
        }
        System.out.println("Lagu berhasil ditambahkan!");
    }

        public void hapusLaguAwal_3026() {
        if (head_3026 == null) {
            System.out.println("Playlist kosong, tidak ada yang bisa dihapus.");
            return;
        }
        System.out.println("Menghapus lagu: " + head_3026.getJudul_3026());
        if (head_3026 == tail_3026) {
            head_3026 = tail_3026 = null;
        } else {
            head_3026 = head_3026.next_3026;
            head_3026.prev_3026 = null;
        }
    }

    public void tampilMaju_3026() {
        if (head_3026 == null) {
            System.out.println("Playlist kosong.");
            return;
        }
        Lagu_2511533026 temp = head_3026;
        System.out.println("\n--- Playlist (Maju) ---");
        while (temp != null) {
            System.out.println(temp.getJudul_3026() + " - " + temp.getPenyanyi_3026());
            temp = temp.next_3026;
        }
    }

    public void tampilMundur_3026() {
        if (tail_3026 == null) {
            System.out.println("Playlist kosong.");
            return;
        }
        Lagu_2511533026 temp = tail_3026;
        System.out.println("\n--- Playlist (Mundur) ---");
        while (temp != null) {
            System.out.println(temp.getJudul_3026() + " - " + temp.getPenyanyi_3026());
            temp = temp.prev_3026; 
        }
    }

    public void cariLagu_3026(String judul) {
        Lagu_2511533026 temp = head_3026;
        boolean ketemu = false;
        while (temp != null) {
            if (temp.getJudul_3026().equalsIgnoreCase(judul)) {
                System.out.println("Lagu Ditemukan: " + temp.getJudul_3026() + " oleh " + temp.getPenyanyi_3026());
                ketemu = true;
                break;
            }
            temp = temp.next_3026;
        }
        if (!ketemu) System.out.println("Lagu '" + judul + "' tidak ada dalam playlist.");
    }

    public static void main(String[] args) {
        Musik_2511533026 playlist_3026 = new Musik_2511533026();
        Scanner sc_3026 = new Scanner(System.in);
        int pilih_3026;

        do {
            System.out.println("\nPlaylist Musik NIM: 2511533026");
            System.out.println("1. Tambah Lagu\n2. Hapus Lagu Pertama\n3. Lihat Maju\n4. Lihat Mundur\n5. Cari Lagu\n6. Keluar");
            System.out.print("Pilihan: ");
            pilih_3026 = sc_3026.nextInt();
            sc_3026.nextLine(); 

            switch (pilih_3026) {
                case 1:
                    System.out.print("Judul: "); String j = sc_3026.nextLine();
                    System.out.print("Penyanyi: "); String p = sc_3026.nextLine();
                    playlist_3026.tambahLagu_3026(j, p);
                    break;
                case 2: playlist_3026.hapusLaguAwal_3026(); break;
                case 3: playlist_3026.tampilMaju_3026(); break;
                case 4: playlist_3026.tampilMundur_3026(); break;
                case 5:
                    System.out.print("Masukkan judul lagu: ");
                    playlist_3026.cariLagu_3026(sc_3026.nextLine());
                    break;
            }
        } while (pilih_3026 != 6);
    }
}