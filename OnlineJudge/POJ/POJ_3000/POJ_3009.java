public class POJ_3009 {
	MyScanner sc = new MyScanner();
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };

	int H, W, sh, sw, cnt;
	int[][] f;

	void run() {
		for (;;) {
			W = sc.nextInt();
			H = sc.nextInt();
			f = new int[H][W];
			if ((W | H) == 0) {
				return;
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					f[i][j] = sc.nextInt();
					if (f[i][j] == 2) {
						f[i][j] = 0;
						sh = i;
						sw = j;
					}
				}
			}
			cnt = Integer.MAX_VALUE;
			dfs(0, sh, sw);
			System.out.println(cnt <= 10 ? cnt : -1);
		}
	}

	void dfs(int d, int h, int w) {
		for (int i = 0; i < 4; i++) {
			int nexth = h + dy[i];
			int nextw = w + dx[i];
			if (!inner(nexth, nextw, H, W) || f[nexth][nextw] == 1) {
				continue;
			}
			while (inner(nexth, nextw, H, W) && f[nexth][nextw] == 0) {
				nexth += dy[i];
				nextw += dx[i];
			}
			if (!inner(nexth, nextw, H, W)) {
				continue;
			} else if (f[nexth][nextw] == 3) {
				cnt = Math.min(cnt, d + 1);
			} else if (f[nexth][nextw] == 1 && d < 10) {
				f[nexth][nextw] = 0;
				dfs(d + 1, nexth - dy[i], nextw - dx[i]);
				f[nexth][nextw] = 1;
			}
		}
	}

	public static void main(String[] args) {
		new POJ_3009().run();
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
	}
}
