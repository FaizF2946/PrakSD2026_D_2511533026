package Pekan9_2511533026;

public class Node_2511533026 {
    int data;
    Node_2511533026 left;
    Node_2511533026 right;

    public Node_2511533026(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void setLeft(Node_2511533026 node) {
        if (left == null)
            left = node;
    }

    public void setRight(Node_2511533026 node) {
        if (right == null)
            right = node;
    }

    public Node_2511533026 getLeft() {
        return left;
    }

    public Node_2511533026 getRight() {
        return right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    // Traversal Methods
    void printPreorder(Node_2511533026 node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printPostorder(Node_2511533026 node) {
        if (node == null) return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    void printInorder(Node_2511533026 node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

   
    public void print() {
        System.out.println("Dmenampulkan simpul dalam bentuk pohon");
        printTree(this, "", true);
    }

    private void printTree(Node_2511533026 node, String prefix, boolean isLeft) {
        if (node == null) return;

        System.out.println(prefix + (isLeft ? "| /-- " : "\\-- ") + node.data);

        String newPrefix = prefix + (isLeft ? "|   " : "    ");

        if (node.right != null) {
            printTree(node.right, newPrefix, false);
        }
        // Cetak kiri
        if (node.left != null) {
            printTree(node.left, newPrefix, true);
        }
    }
}