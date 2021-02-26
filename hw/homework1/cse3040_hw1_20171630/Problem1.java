package homework1;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		char c= '\0';
		System.out.print("ASCII code teller. Eenter a letter: ");
		String letter = in.nextLine();

		int n = letter.length();
		if(n==1)
			c = letter.charAt(0);

		if (n != 1||(('A'>c||'z'<c)||('Z'<c&&'a'>c))) {
			System.out.println("You must input a single uppercase or lowercase alphabet.");
		} else {

			System.out.println("The ASCII code of " + letter + " is " + (int) c);
		}
		in.close();
	}

}