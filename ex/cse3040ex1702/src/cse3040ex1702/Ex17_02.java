package cse3040ex1702;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex17_02 {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>(1000000);
		LinkedList<String> ll = new LinkedList<>();
		add(al);
		add(ll);
		System.out.println("=== access time ===");
		System.out.println("ArrayList	: " + access(al));
		System.out.println("LinkedList	: " + access(ll));
	}

	public static void add(List<String> list) {
		for (int i = 0; i < 10000; i++)
			list.add(i + "");
	}

	public static long access(List<String> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++)
			list.get(i);
		long end = System.currentTimeMillis();
		return end - start;
	}
}
