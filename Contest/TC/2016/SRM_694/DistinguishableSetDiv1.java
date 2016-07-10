public class DistinguishableSetDiv1 {
	public int count(String[] answer) {
		int n = answer.length;
		int m = answer[0].length();
		boolean[] dp = new boolean[1 << m + 1];
		
		// 任意の2組のアンケートを比較し、同じ回答の集合Mをマークする
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int M = 0;
				for (int k = 0; k < m; k++) {
					if (answer[i].charAt(k) == answer[j].charAt(k)) M += (1 << k);
				}
				dp[M] = true;
			}
		}
		
		// Mの部分集合を全てマークする
		for (int i = (1 << m) - 1; i >= 0; i--) {
			if (!dp[i]) continue;
			for (int j = 0; j < m; j++) {
				if (((i >> j) & 1) > 0) dp[i - (1 << j)] = true;
			}
		}

		int ret = 0;
		for (int i = 0; i < (1 << m); i++) if (!dp[i]) ret++;
		return ret;
	}
}
