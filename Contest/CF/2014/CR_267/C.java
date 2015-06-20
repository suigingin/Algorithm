package CR_267;

import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] p = new int[n + 1];
		for (int i = 1; i <= n; i++) p[i] = sc.nextInt();
		long[] sum = new long[n + 1];
		for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + p[i];

		long[][] dp = new long[2][n + 1];
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				if (j - m >= 0)  dp[i & 1][j] = Math.max(dp[i & 1][j - 1], dp[(i + 1) & 1][j - m] + sum[j] - sum[j - m]);
				else             dp[i & 1][j] = dp[i & 1][j - 1];
			}
		}
		System.out.println(dp[k & 1][n]);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
