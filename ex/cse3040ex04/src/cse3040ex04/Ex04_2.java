package cse3040ex04;

public class Ex04_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char a = 0xA7;
		System.out.println("a	: " + Integer.toString(a, 16));
		System.out.println("a & F0	: " + Integer.toString(a & 0xF0, 16));
		System.out.println("a | F0	: " + Integer.toString(a | 0xF0, 16));
		System.out.println("a ^ F0	: " + Integer.toString(a ^ 0XF0, 16));

		int b = 63;			//	00111111
		System.out.println("b >> 1 : " + (b >> 1));
		System.out.println("b >> 2 : " + (b >> 2));
		System.out.println("b >> 3 : " + (b >> 3));
		System.out.println("b >> 4 : " + (b >> 4));
	}

}
