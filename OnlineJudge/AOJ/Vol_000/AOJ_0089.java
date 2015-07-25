import java.util.Scanner;

public class AOJ_0089 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int[][] n = new int[101][101];
		int[][] dp = new int[101][101];
		int l = 0;
		for (int i = 0; sc.hasNext(); i++, l++) {
			String[] line = sc.next().split(",");
			for (int j = 0; j < line.length; j++) n[i][j] = Integer.valueOf(line[j]);
		}

		dp[0][0] = n[0][0];
		for (int i = 1; i < l; i++) {
			for (int j = 0; j < l; j++) {
				if (i > l / 2) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j + 1]);
					dp[i][j] += n[i][j];
				} else {
					dp[i][j] = (j == 0) ? dp[i - 1][j] : Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
					dp[i][j] += n[i][j];
				}
			}
		}
		System.out.println(dp[l - 1][0]);
	}

	public static void main(String[] args) {
		new AOJ_0089().run();
	}
}
