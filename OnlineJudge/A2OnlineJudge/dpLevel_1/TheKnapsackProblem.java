import java.util.Scanner;

public class TheKnapsackProblem {
	Scanner sc = new Scanner(System.in);

	void run() {
		int S = sc.nextInt();
		int N = sc.nextInt();
		int[] w = new int[N];
		int[] v = new int[N];
		for (int i = 0; i < N; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}

		int[][] dp = new int[2][S + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= S; j++) {
				if (j - w[i] >= 0) {
					dp[(i + 1) & 1][j] = Math.max(dp[i & 1][j - w[i]] + v[i], dp[i & 1][j]);
				} else {
					dp[(i + 1) & 1][j] = dp[i & 1][j];
				}
			}
		}
		int max = 0;
		for (int i = 0; i <= S; i++) max = Math.max(max, dp[N & 1][i]);
		System.out.println(max);
	}

	public static void main(String[] args) {
		new TheKnapsackProblem().run();
	}
}
