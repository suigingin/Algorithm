import java.util.Arrays;

public class AOJ_0202 {
	MyScanner sc = new MyScanner();

	void run() {
		int M = 1000000;
		boolean[] prime = new boolean[M + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int i = 2; i * i <= M; i++) {
			if (!prime[i]) continue;
			for (int j = i * 2; j <= M; j += i) prime[j] = false;
		}
		L: for (;;) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			if ((n | x) == 0) return;
			int[] p = sc.nextIntArray(n);
			boolean[] dp = new boolean[M + 1];
			dp[0] = true;
			for (int i = 0; i <= M; i++) {
				for (int j = 0; j < n; j++) {
					if (i + p[j] <= M && dp[i]) {
						dp[i + p[j]] = true;
					}
				}
			}
			for (int i = x; i >= 1; i--) {
				if (dp[i] && prime[i]) {
					System.out.println(i);
					continue L;
				}
			}
			System.out.println("NA");
		}
	}

	public static void main(String[] args) {
		new AOJ_0202().run();
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
	}
}
