package pekan2_2511533026;

public class DaftarKataDriver_2511533026 {

	public static void main(String[] args) {
		DaftarKata_2511533026 al = new DaftarKata_2511533026();
		
		// Menambah elemen (akhir)
		al.tambah("Kami");
		al.tambah("Informatika");
		
		// Menyisipkan elemen pada indeks 1
		al.tambahPada(1, "Mahasiswa");
		
		// Cetak isi awal
		System.out.println("Awal : " + al);
		
		// Mengubah elemen (index 1)
		al.ubahElemen(1, "Departemen");
		System.out.println("Setelah Ubah: " + al);
		
		// Menghapus elemen (hapus index 0)
		String terhapus = al.hapusElemen(0);
		System.out.println("Terhapus : " + terhapus);
		System.out.println("Setelah Hapus: " + al);
		
		//Iterasi pada ArrayList (cetak setiap elemen)
		System.out.print("Iterasi: ");
		al.iterasiCetak();
		System.out.println();
		
	}
}
