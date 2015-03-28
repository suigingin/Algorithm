import java.util.ArrayList;
import java.util.Arrays;

public class AOJ_1167 {
	MyScanner sc = new MyScanner();

	void run() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int m = 1000000;
		for (int i = 1; i * (i + 1) * (i + 2) / 6 < m; i++) {
			list.add(i * (i + 1) * (i + 2) / 6);
		}
		int[] dp = new int[m];
		int[] dp2 = new int[m];
		Arrays.fill(dp, Integer.MAX_VALUE);
		Arrays.fill(dp2, Integer.MAX_VALUE);
		dp[0] = 0;
		dp2[0] = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i - list.get(j) >= 0) {
					dp[i] = Math.min(dp[i], dp[i - list.get(j)] + 1);
					if (list.get(j) % 2 == 1) {
						dp2[i] = Math.min(dp2[i], dp2[i - list.get(j)] + 1);
					}
				}
			}
		}
		for (;;) {
			int n = sc.nextInt();
			if (n == 0) {
				return;
			}
			System.out.println(dp[n] + " " + dp2[n]);
		}
	}

	public static void main(String[] args) {
		new AOJ_1167().run();
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

