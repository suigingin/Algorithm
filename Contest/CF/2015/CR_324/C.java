import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int t = sc.nextInt();

		char[] s1 = sc.next().toCharArray();
		char[] s2 = sc.next().toCharArray();
		int diff = 0;
		for (int i = 0; i < n; i++) {
			if (s1[i] != s2[i]) diff++;
		}

		StringBuilder out = new StringBuilder();
		if (t >= diff) {
			// 一致する箇所で変更しなければいけない文字の数
			int match = t - diff;
			for (int i = 0; i < n; i++) {
				if (s1[i] != s2[i]) {
					out.append(getNoMatch(s1[i], s2[i]));
				} else {
					if (match > 0) {
						match--;
						out.append(getNoMatch(s1[i], s2[i]));
					} else {
						out.append(s1[i]);
					}
				}
			}
		} else {
			// 一致させなければいけない個数
			int s1t = diff - t;
			int s2t = diff - t;
			for (int i = 0; i < n; i++) {
				if (s1[i] != s2[i]) {
					if (s1t > 0) {
						out.append(s1[i]);
						s1t--;
					} else if (s2t > 0) {
						out.append(s2[i]);
						s2t--;
					} else {
						out.append(getNoMatch(s1[i], s2[i]));
					}
				} else {
					out.append(s1[i]);
				}
			}
			if (s1t > 0 || s2t > 0) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(out);
	}

	char getNoMatch(char a, char b) {
		for (char c = 'a'; c <= 'z'; c++) {
			if (c != a && c != b) {
				return c;
			}
		}
		return ')';
	}

	public static void main(String[] args) {
		new C().run();
	}
}
