package homework1;

import java.util.Scanner;

public class Problem3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);	
		
		System.out.print("Enter a text: ");
		String text = in.nextLine();
		while(true) {
			System.out.print("Enter a letter: ");
			String line = in.nextLine();
			char letter = line.charAt(0);
			
			if(line.length()!=1) {
				System.out.println("You must enter a single letter.");
				continue;
			}
			else {
				int cnt = 0;
				
				for(int i=0;i<text.length();i++) {
					if(letter==text.charAt(i))
						cnt++;
				}
				
				System.out.printf("There are %d %c's in the text",cnt,letter);
				break;
			}
		}
		
		in.close();
	}

}
