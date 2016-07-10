public class UpDownNess {
	final int MOD = 1000000007;

	public int count(int N, int K) {
		// dp[i][j] := i番目までの数を使った時、lo-hi-loがj個作れるパターンの総数
		int[][] dp = new int[N + 1][K + 1];
		dp[0][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= K; j++) {
				for (int k = 0; k <= i; k++) {
					if (j + k * (i - k) > K || dp[i][j] == 0) continue;
					dp[i + 1][j + k * (i - k)] += dp[i][j];
					dp[i + 1][j + k * (i - k)] %= MOD;
				}
			}
		}
		return dp[N][K];
	}
}
