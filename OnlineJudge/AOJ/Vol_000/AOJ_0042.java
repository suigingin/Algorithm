import java.util.Scanner;

public class AOJ_0042 {
	Scanner sc = new Scanner(System.in);

	void run() {
		for (int T = 1;; T++) {
			int W = sc.nextInt();
			if (W == 0) return;
			int N = sc.nextInt();
			int[] v = new int[N];
			int[] w = new int[N];
			for (int i = 0; i < N; i++) {
				String[] in = sc.next().split(",");
				v[i] = Integer.valueOf(in[0]);
				w[i] = Integer.valueOf(in[1]);
			}

			int maxCost = 0;
			int minWeight = Integer.MAX_VALUE / 2;
			int[][] dp = new int[2][W + 1];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= W; j++) {
					if (j - w[i] >= 0) dp[(i + 1) & 1][j] = Math.max(dp[i & 1][j], dp[i & 1][j - w[i]] + v[i]);
					else dp[(i + 1) & 1][j] = dp[i & 1][j];

					if (dp[(i + 1) & 1][j] == maxCost && j < minWeight) {
						minWeight = j;
					} else if (dp[(i + 1) & 1][j] > maxCost) {
						maxCost = dp[(i + 1) & 1][j];
						minWeight = j;
					}
				}
			}
			System.out.println("Case " + T + ":");
			System.out.println(maxCost + "\n" + minWeight);
		}
	}

	public static void main(String[] args) {
		new AOJ_0042().run();
	}
}
