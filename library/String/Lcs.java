public class Lcs {

	int lcs(char[] s, char[] t) {
		int n = s.length;
		int m = t.length;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (s[i] == t[j]) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		return dp[n][m];
	}

}

