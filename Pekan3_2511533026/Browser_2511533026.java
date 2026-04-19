package Pekan3_2511533026;
import java.util.Scanner;
import java.util.Stack;

public class Browser_2511533026 {
	public static void main(String[] args) {
        Stack<Website_2511533026> history = new Stack<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Browser History NIM: 2511533026 ===");

        while (true) {
            System.out.println("\n1. Kunjungi Website (Push)");
            System.out.println("2. Tombol Back (Pop)");
            System.out.println("3. Lihat Halaman Saat Ini (Peek)");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");

            String pilihanStr = sc.nextLine().trim();
            int pilihan = Integer.parseInt(pilihanStr);

            switch (pilihan) {
                case 1: // Kunjungi Website (Push)
                    System.out.print("Masukkan Judul: ");
                    String judul = sc.nextLine().trim();
                    System.out.print("Masukkan URL: ");
                    String url = sc.nextLine().trim();

                    Website_2511533026 websiteBaru = new Website_2511533026(judul, url);
                    history.push(websiteBaru);
                    System.out.println("Berhasil mengunjungi halaman!");
                    break;

                case 2: // Tombol Back (Pop)
                    if (history.isEmpty()) {
                        System.out.println("History kosong! Tidak ada halaman yang bisa di-back.");
                    } else {
                        Website_2511533026 dihapus = history.pop();
                        System.out.println("Halaman \"" + dihapus.getJudul_3026() + "\" berhasil di-back!");
                    }
                    break;

                case 3: // Lihat Halaman Saat Ini (Peek) 
                    if (history.isEmpty()) {
                        System.out.println("Tidak ada halaman yang sedang aktif.");
                    } else {
                        Website_2511533026 aktif = history.peek();
                        System.out.println("\nHalaman Saat Ini:");
                        System.out.println("Judul : " + aktif.getJudul_3026());
                        System.out.println("URL   : " + aktif.getUrl_3026());
                    }
                    // Cek Status History
                    System.out.println("\nCek Status History:");
                    System.out.println("Total riwayat = " + history.size());
                    System.out.println("Stack kosong? = " + history.isEmpty());
                    break;

                case 4: // Keluar
                    System.out.println("Terima kasih telah menggunakan Simulasi Browser History!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-4.");
            }
        }
    }
}
