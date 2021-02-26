package cse3040ex1706;

import java.util.PriorityQueue;
import java.util.Queue;

public class Ex17_06 {
	public static void main(String[] args) {
		Queue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(3);
		pq.offer(1);
		pq.offer(5);
		pq.offer(2);
		pq.offer(4);
		System.out.println(pq);
		Integer i = null;
		while ((i = pq.poll()) != null)
			System.out.println(i);
	}
}