package cse3040ex1902;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex19_02 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> set2 = new LinkedHashSet<>();
		Set<Integer> set3 = new TreeSet<>();
		for(;set.size()<6;) {
			int num = (int)(Math.random()*45)+1;
			set.add(Integer.valueOf(num));
			set2.add(Integer.valueOf(num));
			set3.add(Integer.valueOf(num));
		}
		System.out.println("HashSet 	: "+set);
		System.out.println("LinkedHashSet 	: "+set2);
		System.out.println("TreeSet 	: "+set3);
		
		//List<Integer> list = new LinkedList<>(set);
		//Collections.sort(list);
		//System.out.println(list);

	}

}
