package cse3040ex1704;

import java.util.Stack;

public class Ex17_04 {
	public static Stack<String> back = new Stack<>();
	public static Stack<String> forward = new Stack<>();

	public static void main(String[] args) {
		goURL("1. Google");
		goURL("2. Facebook");
		goURL("3. Naver");
		goURL("4. Daum");
		printStatus();
		goBack();
		System.out.println("=== After pushing 'back' ===");
		printStatus();
		goBack();
		System.out.println("=== After pushing 'back' ===");
		printStatus();
		goForward();
		System.out.println("=== After pushing 'forward' ===");
		printStatus();
		goURL("www.sogang.ac.kr");
		System.out.println("=== After moving to a new URL ===");
		printStatus();
	}

	public static void printStatus() {
		System.out.println("back:" + back);
		System.out.println("forward:" + forward);
		System.out.println("current page is " + back.peek() + ".");
		System.out.println();
	}

	public static void goURL(String url) {
		back.push(url);
		if (!forward.empty())
			forward.clear();
	}

	public static void goForward() {
		if (!forward.empty())
			back.push(forward.pop());
	}

	public static void goBack() {
		if (!back.empty())
			forward.push(back.pop());
	}
}