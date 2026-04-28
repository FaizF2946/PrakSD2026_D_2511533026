package Pekan4_2511533026;

public class QueueArrayDriver_2511533026 {
	public static void main (String[] args) {
QueueArray_2511533026 queue = new QueueArray_2511533026(1000);
queue.enqueue_3026(10);
queue.enqueue_3026(20);
queue.enqueue_3026(30);
queue.enqueue_3026(40);
System.out.println("Item di depan "+ queue.front_3026());
System.out.println("item paling belakang " + queue.rear_3026());
System.out.println("tampilan queue");
queue.display_3026();
System.out.println();
System.out.println(queue.dequeue_3026() + " dihapus dari queue");
System.out.println("item di depan:" + queue.front_3026());
System.out.println("tampilan queue setelah satu data dihapus");
queue.display_3026();
	}
}
