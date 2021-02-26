package mp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

class BookInfo implements Comparable<BookInfo> {
	private String title;
	private String author;
	private String price;
	private int rank;

	BookInfo(String title, String author, String price, int rank) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.rank = rank;
	}

	int getRank() {
		return this.rank;
	}

	public int compareTo(BookInfo b) {
		int b1 = this.rank;
		int b2 = b.getRank();
		return (b1 > b2 ? -1 : (b1 == b2 ? 0 : 1));
	}

	public String toString() {
		return "#" + this.rank + " " + this.title + ", " + this.author + ", " + this.price;
	}
}

class BookReader {

	static ArrayList<BookInfo> readBooks(String address) {
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<BookInfo> books = new ArrayList<BookInfo>();
		URL url = null;
		BufferedReader input = null;
		String line = "";

		try {
			url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = input.readLine()) != null) {
				if (line.trim().length() > 0)
					lines.add(line);
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		int rank = 1;
		int status = 0;
		String title = null;
		String author = null;
		String price;
		for (int i = 0; i < lines.size(); i++) {
			
			String l = lines.get(i);
			if (status == 0) {
				if (l.contains("<!--ATG-19777:PDP Glose Page Curl For Top 100 Start  -->")) {
					int begin = l.indexOf("\" alt=\"") + "\" alt=\"".length();
					int end = l.indexOf("\" /></a>");
					title = l.substring(begin, end);
					status = 1;
				}
			} else if (status == 1) {
				if (l.contains("product-shelf-author contributors")) {
					String temp;
					int begin = l.indexOf("a href") + "a href".length();
					int end = l.indexOf("</a>")+"</a>".length();
					temp = l.substring(begin, end);
					begin = temp.indexOf("\">") + "\">".length();
					end = temp.indexOf("</a>");
					author = temp.substring(begin, end);
					status = 2;
				}
			} else if (status == 2) {
				if (l.contains("Current price")) {
					int begin = l.indexOf("Current price is ") + "Current price is ".length();
					int end = l.indexOf(", Original price");
					price = l.substring(begin, end);
					status = 0;
					books.add(new BookInfo(title, author, price, rank));
					rank++;
				}

			}
		}

		return books;
	}
}

public class Problem19 {
	public static void main(String[] args) {
		ArrayList<BookInfo> books;
		books = BookReader.readBooks("https://www.barnesandnoble.com/b/books/_/N-1fZ29Z8q8");
		Collections.sort(books);
		for (int i = 0; i < books.size(); i++) {
			BookInfo book = books.get(i);
			System.out.println(book);
		}
	}
}