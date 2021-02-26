package mp1;

class SubsequenceChecker {
	static void check(String str1, String str2) {
		int arr[] = new int[str2.length()];
		int i = 0, j = 0;
		while ((i < str1.length()) && (j < str2.length())) {
			if (str1.charAt(i) == str2.charAt(j)) {
				arr[j] = i;
				j++;
			}
			i++;
		}
		if (j >= str2.length()) {
			System.out.println(str2 + " is a subsequence of " + str1);
			for (int k = 0; k < str2.length(); k++)
				System.out.print(arr[k] + " ");
			System.out.println();
		}
		else
			System.out.println(str2 + " is not a subsequence of " + str1);
	}

}

public class Problem12 {
	public static void main(String[] args) {
		SubsequenceChecker.check("supercalifragilisticexpialidocious", "pads");
		SubsequenceChecker.check("supercalifragilisticexpialidocious", "padsx");
	}
}
