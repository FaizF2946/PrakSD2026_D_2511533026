package Pekan6_2511533026;

public class InsertDLL_2511533026 {
	// menambahkan node di awal DLL
	static NodeDLL_2511533026 insertBegin (NodeDLL_2511533026 head, int data_3026) {
		// buat node baru
		NodeDLL_2511533026 new_node_3026 = new NodeDLL_2511533026 (data_3026);
		// jadikan pointer nextnya head
		new_node_3026.next_3026 = head;
		// jadikan pointer prev head ke new_node
		if (head != null) {
			head.prev_3026 = new_node_3026;
		}
		return new_node_3026;
	}
	// fungsi menambahkan node di akhir
public static NodeDLL_2511533026 insertEnd(NodeDLL_2511533026 head, int newData) {
	// buat node baru
	NodeDLL_2511533026 newNode_3026 = new NodeDLL_2511533026(newData);
	// jika dll null jadikan head
	if (head == null) {
		head = newNode_3026;
	}
	else {
	NodeDLL_2511533026 curr_3026 = head;
	while (curr_3026.next_3026 != null) {
		curr_3026 = curr_3026.next_3026;
		}
		curr_3026.next_3026 = newNode_3026;
		newNode_3026.prev_3026 = curr_3026;
	}
	return head;	
	
}

// fungsi menambahkan node di posisi tertentu
public static NodeDLL_2511533026 insertAtPosition(NodeDLL_2511533026 head, int pos, int new_data) {
	// buat node baru
	NodeDLL_2511533026 new_node_3026 = new NodeDLL_2511533026 (new_data);
	if (pos == 1) {
		new_node_3026.next_3026 = head;
		if (head != null) {
			head.prev_3026 = new_node_3026; }
		head = new_node_3026;
		return head; }
	NodeDLL_2511533026 curr_3026 = head;
	for (int i = 1; i < pos - 1 && curr_3026 != null; ++i);
	curr_3026 = curr_3026.next_3026;
	if (curr_3026 == null) {
		System.out.println("Posisi tidak ada");
		return head; }
	new_node_3026.prev_3026 = curr_3026;
	new_node_3026.next_3026 = curr_3026.next_3026;
	curr_3026.next_3026 = new_node_3026;
	if (new_node_3026.next_3026 != null) {
		new_node_3026.next_3026.prev_3026 = new_node_3026; }
	return head;
	}
public static void printList(NodeDLL_2511533026 head) {
	NodeDLL_2511533026 curr_3026 = head;
	while (curr_3026 != null) {
		System.out.print(curr_3026.data_3026 + " <-> ");
		curr_3026 = curr_3026.next_3026;
		}
	System.out.println();
	}
public static void main (String[] args) {
	// membuat dll 2 <-> 3 <-> 5
	NodeDLL_2511533026 head_3026 = new NodeDLL_2511533026(2);
	head_3026.next_3026 = new NodeDLL_2511533026(3);
	head_3026.next_3026.prev_3026 = head_3026;
	head_3026.next_3026.next_3026 = new NodeDLL_2511533026(5);
	head_3026.next_3026.next_3026.prev_3026 = head_3026.next_3026;
	//cetak DLL awal
	System.out.print("DLL Awal: ");
	printList(head_3026);
	// tambah 1 di awal
	head_3026 = insertBegin(head_3026, 1);
	System.out.print(
			"simpul 1 ditambah di awal: " );
	printList(head_3026);
	// tambah 6 di akhir
	System.out.print(
			"simpul 6 ditambah di akhir: ");
	int data = 6;
	head_3026 = insertEnd(head_3026, data);
	printList(head_3026);
	// menambah node 4 di posisi 4
	System.out.print("tambah node 4 d posisi 4: ");
	int data2 = 4;
	int pos = 4;
	head_3026 = insertAtPosition(head_3026, pos, data2);
	printList(head_3026);
}
}

