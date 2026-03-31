package pekan1_2511533026;
import java.util.Scanner;

public class JamDriver2_2511533026 {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("=== Program Driver Objem Jam ===");
		// 1. Input Jam Pertama
		System.out.println("\n--- Input Jam 1");
		jam_2511533026 j1 = buatJamDariInput(input);
		
		// 2. Input Jam Kedua
		System.out.println("\n--- Input Jam 2 ---");
		jam_2511533026 j2 = buatJamDariInput(input);
		
		// 3. Menampilkan Data
		System.out.println("\n--- Hasil Operasi ---");
		System.out.println("Jam 1 (String) : " + j1.toString());		
		System.out.println("Jam 2 (String) : " + j2.toString());
		System.out.println("Jam 1 dalam detik : " + j1.toSeconds());
		System.out.println("Jam 2 dalam detik : " + j2.toSeconds());
		
		
		// 4. Operasi Relasional (Perbandingan)
		int perbandingan = j1.compareTo(j2);
		if (perbandingan > 0) {
			System.out.println("status  : Jam 1 lebih lambat (setelah) Jam 2");
		} else if (perbandingan < 0) {
			System.out.println("Status  : Jam 1 lebih awal (sebelum Jam 2");
		} else {
			System.out.println("Status  : Jam 1 dan Jam 2 sama persis");
		}
		
		// 5. Operasi Aritmatika
		System.out.println("Durasi (J1 ke J2)  : " + jam_2511533026.durasiDetik(j1, j2) + "detik");
		
		jam_2511533026 jNext = j1.nextSecond();
		System.out.println("Jam 1 Detik Berikutnya: " + jNext);
		
		jam_2511533026 jPrev = j1.prevSecond();
		System.out.println("Jam 1 Detik Sebelumnya: " + jPrev);
		
		// 6. Operasi Penjumlahan Jam
		jam_2511533026 jHasilPlus = j1.plus(j2);
		System.out.println("Hasil J1 + J2  : " + jHasilPlus);
		
		input.close();
		System.out.println("\nProgram Selesai.");
		
	}


/**
 * Prosedur pembantu untuk melakukan input dan validasi secara berulang
 * sampai user emasukkan angka yang benar (0..23, 0..59).
 */
private static jam_2511533026 buatJamDariInput(Scanner sc) {
	int h, m, s;
	while (true) {
		System.out.print("Masukkan Jam (0-23)");
		h = sc.nextInt();
		System.out.print("Masukkan Menit (0-59) : ");
		m = sc.nextInt();
		System.out.print("Masukkan Detik (0-59) : ");
		s = sc.nextInt();
		
		// Memanggil method static isValid dari kelas Jam
		if(jam_2511533026.isValid(h,  m, s)) {
			return new jam_2511533026(h, m, s);
		}else {
			System.out.println("[Error] Input tidak valid! Silakan ulangi.\n");
		}
		}
	}
}