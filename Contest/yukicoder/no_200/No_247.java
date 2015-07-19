import java.util.Scanner;

public class No_247 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int C = sc.nextInt();
		int N = sc.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) a[i] = sc.nextInt();
		int[][] dp = new int[N + 1][C + 1];

		for (int i = 0; i <= N; i++) {
			for (int j = 1; j <= C; j++) {
				dp[i][j] = Integer.MAX_VALUE / 2;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= C; j++) {
				if (j - a[i] >= 0) {
					dp[i + 1][j] = Math.min(dp[i][j], dp[i][j - a[i]] + 1);
					dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i + 1][j - a[i]] + 1);
				} else {
					dp[i + 1][j] = dp[i][j];
				}
			}
		}

		int res = Integer.MAX_VALUE / 2;
		for (int i = 0; i <= N; i++) res = Math.min(res, dp[i][C]);
		System.out.println((res == Integer.MAX_VALUE / 2) ? -1 : res);
	}

	public static void main(String[] args) {
		new No_247().run();
	}
}
