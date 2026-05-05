package Pekan5_2511533026;

public class PencarianSLL_2511533026 {
	static boolean searchKey (NodeSLL_2511533026 head, int key) {
		NodeSLL_2511533026 curr = head;
		while (curr != null) {
			if (curr.data_3026 == key)
				return true;
			curr = curr.next_3026; }
		return false; }
	public static void traversal(NodeSLL_2511533026 head) {
		//mulai dari head
		NodeSLL_2511533026 curr = head;
		// terlusuri sampai pointer null
		while (curr != null) {
			System.out.print(" " + curr.data_3026);
			curr = curr.next_3026;}
			System.out.println(); }
		public static void main (String[] args) {
			NodeSLL_2511533026 head = new NodeSLL_2511533026(14);
			head.next_3026 = new NodeSLL_2511533026(21);
			head.next_3026.next_3026 = new NodeSLL_2511533026(13);
			head.next_3026.next_3026.next_3026 = new NodeSLL_2511533026(30);
			head.next_3026.next_3026.next_3026.next_3026 = new NodeSLL_2511533026(10);
			System.out.print("Penelusuran SLL : ");
			traversal(head);
			// data yang akan dicari
			int key = 30;
			System.out.print("cari data" +key+ " = ");
			if (searchKey(head, key))
				System.out.println("Ketemu");
			else System.out.println("tidak ada");
	} }
