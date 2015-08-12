import java.util.Arrays;
import java.util.Scanner;

public class AOJ_0098 {
	Scanner sc = new Scanner(System.in);
	int INF = Integer.MAX_VALUE / 2;

	void run() {
		int n = sc.nextInt();
		int[][] f = new int[n][n];
		for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) f[i][j] = sc.nextInt();
		int[][] sum = new int[n][n];
		for (int i = 0; i < n; i++) sum[0][i] = f[0][i];
		for (int i = 0; i < n; i++) for (int j = 1; j < n; j++) sum[j][i] = sum[j - 1][i] + f[j][i];
		int ans = -INF;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int[] dp = new int[n];
				Arrays.fill(dp, -INF);
				dp[0] = (i == 0) ? sum[j][0] : sum[j][0] - sum[i - 1][0];
				ans = Math.max(ans, dp[0]);
				for (int k = 1; k < n; k++) {
					int s = (i == 0) ? sum[j][k] : sum[j][k] - sum[i - 1][k];
					dp[k] = Math.max(dp[k - 1] + s, s);
					ans = Math.max(ans, dp[k]);
				}
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new AOJ_0098().run();
	}
}
