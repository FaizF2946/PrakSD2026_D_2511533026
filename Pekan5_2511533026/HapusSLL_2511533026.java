package Pekan5_2511533026;

public class HapusSLL_2511533026 {
	//fungsi untuk menghapus head
	public static NodeSLL_2511533026 deleteHead(NodeSLL_2511533026 head) {
		// jika SLL kosong
		if (head == null)
			return null;
		// pindahkan head ke node berikutnya
		head = head.next_3026;
		// return head baru
		return head; }
	//fungsi menghapus node terakhir SLL
	public static NodeSLL_2511533026 removeLastNode(NodeSLL_2511533026 head) {
		// jika list kosong, return null
		if (head == null) {
			return null;
		}
		// jika list satu node, hapus node dan return null
		if (head.next_3026 == null) {
			return null;
		}
		// temukan node terakhir ke dua
		NodeSLL_2511533026 secondLast = head;
		while (secondLast.next_3026.next_3026 != null) {
			secondLast = secondLast.next_3026;
		}
		// hapus node terakhir
		secondLast.next_3026 = null;
		return head; 		}
	// fungsi menghapus node di posisi tertentu
		public static NodeSLL_2511533026 deleteNode(NodeSLL_2511533026 head, int position) {
			NodeSLL_2511533026 temp = head;
			NodeSLL_2511533026 prev = null;
			// jika linked list null
			if (temp == null)
				return head;
			// kasus 1: head dihapus
			if (position == 1) {
				head = temp.next_3026;
				return head;		}
			// kasus 2: menghapus node di tengah
				// telusuri ke node yang dihapus
			for (int i = 1; temp !=null && i < position; i++) {
				prev = temp;
				temp = temp.next_3026; }
			// jika ditemukan, hapus node
			if (temp != null) {
				prev.next_3026 = temp.next_3026;
			} else {
				System.out.println("Data tidak ada");		}
			return head;		}
		
			// fungsi mencetak SLL
			public static void printList(NodeSLL_2511533026 head) {
				NodeSLL_2511533026 curr = head;
				while (curr.next_3026 != null) {
					System.out.print(curr.data_3026+"-->"); 
					curr = curr.next_3026;		}
				if (curr.next_3026==null) {
						System.out.print(curr.data_3026);	}
				System.out.println(); }
	// kelas main
				public static void main(String[] args) {
					// buat S:: 1 -> 2 -> 3 -> 4 -> 6 -> null
					NodeSLL_2511533026 head = new NodeSLL_2511533026(1);
					head.next_3026 = new NodeSLL_2511533026(2);
					head.next_3026.next_3026 = new NodeSLL_2511533026(3);
					head.next_3026.next_3026.next_3026 = new NodeSLL_2511533026(4);
					head.next_3026.next_3026.next_3026.next_3026 = new NodeSLL_2511533026(5);
					head.next_3026.next_3026.next_3026.next_3026.next_3026 = new NodeSLL_2511533026(6);
					// cetak list awal
					System.out.println("list awal: ");
					printList(head);
					// hapus head
					head = deleteHead(head);
					System.out.println("List setelah head dihapus: ");
					printList(head);
					//hapus node terakhir
					head = removeLastNode(head);
					System.out.println("List setelah simpul terakhir di hapus: ");
					printList(head);
					// Deleting node at position 2
					int position = 2;
					head = deleteNode(head, position);
					// Print list after deletion
					System.out.println("List setelah posisi 2 dihapus: ");
					printList(head);
				}
}
