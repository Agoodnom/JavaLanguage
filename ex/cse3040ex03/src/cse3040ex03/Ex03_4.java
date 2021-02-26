package cse3040ex03;

public class Ex03_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("3>2: " + (3 > 2));
		System.out.println("1>2: " + (1 > 2));

		int n = 0, s = 0;
		System.out.println("n != 0 && s + (100 - s) / n < 50: " + 
				(n != 0 && s + (100 - s) / n < 50));
		//0으로 나누면 error가 생겨야하지만 앞부분이 false이기 때문에 && 뒷부분이 계산이 안되었다.
		System.out.println("n == 0 || s + (100 - s) / n >= 50: " + 
				(n == 0 || s + (100 - s) / n >= 50));

	}

}
