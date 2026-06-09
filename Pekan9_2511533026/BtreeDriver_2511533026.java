package Pekan9_2511533026;

public class BtreeDriver_2511533026 {
	public static void main (String[] args) {
		// Membuat Pohon
		BTree_2511533026 tree = new BTree_2511533026();
		System.out.print("Jumlah Simpul awal pohon: ");
		System.out.println(tree.countNodes(null));
		
		//Menambahkan simpul data 1
		Node_2511533026 root = new Node_2511533026 (1);
		// Menjadikan simpul 1 sebagai root
		tree.setRoot (root);
		System.out.println("Jumlah simpul jika hanya ada root");
		System.out.println(tree.countNodes(null));
		Node_2511533026 node2 = new Node_2511533026 (2);
		Node_2511533026 node3 = new Node_2511533026 (3);
		Node_2511533026 node4 = new Node_2511533026 (4);
		Node_2511533026 node5 = new Node_2511533026 (5);
		Node_2511533026 node6 = new Node_2511533026 (6);
		Node_2511533026 node7 = new Node_2511533026 (7);
		Node_2511533026 node8 = new Node_2511533026 (8);
		Node_2511533026 node9 = new Node_2511533026 (9);
		root.setLeft(node2);
		node2.setLeft(node4);
		node2.setRight(node5);
		node4.setRight(node8);
		root.setRight(node3);
		node3.setLeft(node6);
		node3.setRight(node7);
		node6.setLeft(node9);
		
		//Set root
		tree.setCurrent(tree.getRoot());
		System.out.println("menampilkan simpul terakhir: ");
		System.out.println(tree.getCurrent().getData());
		System.out.println("Jumlah simpul; setelah simpul 7 ditambahkan");
		System.out.println(tree.countNodes(null));
		System.out.println("InOrder: ");
		tree.printInorder();
		System.out.println("\nPreorder: ");
		tree.printPreOrder();
		System.out.println("\nPostorder: ");
		tree.printPostOrder();
		System.out.println("\nMenampilkan simpul dalam bentuk pohon");
		tree.print();
	}
}
