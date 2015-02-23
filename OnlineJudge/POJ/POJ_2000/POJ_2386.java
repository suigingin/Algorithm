public class POJ_2386 {
	MyScanner sc = new MyScanner();
	int H, W;
	char[][] f;

	void run() {
		H = sc.nextInt();
		W = sc.nextInt();
		f = sc.nextCharField(H, W);
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (f[i][j] == 'W') {
					cnt++;
					dfs(i, j);
				}
			}
		}
		System.out.println(cnt);
	}

	void dfs(int h, int w) {
		f[h][w] = '.';
		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; dy++) {
				int nh = h + dx;
				int nw = w + dy;
				if (inner(nh, nw, H, W) && f[nh][nw] == 'W') {
					dfs(nh, nw);
				}
			}
		}
	}

	public static void main(String[] args) {
		new POJ_2386().run();
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
