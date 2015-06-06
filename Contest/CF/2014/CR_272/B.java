import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	String s1, s2;
	int l, p1, p2, unknown, cnt;

	void run() {
		s1 = sc.next();
		s2 = sc.next();
		l = s1.length();
		unknown = 0;

		for (int i = 0; i < l; i++) {
			if (s2.charAt(i) == '?') unknown += 1;
			p1 += s1.charAt(i) == '+' ? 1 : -1;
			p2 += s2.charAt(i) == '+' ? 1 : s2.charAt(i) == '-' ? -1 : 0;
		}
		dfs(0, "");
		System.out.println((double) cnt / (1 << unknown));
	}

	void dfs(int d, String make) {
		if (d == l) {
			int diff = 0;
			for (int i = 0; i < l; i++) diff += make.charAt(i) == '+' ? 1 : -1;
			if (diff == p1) cnt++;
			return;
		}
		if (s2.charAt(d) == '?') {
			dfs(d + 1, make + '+');
			dfs(d + 1, make + '-');
		} else {
			dfs(d + 1, make + s2.charAt(d));
		}
	}

	public static void main(String[] args) {
		new B().run();
	}
}
