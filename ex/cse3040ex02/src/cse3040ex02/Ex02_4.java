package cse3040ex02;

public class Ex02_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f = 0;
		double d = 0;
		for(int i=1;i<=100000;i++) {
			f += 100000;
			d += 100000;
		}
		System.out.println("float	: " + f/100000.0);
		System.out.println("double	: " + d/100000.0);
	}

}
