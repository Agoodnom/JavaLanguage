package mp1;

class PalindromeChecker {
	static void check() {
		System.out.println("Error input");
	}
	
	static void check(int num) {
		int digit;
		int n = num;
		int i;
		int a,b;
		
		for (i = 1,digit=0;n/i!=0; i *= 10,digit++);
			
		digit--;
		
		for(i=digit;i>digit/2;i--) {
			a=(int) (n/(Math.pow(10, i)));
			b=(int) (n/(Math.pow(10, digit-i)));
			
			if(a%10!=b%10) {
				System.out.println(num+" is not a palindrome.");
				return;
			}
		}
		System.out.println(num+" is a palindrome.");
	}

	static void check(String arr) {
		for(int i=0;i<arr.length()/2;i++) {
			if(arr.charAt(i)!=arr.charAt(arr.length()-i-1)) {
				System.out.println(arr+" is not a palindrome.");
				return;
			}
		}
		System.out.println(arr+" is a palindrome.");
	}
}

public class Problem11 {
	public static void main(String[] args) {
		PalindromeChecker.check("abcde");
		PalindromeChecker.check("abcba");
		PalindromeChecker.check(1234);
		PalindromeChecker.check(12321);
	}
}
