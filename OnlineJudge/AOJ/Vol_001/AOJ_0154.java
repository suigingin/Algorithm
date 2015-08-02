import java.util.Scanner;

public class AOJ_0154 {
	Scanner sc = new Scanner(System.in);

	void run() {
		for (;;) {
			int n = sc.nextInt();
			if (n == 0) return;
			int[][] c = new int[n][2];
			for (int i = 0; i < n; i++) {
				c[i][0] = sc.nextInt();
				c[i][1] = sc.nextInt();
			}
			int[][] dp = new int[n + 1][1011];
			dp[0][0] = 1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= 1000; j++) {
					if (dp[i][j] != 0) {
						dp[i + 1][j] += dp[i][j];
						for (int k = 1; k <= c[i][1] && j + k * c[i][0] <= 1000; k++) {
							dp[i + 1][j + k * c[i][0]] += dp[i][j];
						}
					}
				}
			}
			int m = sc.nextInt();
			while (m-- > 0) {
				System.out.println(dp[n][sc.nextInt()]);
			}
		}
	}

	public static void main(String[] args) {
		new AOJ_0154().run();
	}
}
