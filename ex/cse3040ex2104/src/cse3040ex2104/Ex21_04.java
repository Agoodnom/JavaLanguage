package cse3040ex2104;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Ex21_04 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.youtube.com/results?search_query=java");

			System.out.println("url.getAuthority(): " + url.getAuthority());
			System.out.println("url.getContent(): " + url.getContent());
			System.out.println("url.getDefaultPort(): " + url.getDefaultPort());
			System.out.println("url.getPort(): " + url.getPort());
			System.out.println("url.getFile(): " + url.getFile());
			System.out.println("url.getHost(): " + url.getHost());
			System.out.println("url.getPath(): " + url.getPath());
			System.out.println("url.getProtocol(): " + url.getProtocol());
			System.out.println("url.getQuery(): " + url.getQuery());
			System.out.println("url.getRef(): " + url.getRef());
			System.out.println("url.getUserInfo(): " + url.getUserInfo());
			System.out.println("url.toExternalForm(): " + url.toExternalForm());
			System.out.println("url.toURI(): " + url.toURI());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
