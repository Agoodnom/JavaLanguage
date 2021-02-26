package mp1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Item {
	private String name;
	private int n = 1;

	Item(String name){
		this.name = name;
	}
	
	public void count() {
		this.n++;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return this.name + " " + this.n;
	}
}

class MyFileReader {

	public static boolean readDataFromFile(String str, ArrayList<Item> list) {
		BufferedReader br;
		int i,j;
		ArrayList<String> arr = new ArrayList<String>();
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
				for (String word : token) {
					arr.add(word);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (i = 0; i < arr.size(); i++) {
			for (j = 0; j < list.size(); j++) {
				if(arr.get(i).equalsIgnoreCase(list.get(j).getName())) {
					list.get(j).count();
					break;
				}
			}
			if(j==list.size()) {
				list.add(new Item(arr.get(i).toLowerCase()));
			}
			
		}

		return true;
	}
}

public class Problem15 {
	public static void main(String[] args) {
		ArrayList<Item> list = new ArrayList<>();
		boolean rv = MyFileReader.readDataFromFile("input_prob15.txt", list);
		if (rv == false) {
			System.out.println("Input file not found.");
			return;
		}
		for (Item it : list)
			System.out.println(it);
	}
}
