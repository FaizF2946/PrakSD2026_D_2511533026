package Pekan6_2511533026;

public class PenelusuranDLL_2511533026 {
	//fungsi penelusuran maju
	static void forwardTraversal (NodeDLL_2511533026 head) {
		// memulai penelusuran dari head
		NodeDLL_2511533026 curr_3026 = head;
		// lanjutkan sampai akhir
		while (curr_3026 != null) {
			//print data
			System.out.print(curr_3026.data_3026 + " <-> ");
			// pindah ke node berikutnya
			curr_3026 = curr_3026.next_3026;
		}
		// print spasi
		System.out.println();
	}
	// fungsi penelusuran mundur
	static void backwardTraversal(NodeDLL_2511533026 tail) {
		// mulai dari akhir
		NodeDLL_2511533026 curr_3026 = tail;
		// lanjut sampai head
		while (curr_3026 != null) {
			// cetak data
			System.out.print(curr_3026.data_3026 + " <-> ");
			// pindah ke node sebelumnya
			curr_3026 = curr_3026.prev_3026;
		}
		// cetak spasi
		System.out.println();
	}
	public static void main(String[] args ) {
		// cetak DLL
		NodeDLL_2511533026 head_3026 = new NodeDLL_2511533026(1);
		NodeDLL_2511533026 second_3026 = new NodeDLL_2511533026(2);
		NodeDLL_2511533026 third_3026 = new NodeDLL_2511533026(3);
		
		head_3026.next_3026 = second_3026;
		second_3026.prev_3026 = head_3026;
		second_3026.next_3026 = third_3026;
		third_3026.prev_3026 = second_3026;
		
		System.out.println("Penelusuran maju:");
		forwardTraversal(head_3026);
		
		System.out.println("Penelusuran mundur: ");
		backwardTraversal(third_3026);
	}
}
