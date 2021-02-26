package cse3040ex0901;

interface IntSequence {
	boolean hasNext();

	int next();
}

class SimpleSequence implements IntSequence {
	private int number;

	public boolean hasNext() {
		return true;
	}

	public int next() {
		number++;
		return number;
	}
}

class SquareSequence implements IntSequence {
	private int number;

	public boolean hasNext() {
		return true;
	}

	public int next() {
		number++;
		return number * number;
	}

}

class DigitSequence implements IntSequence {
	private int number;

	public DigitSequence(int n) {
		number = n;
	}

	public boolean hasNext() {
		return number != 0;
	}

	public int next() {
		int result = number % 10;
		number /= 10;
		return result;
	}

	public int rest() {
		return number;
	}
}

public class Ex09_1 {

	public static double average(IntSequence seq, int n) {
		int count = 0;
		double sum = 0;
		while (seq.hasNext() && count < n) {
			count++;
			sum += seq.next();
		}
		return count == 0 ? 0 : sum / count;
	}

	public static void main(String[] args) {
		IntSequence seq1 = new SimpleSequence();
		IntSequence seq2 = new SquareSequence();
		IntSequence seq3 = new DigitSequence(123456789);
		
		SimpleSequence test = (SimpleSequence)seq1;
		
		System.out.println("(SimpleSequence)"+ average(test,10));
		System.out.println("(SquareSequence)"+ average(seq2,10));
		System.out.println("(DigitSequence)"+ average(seq3,10));
	}

}
