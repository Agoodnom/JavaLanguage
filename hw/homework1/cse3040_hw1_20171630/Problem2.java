package homework1;

import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int start = 1;
		int end = 100;

		int n = (int) (Math.random() * 100 + 1);
		int i = 1;
		
		while (true) {
			
			System.out.printf("[%d] Guess a number (%d-%d): ", i++, start, end);
			int an = in.nextInt();

			if ((start > an) || (end < an)) {
				System.out.println("Not in range!");
				i--;
				continue;
			}

			if (an == n) {
				System.out.println("Correct! Number of guesses: " + --i);
				break;
			} else if (an > n) {
				System.out.println("Too large!");
				end = an - 1;
			} else if (an < n) {
				System.out.println("Too small!");
				start = an + 1;
			}
		}
		
		in.close();
	}

}
