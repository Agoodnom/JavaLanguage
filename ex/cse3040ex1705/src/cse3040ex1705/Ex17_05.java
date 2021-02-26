package cse3040ex1705;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class Ex17_05 {
	static Queue<String> q = new LinkedList<String>();
	static final int MAX_SIZE = 5;

	public static void main(String[] args) {
		System.out.println("input 'help' to display help message.");
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.print(">>");
			try {
				String input = s.nextLine().trim();
				if ("".equals(input))
					continue;
				if (input.equalsIgnoreCase("q")) {
					s.close();
					System.exit(0);
				} else if (input.equalsIgnoreCase("help")) {
					System.out.println(" help – displays help message.");
					System.out.println(" q or Q – exit the program.");
					System.out.println(" history – shows recent commands.");
				} else if (input.equalsIgnoreCase("history")) {
					int i = 0;
					save(input);
					LinkedList<String> tmp = (LinkedList<String>) q;
					ListIterator<String> it = tmp.listIterator();
					while (it.hasNext())
						System.out.println(++i + "." + it.next());
				} else {
					save(input);
					System.out.println(input);
				}
			} catch (Exception e) {
				System.out.println("input error.");
			}
		}
	}

	public static void save(String input) {
		if (!"".equals(input))
			q.offer(input);
		if (q.size() > MAX_SIZE)
			q.remove();
	}
}