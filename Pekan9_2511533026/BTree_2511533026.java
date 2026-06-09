package Pekan9_2511533026;

public class BTree_2511533026 {
	private Node_2511533026 root;
	private Node_2511533026 currentNode;
	public BTree_2511533026() {
		root = null;
	}
	public boolean search(int data) {
		return search(root, data);
	}
	private boolean search(Node_2511533026 node, int data) {
		if (node == null) return false;
		
		if (node.getData() == data)
			return true;
		if (node.getLeft() != null)
            if (search(node.getLeft(), data))
				return true;
		if (node.getRight() != null)
					if (search (node.getRight(), data))
						return true;
			return false;
	}
	public void printInorder() {
		root.printInorder(root);
	}
	public void printPreOrder() {
		root.printPreorder(root);
	}
	public void printPostOrder() {
		root.printPostorder(root);
	}
	
	public Node_2511533026 getRoot() {
		return root;
	}
	public boolean isEmpty() {
		return root == null;
	}
	
	int countNodes(Node_2511533026 node) {
		int count = 1;
		if (node == null) {
			return 0;
		}	else {
			count += countNodes (node.getLeft());
			count += countNodes (node.getRight());
			return count;
		}
	}
	
	public void print() {
		root.print();
	}
	public Node_2511533026 getCurrent() {
		return currentNode;
	}
	
	public void setCurrent(Node_2511533026 node) {
		this.currentNode = node;
	}
	
	public void setRoot(Node_2511533026 root) {
		this.root = root;
	}
}