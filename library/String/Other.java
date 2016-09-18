package free;

public class Other {

	int levenshteinDistance(String st1, String st2) {
		int len1 = st1.length();
		int len2 = st2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++) dp[i][0] = i;
		for (int i = 0; i <= len2; i++) dp[0][i] = i;

		int cost = 0;
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				cost = (st1.charAt(i - 1) == st2.charAt(j - 1)) ? 0 : 1;
				dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + cost));
			}
		}
		return dp[len1][len2];
	}
}

