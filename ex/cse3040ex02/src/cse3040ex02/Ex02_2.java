package cse3040ex02;

import java.util.Random;

public class Ex02_2 {

	public static void main(String[] args) {
		Random generator = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.println(generator.nextInt());
		}
	}
}
