package cse3040ex1903;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ex19_03 {

	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<>();
		int[][] borad = new int[5][5];
		for (; set.size() < 25;) {
			set.add((int) (Math.random() * 50) + 1 + "");
		}
		Iterator<String> it = set.iterator();
		for (int i = 0; i < borad.length; i++) {
			for (int j = 0; j < borad[i].length; j++) {
				borad[i][j] = Integer.parseInt(it.next());
				System.out.print((borad[i][j] < 10 ? "  " : " ") + borad[i][j]);
			}
			System.out.println();
		}
	}
}
