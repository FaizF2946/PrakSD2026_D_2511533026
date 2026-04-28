package Pekan4_2511533026;

public class QueueArray_2511533026 {
int front, rear, size;
int capacity;
int array[];

public QueueArray_2511533026(int capacity) {
	this.capacity = capacity;
	front = this.size;
	rear = capacity - 1;
	array = new int [this.capacity];
}

boolean isFull(QueueArray_2511533026 queue) {
	return (queue.size == queue.capacity);
}

boolean isEmpty (QueueArray_2511533026 queue) {
	return(queue.size == 0);
}

void enqueue_3026(int item) {
	if (isFull (this))
		return;
	this.rear = (this.rear + 1) % this.capacity;
	this.array[this.rear] = item;
	this.size = this.size + 1;
	System.out.println(item + "enqueued to queue");
}
int dequeue_3026() {
	if(isEmpty(this))
		return Integer.MIN_VALUE;
	int item = this.array[this.front];
	this.size = this.size - 1;
	return item;
}
int front_3026() {
	if (isEmpty(this))
		return Integer.MIN_VALUE;
	
	return this.array[this.front];
}
int rear_3026() {
	if(isEmpty(this))
		return Integer.MIN_VALUE;
	return this.array[this.rear];
}
	//mencetak elemen antrian
void display_3026() {
	int i;
	if (front == rear) {
		System.out.printf("|nAntrian kosong\n");
		return;
	}
}
}
