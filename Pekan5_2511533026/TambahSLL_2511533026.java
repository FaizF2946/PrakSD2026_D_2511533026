package Pekan5_2511533026;

public class TambahSLL_2511533026 {
	public static NodeSLL_2511533026 insertAtFront(NodeSLL_2511533026 head_3026, int value) {
		NodeSLL_2511533026 new_node = new NodeSLL_2511533026 (value);
		new_node.next_3026 = head_3026;
		return new_node;
	}
	// fungsi menambahkan node di akhir SLL
	public static NodeSLL_2511533026 insertAtEnd (NodeSLL_2511533026 head, int value) {
		// buat sebuah node dengan sebuah nilai
		NodeSLL_2511533026 newNode = new NodeSLL_2511533026 (value);
		// jika list kosong maka node jadi head
		if (head == null) {
			return newNode;
		}
		// simpan head ke bariabel sementara
		NodeSLL_2511533026 last = head;
		// telusuri ke node akhir
		while (last.next_3026 !=null) {
			last = last.next_3026;
		}
		// ubah pointer
		last.next_3026 = newNode;
		return head;
	}
	static NodeSLL_2511533026 GetNode(int data_3026) {
		return new NodeSLL_2511533026(data_3026);
	}
	static NodeSLL_2511533026 insertPos (NodeSLL_2511533026 headNode, int position, int value) {
		NodeSLL_2511533026 head = headNode;
		if (position < 1)
			System.out.print("Invalid position");
		if (position == 1) {
			NodeSLL_2511533026 new_node = new NodeSLL_2511533026(value);
			new_node.next_3026 = head;
			return new_node;
		} else {
			while (position-- != 0) {
				NodeSLL_2511533026 newNode = GetNode(value);
				newNode.next_3026 = headNode.next_3026;
				headNode.next_3026 = newNode;
				break;
			}
			headNode = headNode.next_3026;
		}
		if (position !=1)
	System.out.print("Posisi di luar jangkauan");
	return head; }
	public static void printList(NodeSLL_2511533026 head) {
		NodeSLL_2511533026 curr = head;
	while (curr.next_3026 != null) {
		System.out.print(curr.data_3026+"-->");
		curr = curr.next_3026;
	}
	if (curr.next_3026==null) {
		System.out.print(curr.data_3026);
	System.out.println();
	}
	}
	public static void main(String[] args) {
		// buat linked list 2->3->5->6
		NodeSLL_2511533026 head = new NodeSLL_2511533026(2);
		head.next_3026 = new NodeSLL_2511533026(3);
		head.next_3026.next_3026 = new NodeSLL_2511533026(5);
		head.next_3026.next_3026.next_3026 = new NodeSLL_2511533026(6);
		// cetak list asli
		System.out.print("Senarai berantai awal: ");
		printList(head);
		// tambahkan node baru di depan
		System.out.print("tambah 1 simpul di depan: ");
		int data = 1;
		head = insertAtFront(head, data);
		// cetak update list
		printList(head);
		//tambahkan node baru di belakang
		System.out.print("tambah 1 simpul di belakang: ");
		int data2 = 7;
		head = insertAtEnd(head, data2);
		// cetak update list
		printList (head);
		System.out.print("tambah 1 simpul ke data 4: ");
		int data3 = 4;
		int pos = 4;
		head = insertPos(head, pos, data3);
		// cetak updaye list
		printList(head);
	}
}
