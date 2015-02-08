public class C_2 {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int d = sc.nextInt();
		int tmp = 1;
		boolean ok = false;
		for (int i = 0; i < d; i++) {
			tmp *= k;
			if (tmp >= n) {
				ok = true;
				break;
			}
		}
		if (!ok) {
			System.out.println(-1);
			return;
		}

		int[][] ans = new int[n][d];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < d; j++) {
				ans[i][j] = ans[i - 1][j];
			}
			for (int j = d - 1; j >= 0; j--) {
				ans[i][j] = (ans[i][j] + 1) % k;
				if (ans[i][j] != 0) {
					break;
				}
			}
		}
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < n; j++) {
				out.append(ans[j][i] + 1 + " ");
			}
			out.append("\n");
		}
		System.out.print(out);
	}

	public static void main(String[] args) {
		new C_2().run();
	}

	class MyScanner {
		int nextInt() {
			try {
				int c = System.in.read();
				while (c != '-' && (c < '0' || '9' < c))
					c = System.in.read();
				if (c == '-')
					return -nextInt();
				int res = 0;
				do {
					res *= 10;
					res += c - '0';
					c = System.in.read();
				} while ('0' <= c && c <= '9');
				return res;
			} catch (Exception e) {
				return -1;
			}
		}
	}
}
