import java.util.Arrays;

public class TrySail {
	public int get(int[] strength) {
		Arrays.sort(strength);
		int n = strength.length;
		int s = 0;
		for (int i = 0; i < n; i++) s ^= strength[i];
		boolean[][][] dp = new boolean[n + 1][256][256];
		dp[0][0][0] = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 256; j++) {
				for (int k = 0; k < 256; k++) {
					if (dp[i][j][k]) dp[i + 1][j][k] = dp[i + 1][j ^ strength[i]][k] = dp[i + 1][j][k ^ strength[i]] = true;
				}
			}
		}
		int res = 0;
		for (int i = 0; i < 256; i++) {
			for (int j = 0; j < 256; j++) {
				if (dp[n][i][j]) res = Math.max(res, i + j + (s ^ i ^ j));
			}
		}
		return res;
	}
}
