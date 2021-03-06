public class Lcs {

	int getLcs(char[] s, char[] t) {
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

	String getLcsString(String s, String t) {
		int n = s.length();
		int m = t.length();
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (s.charAt(i) == t.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		char[] res = new char[dp[n][m]];
		while (n > 0 && m > 0) {
			if (dp[n][m] == dp[n - 1][m]) {
				n--;
			} else if (dp[n][m] == dp[n][m - 1]) {
				m--;
			} else {
				res[dp[n - 1][m - 1]] = s.charAt(n - 1);
				n--;
				m--;
			}
		}
		return String.valueOf(res);
	}
}

