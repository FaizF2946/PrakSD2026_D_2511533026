package Pekan2_2511533026;
import java.util.ArrayList;
import java.util.Scanner;

public class Playlist_2511533026 {
	    public static void main(String[] args) {
	        ArrayList<Musik_2511533026 > playlist = new ArrayList<>();
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("=== Playlist Musik ===");
	            System.out.println("1. Tambah Lagu");
	            System.out.println("2. Lihat Playlist");
	            System.out.println("3. Hapus Lagu");
	            System.out.println("4. Keluar");
	            System.out.print("Pilihan: ");
	            int pilihan = sc.nextInt();
	            sc.nextLine(); // membersihkan buffer

	            switch (pilihan) {
	                case 1: // Tambah Lagu
	                    System.out.print("Masukkan Judul: ");
	                    String judul = sc.nextLine();
	                    System.out.print("Masukkan Penyanyi: ");
	                    String penyanyi = sc.nextLine();
	                    System.out.print("Masukkan Durasi (menit): ");
	                    int durasi = sc.nextInt();
	                    sc.nextLine();

	                    Musik_2511533026 laguBaru = new Musik_2511533026(judul, penyanyi, durasi);
	                    playlist.add(laguBaru);
	                    System.out.println("Data berhasil ditambahkan!");
	                    System.out.println();
	                    break;

	                case 2: // Lihat Playlist + Cek Kapasitas
	                    if (playlist.isEmpty()) {
	                        System.out.println("Playlist kosong!");
	                    } else {
	                        System.out.println("\nDaftar Lagu:");
	                        for (int i = 0; i < playlist.size(); i++) {
	                            Musik_2511533026 m = playlist.get(i);
	                            System.out.println((i + 1) + ". Judul: " + m.getJudul_3026() +
	                                    " | Penyanyi: " + m.getPenyanyi_3026() +
	                                    " | Durasi: " + m.getDurasi_3026() + " menit");
	                        }
	                        // Cek Kapasitas menggunakan .size()
	                        System.out.println("\nCek Kapasitas: Total lagu dalam playlist = " + playlist.size());
	                    }
	                    System.out.println();
	                    break;

	                case 3: // Hapus Lagu berdasarkan nomor indeks
	                    if (playlist.isEmpty()) {
	                        System.out.println("Playlist kosong! Tidak ada lagu yang dapat dihapus.");
	                    } else {
	                        System.out.println("\nDaftar Lagu Saat Ini:");
	                        for (int i = 0; i < playlist.size(); i++) {
	                            Musik_2511533026 m = playlist.get(i);
	                            System.out.println((i + 1) + ". " + m.getJudul_3026() +
	                                    " - " + m.getPenyanyi_3026 () +
	                                    " (" + m.getDurasi_3026() + " detik)");
	                        }
	                        System.out.print("\nMasukkan nomor indeks lagu yang ingin dihapus: ");
	                        int indeks = sc.nextInt();
	                        sc.nextLine();

	                        if (indeks >= 1 && indeks <= playlist.size()) {
	                            playlist.remove(indeks - 1);
	                            System.out.println("Lagu berhasil dihapus!");
	                        } else {
	                            System.out.println("Indeks tidak valid!");
	                        }
	                    }
	                    System.out.println();
	                    break;

	                case 4: // Keluar
	                    System.out.println("Terima kasih telah menggunakan Program Playlist Musik!");
	                    sc.close();
	                    System.exit(0);
	                    break;

	                default:
	                    System.out.println("Pilihan tidak valid! Silakan pilih 1-4.");
	                    System.out.println();
	            }
	        }
	    }
	}

