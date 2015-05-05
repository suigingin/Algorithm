import java.util.Arrays;

public class MutaliskEasy {

	int[][][] memo;

	public int minimalAttacks(int[] x) {
		memo = new int[61][61][61];
		int a = x[0];
		int b = x.length >= 2 ? x[1] : 0;
		int c = x.length >= 3 ? x[2] : 0;
		for (int i = 0; i <= 60; i++) {
			for (int j = 0; j <= 60; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}
		return dfs(a, b, c);
	}

	int dfs(int a, int b, int c) {
		if (a < 0) a = 0;
		if (b < 0) b = 0;
		if (c < 0) c = 0;
		if (a == 0 && b == 0 && c == 0) return 0;
		if (memo[a][b][c] != -1) return memo[a][b][c];
		int res = Integer.MAX_VALUE;
		res = Math.min(res, dfs(a - 9, b - 3, c - 1));
		res = Math.min(res, dfs(a - 9, b - 1, c - 3));
		res = Math.min(res, dfs(a - 3, b - 9, c - 1));
		res = Math.min(res, dfs(a - 3, b - 1, c - 9));
		res = Math.min(res, dfs(a - 1, b - 9, c - 3));
		res = Math.min(res, dfs(a - 1, b - 3, c - 9));
		return memo[a][b][c] = res + 1;
	}
}
