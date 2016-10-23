import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) p[i] = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			String s = sc.nextLine();
			for (int j = 0; j < s.length(); j++) {
				if (isVowel(s.charAt(j))) cnt++;
			}
			if (cnt != p[i]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	boolean isVowel(char c) {
		String s = "aiueoy";
		return s.indexOf(c) >= 0;
	}

	public static void main(String[] args) {
		new B().run();
	}
}
