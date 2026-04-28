package Pekan4_2511533026;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class ReverseData_2511533026 {

	public static void main (String[] args) {
		Queue<Integer>q_3026 = new LinkedList<Integer>();
		q_3026.add(1);
		q_3026.add(2);
		q_3026.add(3); //[1, 2, 3]
		System.out.println("sebelum reverse" + q_3026);
		Stack<Integer> s = new Stack<Integer>();
	while (!q_3026.isEmpty()) { // Q -> S
		s.push(q_3026.remove());
	}
	while (!s.isEmpty()) { // S -> Q
		q_3026.add(s.pop());
	}
	System.out.println("sesudah reverse = " + q_3026) ; // [3, 2, 1]
}
}
