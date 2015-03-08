public class A {
	MyScanner sc = new MyScanner();
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };

	void run() {
		int n = sc.nextInt();
		char[][] f = sc.nextCharField(n, n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nh = i + dy[k];
					int nw = j + dx[k];
					if (inner(nh, nw, n, n) && f[nh][nw] == 'o') {
						cnt++;
					}
				}
				if (cnt % 2 != 0) {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");
	}

	public static void main(String[] args) {
		new A().run();
	}

	boolean inner(int h, int w, int limH, int limW) {
		return 0 <= h && h < limH && 0 <= w && w < limW;
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
