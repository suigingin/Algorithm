import java.math.BigDecimal;
import java.util.Scanner;

public class AOJ_0191 {
	Scanner sc = new Scanner(System.in);

	void run() {
		for (;;) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if ((n | m) == 0) return;
			double[][] g = new double[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					g[i][j] = sc.nextDouble();
				}
			}

			double[][] dp = new double[2][n];
			for (int i = 0; i < n; i++) dp[0][i] = 1;
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						dp[(i + 1) & 1][k] = Math.max(dp[(i + 1) & 1][k], dp[i & 1][j] * g[j][k]);
					}
				}
			}

			double max = 0;
			for (int i = 0; i < n; i++) max = Math.max(max, dp[(m - 1) & 1][i]);
			BigDecimal bd = new BigDecimal(max);
			System.out.println(bd.setScale(2, BigDecimal.ROUND_HALF_UP));
		}
	}

	public static void main(String[] args) {
		new AOJ_0191().run();
	}
}
