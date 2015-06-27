public class B {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		char[][] f = sc.nextCharField(n, n);
		int max = 0;

		for (int i = 0; i < n; i++) {
			char[][] ff = new char[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					ff[j][k] = f[j][k];
				}
			}

			for (int j = 0; j < n; j++) {
				if (ff[i][j] == '0') {
					for (int k = 0; k < n; k++) {
						ff[k][j] = (ff[k][j] == '1') ? '0' : '1';
					}
				}
			}

			int cnt = 0;
			L: for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (ff[j][k] == '0') continue L;
				}
				cnt++;
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		new B().run();
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

		String next() {
			try {
				StringBuilder res = new StringBuilder("");
				int c = System.in.read();
				while (Character.isWhitespace(c))
					c = System.in.read();
				do {
					res.append((char) c);
				} while (!Character.isWhitespace(c = System.in.read()));
				return res.toString();
			} catch (Exception e) {
				return null;
			}
		}

		char[][] nextCharField(int n, int m) {
			char[][] in = new char[n][m];
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < m; j++) {
					in[i][j] = s.charAt(j);
				}
			}
			return in;
		}
	}
}
