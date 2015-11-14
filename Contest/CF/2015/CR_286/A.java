import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		String in = sc.next();
		for (int i = 0; i <= in.length(); i++) {
			for (char k = 'a'; k <= 'z'; k++) {
				String out = "";
				out = in.substring(0, i) + k + in.substring(i, in.length());
				if (check(out)) {
					System.out.println(out);
					return;
				}
			}
		}
		System.out.println("NA");
	}

	boolean check(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		new A().run();
	}
}
