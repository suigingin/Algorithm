import java.util.Scanner;

public class No_238 {
	Scanner sc = new Scanner(System.in);

	void run() {
		StringBuilder s = new StringBuilder(sc.next());
		if (palindrome(s.toString())) {
			s.insert(s.length() / 2, s.charAt(s.length() / 2));
			System.out.println(s);
			return;
		}
		int l = 0;
		int r = s.length() - 1;
		while (l <= r) {
			if (s.charAt(l) != s.charAt(r)) {
				StringBuilder s1 = new StringBuilder(s);
				StringBuilder s2 = new StringBuilder(s);
				s1.insert(l, s.charAt(r));
				s2.insert(r + 1, s.charAt(l));
				if (palindrome(s1.toString()))      System.out.println(s1);
				else if (palindrome(s2.toString())) System.out.println(s2);
				else                                System.out.println("NA");
				return;
			}
			l++;
			r--;
		}
	}

	public static void main(String[] args) {
		new No_238().run();
	}

	boolean palindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
