package cse3040ex02;

public class Ex02_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c;

		for (c = 0; c < 256; c++)
			System.out.print(" " + c);
		System.out.println("\n");

		c = (char) ('A' + 3);
		System.out.println(c);

		c -= 2;
		System.out.println(c);

		c = (char) ('A' + '5');
		System.out.println(c);
	}

}
