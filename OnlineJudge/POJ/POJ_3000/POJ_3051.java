public class POJ_3051 {
	MyScanner sc = new MyScanner();
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };

	int W, H;
	char[][] f;

	void run() {
		W = sc.nextInt();
		H = sc.nextInt();
		f = new char[H][W];
		for (int i = 0; i < H; i++) {
			String in = sc.next();
			for (int j = 0; j < W; j++) {
				f[i][j] = in.charAt(j);
			}
		}
		int max = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (f[i][j] == '*') {
					max = Math.max(max, dfs(i, j));
				}
			}
		}
		System.out.println(max);
	}

	int dfs(int h, int w) {
		f[h][w] = '.';
		int res = 1;
		for (int i = 0; i < 4; i++) {
			int nh = h + dy[i];
			int nw = w + dx[i];
			if (inner(nh, nw, H, W) && f[nh][nw] == '*') {
				res += dfs(nh, nw);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		new POJ_3051().run();
	}

	boolean inner(int h, int w, int H, int W) {
		return 0 <= h && h < H && 0 <= w && w < W;
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
	}
}
