public class C {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		int M = 100000;
		long[] dp = new long[M + 1];
		long[] cnt = new long[M + 1];
		for (int i = 0; i < n; i++) {
			cnt[sc.nextInt()]++;
		}
		dp[1] = cnt[1];
		for (int i = 2; i <= M; i++) {
			dp[i] = cnt[i] * i;
			dp[i] = Math.max(dp[i - 1], dp[i] + dp[i - 2]);
		}
		System.out.println(dp[M]);
	}

	public static void main(String[] args) {
		new C().run();
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

