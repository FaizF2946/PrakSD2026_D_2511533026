package Pekan6_2511533026;

public class HapusDLL_2511533026 {
	// fungsi menghapus node awal
	public static NodeDLL_2511533026 delHead(NodeDLL_2511533026 head) {
		if (head == null) {
			return null;
		}
		NodeDLL_2511533026 temp = head;
		head = head.next_3026;
		if (head != null) {
			head.prev_3026 = null; }
			return head;}
	// fungsi menghapus di akhir
		public static NodeDLL_2511533026 delLast (NodeDLL_2511533026 head) {
		if (head == null) {
			return null; }
		if (head.next_3026 == null) {
			return null; }
		NodeDLL_2511533026 curr = head;
		while (curr.next_3026 != null) {
			curr = curr.next_3026;
		}
		// update pointer previous node
		if (curr.prev_3026 != null ) {
			curr.prev_3026.next_3026 = null; }
		return head;
		}
			
		public static  NodeDLL_2511533026 delPos (NodeDLL_2511533026 head, int pos) {
			// jika DLL kosong
			if (head == null) {
				return head; }
			NodeDLL_2511533026 curr = head; 
			//telusuri sampai ke node yang akan dihapus
			for (int i = 1; curr != null && i <  pos; ++i) {
				curr = curr.next_3026;
			}
			// jika posisi tidak ditemukan
				if (curr == null) {
					return head; }
			// update pointer
				if (curr.prev_3026 != null) {
					curr.prev_3026.next_3026 = curr.next_3026; }
				if (curr.next_3026 != null) {
					curr.next_3026.prev_3026 = curr.prev_3026; }
			// jika yang dihapus head
				if (head == curr) {
					head = curr.next_3026; }
				return head; } 
				
			//fungsi mencetak DLL
			public static void printList(NodeDLL_2511533026 head) {
				NodeDLL_2511533026 curr = head;
				while (curr != null) {
					System.out.print(curr.data_3026 + " ");
					curr = curr.next_3026;
				}
				System.out.println();
			}
			public static void main(String[] args) {
				// buat sebuah DLL
				NodeDLL_2511533026 head= new NodeDLL_2511533026(1);
				head.next_3026 = new NodeDLL_2511533026(2);
				head.next_3026.prev_3026 = head;
				head.next_3026.next_3026 = new NodeDLL_2511533026(3);
				head.next_3026.next_3026.prev_3026 = head.next_3026;
				head.next_3026.next_3026.next_3026 = new NodeDLL_2511533026(4);
				head.next_3026.next_3026.next_3026.prev_3026 = head.next_3026.next_3026;
				head.next_3026.next_3026.next_3026.next_3026 = new NodeDLL_2511533026(5);
				head.next_3026.next_3026.next_3026.next_3026.prev_3026 = head.next_3026.next_3026.next_3026;
				
				System.out.print("DLL Awal: ");
				printList(head);
				
				System.out.print("Setelah head dihapus: ");
				head = delHead(head);
				printList(head);
				
				System.out.print("Setelah node terakhir dihapus: ");
				head = delLast(head);
				
				System.out.print("menghapus node ke 2: ");
				head = delPos(head, 2);
				
				printList(head);
						
			}
		}
	


