import java.util.Arrays;

public class OkonomiyakiParty {
	final int MOD = 1000000007;

	public int count(int[] osize, int M, int K) {
		
		int n = osize.length;

		int[][] com = new int[1001][1001];
		com[0][0] = 1;
		for (int i = 1; i <= 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if (j == 0 || j == i) com[i][j] = 1;
				else com[i][j] = (com[i - 1][j - 1] + com[i - 1][j]) % MOD;
			}
		}

		int cnt = 0;
		Arrays.sort(osize);
		for (int i = 0; i < n; i++) {
			int m = 1;
			for (int j = i + 1; j < n && osize[j] - osize[i] <= K; j++) m++;
			if (m >= M) {
				cnt += com[m - 1][M - 1];
				cnt %= MOD;
			}
		}
		return cnt;
	}
}
