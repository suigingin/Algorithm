import java.util.Arrays;
import java.util.Scanner;

public class HowDoYouAdd {
	Scanner sc = new Scanner(System.in);
	int MOD = 1000000;

	void run() {
		for (;;) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			if ((N | K) == 0) return;
			int[][] dp = new int[K + 1][N + 1];
			dp[0][0] = 1;
			for (int i = 0; i < K; i++) {
				for (int j = 0; j <= N; j++) {
					for (int k = 0; k <= N; k++) {
						if (j + k <= N) {
							dp[i + 1][j + k] += dp[i][j];
							dp[i + 1][j + k] %= MOD;
						}
					}
				}
			}
			System.out.println(dp[K][N]);
		}
	}

	public static void main(String[] args) {
		new HowDoYouAdd().run();
	}
}
