package cse3040ex2304;

class ThreadEx5_1 extends Thread {
	public void run() {
		for (int i = 0; i < 1000000000; i++) {
			System.out.printf("%s\n", new String("|"));
			//String a = new String("|");
		}
		System.out.println("elapsed time 2: " + (System.currentTimeMillis() - Ex23_04.startTime));

	}
}

public class Ex23_04 {
	static long startTime = 0;

	public static void main(String[] args) {
		ThreadEx5_1 t1 = new ThreadEx5_1();
		t1.start();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000000; i++) {
			System.out.printf("%s\n", new String("-"));
			//String a = new String("-");
		}
		System.out.println("elapsed time 1: " + (System.currentTimeMillis() - startTime));
	}

}
