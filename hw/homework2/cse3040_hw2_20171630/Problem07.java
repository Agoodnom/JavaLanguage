package homework2;

import java.util.Scanner;

interface IntSequenceStr {
	boolean hasNext();
	int next();
}

class BinarySequenceStr implements IntSequenceStr {
	private int n;
	private int cnt = 1;

	public BinarySequenceStr(int num) {
		this.n = num;
		while (true) {
			if (num <= 1) {
				break;
			} else {
				num /= 2;
				cnt++;
			}
		}
	}

	public boolean hasNext() {
		return (cnt-- >= 1) ? true : false;
	}

	public int next() {
		if (n >= Math.pow(2, cnt)) {
			n -= Math.pow(2, cnt);
			return 1;
		}
		return 0;
	}
}

public class Problem07 {
	 public static void main(String[] args) {
	 Scanner in = new Scanner(System.in);
	 System.out.print("Enter a positive integer: ");
	 String str = in.nextLine();
	 int num = Integer.parseInt(str);
	 in.close();
	 System.out.println("Integer: " + num);
	 IntSequenceStr seq = new BinarySequenceStr(num);
	 System.out.print("Binary number: ");
	 while(seq.hasNext()) System.out.print(seq.next());
	 System.out.println(" ");
	 }
	}
