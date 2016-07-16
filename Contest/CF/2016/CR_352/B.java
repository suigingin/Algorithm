import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		String s = sc.next();
		if (n > 26) {
			System.out.println(-1);
			return;
		}
		int[] c = new int[26];
		for (int i = 0; i < n; i++) c[s.charAt(i) - 'a']++;
		int cnt = 0;
		for (int i = 0; i < 26; i++) if (c[i] > 0) cnt += c[i] - 1;
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
