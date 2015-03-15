public class AOJ_0525 {
	MyScanner sc = new MyScanner();
	int R, C, max;
	int[][] f;

	void run() {
		for (;;) {
			R = sc.nextInt();
			C = sc.nextInt();
			if ((R | C) == 0) {
				return;
			}
			f = sc.nextInt2dArray(R, C);
			max = 0;
			dfs(0);
			System.out.println(max);
		}
	}

	void dfs(int d) {
		if (d == R) {
			int cnt = 0;
			for (int i = 0; i < C; i++) {
				int tmp = 0;
				for (int j = 0; j < R; j++) {
					if (f[j][i] == 1) {
						tmp++;
					}
				}
				cnt += Math.max(tmp, R - tmp);
			}
			max = Math.max(max, cnt);
			return;
		}
		for (int i = 0; i < C; i++) f[d][i] ^= 1;
		dfs(d + 1);
		for (int i = 0; i < C; i++) f[d][i] ^= 1;
		dfs(d + 1);
	}

	public static void main(String[] args) {
		new AOJ_0525().run();
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

		int[] nextIntArray(int n) {
			int[] in = new int[n];
			for (int i = 0; i < n; i++) {
				in[i] = nextInt();
			}
			return in;
		}

		int[][] nextInt2dArray(int n, int m) {
			int[][] in = new int[n][m];
			for (int i = 0; i < n; i++) {
				in[i] = nextIntArray(m);
			}
			return in;
		}
	}
}
