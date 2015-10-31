import java.util.Scanner;

public class B_1 {

	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int W = sc.nextInt();
		int[] v = new int[N];
		int[] w = new int[N];
		for (int i = 0; i < N; i++) {
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
		}
		int[][] dp = new int[2][W + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= W; j++) {
				if (j - w[i] >= 0) dp[(i + 1) & 1][j] = Math.max(dp[i & 1][j], dp[i & 1][j - w[i]] + v[i]);
				else dp[(i + 1) & 1][j] = dp[i & 1][j];
			}
		}
		int max = 0;
		for (int i = 0; i <= W; i++) max = Math.max(max, dp[N & 1][i]);
		System.out.println(max);
	}

	public static void main(String[] args) {
		new B_1().run();
	}
}
