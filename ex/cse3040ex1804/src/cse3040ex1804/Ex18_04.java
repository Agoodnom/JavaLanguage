package cse3040ex1804;

import java.util.Arrays;
import java.util.Collections;
/*
class Descending<T> implements Comparator<T> {
	public int compare(T o1, T o2) {
		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2) * -1;
		}
		return -1;
	}
}

class Descending implements Comparator<String> {
	public int compare(String s1, String s2) {
		return s1.compareTo(s2) * -1;
	}
}
*/

public class Ex18_04 {

	public static void main(String[] args) {
		String[] strArr = { "lion", "DOG", "TIGER", "cat" };
		System.out.println("strArr = " + Arrays.toString(strArr));
		Arrays.sort(strArr);
		System.out.println("Sort : strArr = " + Arrays.toString(strArr));
		//Arrays.sort(strArr, new Descending());
		Arrays.sort(strArr, Collections.reverseOrder());
		System.out.println("Descending sort : strArr = " + Arrays.toString(strArr));
	}

}
