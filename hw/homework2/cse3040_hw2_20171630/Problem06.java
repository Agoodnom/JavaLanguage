package homework2;

interface IntSequence {
	boolean hasNext();
	int next();
}

class FibonacciSequence implements IntSequence {
	private int i = 0;

	public boolean hasNext() {
		return true;
	}

	public int next() {
		i++;
		return fibonacci(i-1);
	}

	public int fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

}

public class Problem06 {
	public static void main(String[] args) {
		IntSequence seq = new FibonacciSequence();
		for (int i = 0; i < 20; i++) {
			if (seq.hasNext() == false)
				break;
			System.out.print(seq.next() + " ");
		}
		System.out.println(" ");
	}
}
