package cse3040ex2204_1;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Ex22_04 {
	public static void main(String[] args) throws Exception {
		String url = "http://www.kyobobook.co.kr/bestSellerNew/bestseller.laf";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		Elements bestsellers = doc.select("div.detail");
		Elements titles = bestsellers.select("div.title");
		Elements booktitles = titles.select("a[href]");
		for (int i = 0; i < booktitles.size(); i++) {
			System.out.println(i + 1 + "위: " + booktitles.eq(i).text());
		}
	}
}
