import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);

	void run() {
		int r = sc.nextInt();
		int s = sc.nextInt();
		int p = sc.nextInt();

		double[][][] dp = new double[r + 1][s + 1][p + 1];
		dp[r][s][p] = 1;

		for (int i = r; i >= 0; i--) {
			for (int j = s; j >= 0; j--) {
				for (int k = p; k >= 0; k--) {
					if (i * j + j * k + k * i == 0) continue;
					if (i - 1 >= 0) dp[i - 1][j][k] += dp[i][j][k] * (i * k) / (i * j + j * k + k * i);
					if (j - 1 >= 0) dp[i][j - 1][k] += dp[i][j][k] * (i * j) / (i * j + j * k + k * i);
					if (k - 1 >= 0) dp[i][j][k - 1] += dp[i][j][k] * (j * k) / (i * j + j * k + k * i);
				}
			}
		}
		double rP = 0;
		double sP = 0;
		double pP = 0;
		for (int i = 1; i <= r; i++) rP += dp[i][0][0];
		for (int i = 1; i <= s; i++) sP += dp[0][i][0];
		for (int i = 1; i <= p; i++) pP += dp[0][0][i];
		System.out.println(rP + " " + sP + " " + pP);
	}

	public static void main(String[] args) {
		new D().run();
	}
}
