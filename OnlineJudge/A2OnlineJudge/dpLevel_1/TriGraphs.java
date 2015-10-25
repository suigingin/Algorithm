public class TriGraphs {
	MyScanner sc = new MyScanner();

	void run() {
		int T = 0;
		for (;;) {
			int N = sc.nextInt();
			if (N == 0) return;
			int[][] g = new int[N][3];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					g[i][j] = sc.nextInt();
				}
			}
			long[][] dp = new long[2][3];
			dp[0][0] = Integer.MAX_VALUE / 2;
			dp[0][1] = g[0][1];
			dp[0][2] = g[0][1] + g[0][2];
			int index = 1;
			for (int i = 0; i < N - 1; i++) {
				dp[(i + 1) & 1][0] = Math.min(dp[i & 1][0], dp[i & 1][1]) + g[index][0];
				dp[(i + 1) & 1][1] = Math.min(dp[i & 1][0], Math.min(dp[i & 1][1], dp[i & 1][2])) + g[index][1];
				dp[(i + 1) & 1][1] = Math.min(dp[(i + 1) & 1][1], dp[(i + 1) & 1][0] + g[index][1]);
				dp[(i + 1) & 1][2] = Math.min(dp[i & 1][1], dp[i & 1][2]) + g[index][2];
				dp[(i + 1) & 1][2] = Math.min(dp[(i + 1) & 1][2], dp[(i + 1) & 1][1] + g[index][2]);
				index++;
			}
			System.out.println(++T + ". " + dp[(N + 1) & 1][1]);
		}
	}

	public static void main(String[] args) {
		new TriGraphs().run();
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
