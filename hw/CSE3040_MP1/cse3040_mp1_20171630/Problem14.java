package mp1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Fruit {
	private String str;
	private double price;

	Fruit(String str, double price) {
		this.str = str;
		this.price = price;
	}

	public String name() {
		return this.str;
	}

	public double price() {
		return this.price;
	}
}

class FruitBox<T extends Fruit> {
	private ArrayList<T> list = new ArrayList<T>();

	public void add(T item) {
		list.add(item);
		System.out.println(item.name() + " " + item.price());
	}

	public int getNumItems() {
		return list.size();
	}

	public String getMaxItem() {
		double max = list.get(0).price();
		int index = 0;
		for (int i = 1; i < list.size(); i++) {
			if (max < list.get(i).price()) {
				max = list.get(i).price();
				index = i;
			}
		}
		return list.get(index).name();
	}

	public double getMaxPrice() {
		double max = list.get(0).price();
		int index = 0;
		for (int i = 1; i < list.size(); i++) {
			if (max < list.get(i).price()) {
				max = list.get(i).price();
				index = i;
			}
		}
		return list.get(index).price();
	}

	public String getMinItem() {
		double min = list.get(0).price();
		int index = 0;
		for (int i = 1; i < list.size(); i++) {
			if (min > list.get(i).price()) {
				min = list.get(i).price();
				index = i;
			}
		}
		return list.get(index).name();
	}

	public double getMinPrice() {
		double min = list.get(0).price();
		int index = 0;
		for (int i = 1; i < list.size(); i++) {
			if (min > list.get(i).price()) {
				min = list.get(i).price();
				index = i;
			}
		}
		return list.get(index).price();
	}

	public double getAvgPrice() {
		double sum = 0;
		double avg;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i).price();
		}
		avg = sum / list.size();
		return avg;
	}
}

class ItemReader {

	static boolean fileToBox(String str, FruitBox<Fruit> box) {
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(str));
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found.");
			return false;
		}
		while (true) {
			try {
				String line = br.readLine();
				if (line == null)
					break;
				String[] token = line.split(" ");
				box.add(new Fruit(token[0], Double.parseDouble(token[1])));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
}

public class Problem14 {
	public static void main(String[] args) {
		FruitBox<Fruit> box = new FruitBox<>();
		boolean rv = ItemReader.fileToBox("input_prob14.txt", box);
		if (rv == false)
			return;
		box.add(new Fruit("orange", 9.99));
		System.out.println("----------------");
		System.out.println("    Summary");
		System.out.println("----------------");
		System.out.println("number of items: " + box.getNumItems());
		System.out.println("most expensive item: " + box.getMaxItem() + " (" + box.getMaxPrice() + ")");
		System.out.println("cheapest item: " + box.getMinItem() + " (" + box.getMinPrice() + ")");
		System.out.printf("average price of items: %.2f", box.getAvgPrice());
	}
}
