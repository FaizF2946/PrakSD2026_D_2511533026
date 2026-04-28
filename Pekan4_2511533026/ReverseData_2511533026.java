package Pekan4_2511533026;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class ReverseData_2511533026 {

	public static void main (String[] args) {
		Queue<Integer>q = new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3); //[1, 2, 3]
		System.out.println("sebelum reverse" + q);
		Stack<Integer> s = new Stack<Integer>();
	while (!q.isEmpty()) { // Q -> S
	}
	while (!s.isEmpty()) { // S -> Q
		q.add(s.pop());
	}
	System.out.println("sesudah reverse= " + q) ; // [3, 2, 1]
}
}
