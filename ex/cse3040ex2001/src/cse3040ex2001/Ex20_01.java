package cse3040ex2001;

import java.util.HashMap;
import java.util.Scanner;

public class Ex20_01 {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234");
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("Please enter id and password.");
			System.out.print("id: ");
			String id = s.nextLine().trim();
			System.out.print("password: ");
			String password = s.nextLine().trim();
			System.out.println();
			if (!map.containsKey(id)) {
				System.out.println("id does not exist.");
				continue;
			} else {
				if (!(map.get(id)).equals(password)) {
					System.out.println("password does not match.");
				} else {
					System.out.println("welcome.");
					break;
				}
			}
		}
		s.close();
	}

}
