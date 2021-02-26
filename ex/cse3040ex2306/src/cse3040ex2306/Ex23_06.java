package cse3040ex2306;

import javax.swing.JOptionPane;

class ThreadEx7_1 extends Thread {
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}
		}
	}
}

public class Ex23_06 {

	public static void main(String[] args) {
		ThreadEx7_1 th1 = new ThreadEx7_1();
		th1.start();

		String input = JOptionPane.showInputDialog("Enter any string");
		System.out.println("You have entered: " + input);

	}

}
