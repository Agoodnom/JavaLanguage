package homework1;

import java.util.Scanner;

public class Problem4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		System.out.print("Enter a text: ");
		String text = in.nextLine();
		while (true) {
			System.out.print("Enter a string: ");
			String string = in.nextLine();

			if (string.length() == 0) {
				System.out.println("You must enter a string.");
				continue;
			} else {
				int cnt = 0;
				int i, j, k;
				for (i = 0; i <= text.length() - string.length(); i++) {
					if (string.charAt(0) == text.charAt(i)) {
						j = i+1;
						for (k = 1; k < string.length(); k++) {
							if (string.charAt(k) != text.charAt(j))
								break;
							j++;
						}
						if (k == string.length())
							cnt++;
					}
				}
				System.out.printf("There are %d instances of \"%s\"", cnt, string);
				break;
			}
		}

		in.close();
	}

}
