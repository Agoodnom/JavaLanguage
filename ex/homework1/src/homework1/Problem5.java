package homework1;

import java.util.Scanner;

public class Problem5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		System.out.println("Enter exam scores of each student.");
		int score[] = new int[5];
		int max[] = new int[2];
		int maxIndex[] = new int[2];
		max[0] = 0;
		max[1] = 0;
		for (int i = 1; i <= 5; i++) {
			System.out.print("Score of student " + i + ": ");
			score[i - 1] = in.nextInt();
			if (max[0] < score[i - 1]) {
				max[0] = score[i - 1];
				maxIndex[0] = i;
			}
		}
		score[maxIndex[0]-1] = -1;
		for (int i = 1; i <= 5; i++) {
			if (max[1] < score[i - 1]) {
				max[1] = score[i - 1];
				maxIndex[1] = i;
			}
		}
		
		System.out.println("The 1st place is student "+maxIndex[0]+" with "+max[0]+" points.");
		System.out.println("The 2nd place is student "+maxIndex[1]+" with "+max[1]+" points.");
		in.close();
	}

}
