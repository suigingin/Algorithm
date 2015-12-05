import java.util.Arrays;
import java.util.Scanner;

public class AOJ_0579 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int D = sc.nextInt();
		int N = sc.nextInt();
		int[] T = new int[D];
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N];
		for (int i = 0; i < D; i++) T[i] = sc.nextInt();
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			B[i] = sc.nextInt();
			C[i] = sc.nextInt();
		}
		int[][] dp = new int[D][N];
		for (int i = 0; i < D; i++) Arrays.fill(dp[i], -1);
		for (int i = 0; i < N; i++) {
			if (A[i] <= T[0] && T[0] <= B[i]) dp[0][i] = 0;
		}
		int max = 0;
		for (int i = 0; i < D - 1; i++) {
			// j -> kへ服を切り替える
			for (int j = 0; j < N; j++) {
				if (dp[i][j] >= 0) {
					for (int k = 0; k < N; k++) {
						if (A[k] <= T[i + 1] && T[i + 1] <= B[k]) {
							dp[i + 1][k] = Math.max(dp[i + 1][k], dp[i][j] + Math.abs(C[j] - C[k]));
							max = Math.max(max, dp[i + 1][k]);
						}
					}
				}
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		new AOJ_0579().run();
	}
}
