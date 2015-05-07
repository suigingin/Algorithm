public class C1 {
	MyScanner sc = new MyScanner();
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };

	int n, m, sh, sw, th, tw;
	char[][] f;
	boolean[][] v;

	void run() {
		n = sc.nextInt();
		m = sc.nextInt();
		f = sc.nextCharField(n, m);
		sh = sc.nextInt() - 1;
		sw = sc.nextInt() - 1;
		th = sc.nextInt() - 1;
		tw = sc.nextInt() - 1;
		v = new boolean[n][m];
		if (reach(sh, sw, f)) {
			if (f[th][tw] == 'X') {
				System.out.println("YES");
			} else {
				int cnt = 0;
				boolean adjacent = false;
				for (int i = 0; i < 4; i++) {
					if (inner(th + dy[i], tw + dx[i], n, m)) {
						if (f[th + dy[i]][tw + dx[i]] == '.') {
							cnt++;
						}
						if (th + dy[i] == sh && tw + dx[i] == sw) {
							adjacent = true;
						}
					}
				}
				int needEmpty = adjacent ? 1 : 2;
				System.out.println(cnt >= needEmpty ? "YES" : "NO");
			}
		} else {
			System.out.println("NO");
		}
	}

	boolean reach(int h, int w, char[][] cf) {
		v[h][w] = true;
		boolean res = false;
		for (int i = 0; i < 4; i++) {
			int nexth = h + dy[i];
			int nextw = w + dx[i];
			if (inner(nexth, nextw, n, m)) {
				if (nexth == th && nextw == tw) {
					return true;
				} else if (!v[nexth][nextw] && cf[nexth][nextw] == '.') {
					res |= reach(nexth, nextw, cf);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		new C1().run();
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
