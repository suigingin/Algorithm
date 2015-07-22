import java.util.Scanner;

public class B_Div1 {
	Scanner sc = new Scanner(System.in);

	void run() {
		String a = sc.next();
		String b = sc.next();
		System.out.println(match(a, b) ? "YES" : "NO");
	}

	boolean match(String s1, String s2) {
		if (s1.equals(s2)) return true;
		if (s1.length() % 2 == 1) return false;

		String s1a = s1.substring(0, s1.length() / 2);
		String s1b = s1.substring(s1.length() / 2, s1.length());
		String s2a = s2.substring(0, s2.length() / 2);
		String s2b = s2.substring(s2.length() / 2, s2.length());
		if (match(s1a, s2a) && match(s1b, s2b)) return true;
		if (match(s1b, s2a) && match(s1a, s2b)) return true;
		return false;
	}

	public static void main(String[] args) {
		new B_Div1().run();
	}
}
