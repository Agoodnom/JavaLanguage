package cse3040ex0803;

public class Ex08_03 {
	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public static void swap(int[] x) {
		int temp = x[0];
		x[0] = x[1];
		x[1] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 20;
		swap(x, y);
		System.out.println(x + " " + y);
		int[] z = new int[2];
		z[0] = 10;
		z[1] = 20;
		swap(z);
		System.out.println(z[0] + " " + z[1]);
	}

}
