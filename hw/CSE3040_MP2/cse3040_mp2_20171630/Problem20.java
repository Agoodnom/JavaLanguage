package mp2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

class BookInfo implements Comparable<BookInfo> {
	private String title;
	private String author;
	private String price;
	private int rank;

	BookInfo(String title, String author, String price, int rank) {
		this.title = title;
		this.price = price;
		this.rank = rank;
		int begin, end;
		int flag = 0;
		for (int i = 0; i < author.length(); i++) {
			if (author.charAt(i) == ',') {
				flag = 1;
			}
		}
		if (flag == 1) {
			begin = author.indexOf("by ") + "by ".length();
			end = author.indexOf(",");
			this.author = author.substring(begin, end);
		} else {
			begin = author.indexOf("by ") + "by ".length();
			this.author = author.substring(begin);
		}

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

	static ArrayList<BookInfo> readBooksJsoup(String url) {
		ArrayList<BookInfo> books = new ArrayList<BookInfo>();
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements bestsellers = doc.select("h3.product-info-title");
		Elements title = bestsellers.select("a");

		Elements author = doc.select("div.product-shelf-author");

		bestsellers = doc.select("span.current");
		Elements price = bestsellers.select("a");

		for (int i = 0; i < title.size(); i++) {
			books.add(new BookInfo(title.eq(i).text(), author.eq(i).text(), price.eq(i).text(), i + 1));
		}

		return books;
	}
}

public class Problem20 {

	public static void main(String[] args) {
		ArrayList<BookInfo> books;
		books = BookReader.readBooksJsoup("https://www.barnesandnoble.com/b/books/_/N-1fZ29Z8q8");
		Collections.sort(books);
		for (int i = 0; i < books.size(); i++) {
			BookInfo book = books.get(i);
			System.out.println(book);
		}
	}
}
