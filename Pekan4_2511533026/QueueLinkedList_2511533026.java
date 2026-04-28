package Pekan4_2511533026;
import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkedList_2511533026 {
	public static void main (String[] args) {
	Queue<Integer> q_3026 = new LinkedList<>();
	//tambah elemen (0, 1, 2, 3, 4, 5) ke antrian
	
	for (int i= 0; i < 6; i++)
		q_3026.add(i);
	//Menampilkan isi antrian.
	System.out.println("Elemen Antrian "+ q_3026);
	//Untuk menghapus kepala antrian.
	int hapus = q_3026.remove();
	System.out.println("Hapus elemen + " + hapus);
	System.out.println(q_3026);
	//Untuk melihat antrian terdepan
	int depan = q_3026.peek();
	System.out.println("Kepala Antrian = " + depan);
	
	int banyak = q_3026.size();
	System.out.println("Size Antrian = " + banyak);
}
}