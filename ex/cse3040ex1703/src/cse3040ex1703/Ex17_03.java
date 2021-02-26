package cse3040ex1703;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex17_03 {
	public static void main(String[] args) {
		Stack<String> st = new Stack<String>();
		Queue<String> q = new LinkedList<String>();
		
		st.push("0");
		st.push("1");
		st.push("2");
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		System.out.println("=== Stack ===");
		while (!st.empty())
			System.out.println(st.pop());
		System.out.println("=== Queue ===");
		while (!q.isEmpty())
			System.out.println(q.poll());
	}
}