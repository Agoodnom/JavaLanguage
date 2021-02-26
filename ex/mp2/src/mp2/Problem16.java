package mp2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Element implements Comparable<Element> {
	private String name;
	private double price;

	Element(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}

	public int compareTo(Element e) {
		if (this.price < e.getPrice())
			return -1;
		if (this.price > e.getPrice())
			return 1;
		return this.name.compareTo(e.getName());
	}
	public String toString() {
		
		
		return this.name +" "+ this.price;
	}
}

class ElementReader {

	public static ArrayList<Element> readElements(String str) {

		BufferedReader br = null;
		ArrayList<Element> list = new ArrayList<Element>();
		try {
			br = new BufferedReader(new FileReader(str));
		} catch (FileNotFoundException e) {
			return null;
		}
		while (true) {
			try {
				String line = br.readLine();
				if (line == null)
					break;
				String[] token = line.split(" ");
				list.add(new Element(token[0], Double.parseDouble(token[1])));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

}

public class Problem16 {
	public static void main(String args[]) {
		ArrayList<Element> list = ElementReader.readElements("input.txt");
		if (list == null) {
			System.out.println("Input file not found.");
			return;
		}
		Collections.sort(list);
		Iterator<Element> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}