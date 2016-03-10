public class DivFreed2 {
	final int MOD = 1000000007;

	public int count(int n, int k) {
		int[][] dp = new int[n][k + 1];
		for (int i = 1; i <= k; i++) dp[0][i] = 1;
		for (int i = 1; i < n; i++) {
			int sum = 0;
			for (int j = 1; j <= k; j++) sum = (sum + dp[i - 1][j]) % MOD;
			for (int j = 1; j <= k; j++) dp[i][j] = sum;
			for (int j = 1; j <= k; j++) {
				int sub = 0;
				for (int l = j * 2; l <= k; l += j) sub = (sub + dp[i - 1][l]) % MOD;
				dp[i][j] = (dp[i][j] - sub) % MOD;
				if(dp[i][j]< 0) dp[i][j] += MOD;
			}
		}
		int res = 0;
		for (int j = 1; j <= k; j++) res = (res + dp[n - 1][j]) % MOD;
		return res;
	}
}
