package mp1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Text {
	private ArrayList<String> str = new ArrayList<String>();

	public boolean readTextFromFile(String str) {

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
				this.str.add(line);
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

	public int countChar(char c) {
		int n = 0;
		for (int i = 0; i < this.str.size(); i++) {
			String list = this.str.get(i);
			for (int j = 0; j < list.length(); j++) {
				if (list.charAt(j) == c||list.charAt(j)==(char)(c-32))
					n++;
			}
		}
		return n;
	}
}

public class Problem13 {
	public static void main(String[] args) {
		Text t = new Text();
		if (t.readTextFromFile("input_prob13.txt")) {
			for (char c = 'a'; c <= 'z'; c++) {
				System.out.println(c + ": " + t.countChar(c));
			}
		}
	}
}
