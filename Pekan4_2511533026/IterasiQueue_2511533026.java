package Pekan4_2511533026;

import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
public class IterasiQueue_2511533026 {
	public static void main (String args[]) {
		
		Queue<String> q_3026 = new LinkedList<>();
		
		q_3026.add("Praktikum");
		q_3026.add("Struktur");
		q_3026.add("Data");
		q_3026.add("Dan");
		q_3026.add("Algoritma");
		Iterator<String> iterator = q_3026.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
}
