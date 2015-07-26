import java.util.Arrays;
import java.util.Scanner;

public class AOJ_0106 {
	Scanner sc = new Scanner(System.in);

	void run() {

		int M = 5000;
		int[] item = { 200, 300, 500, 1000, 1200, 1500 };
		int[] price = { 380, 550, 850, 1520, 1870, 2244 };
		int[] dp = new int[M + 1];
		Arrays.fill(dp, Integer.MAX_VALUE / 2);
		dp[0] = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j + item[i] <= M; j++) {
				dp[j + item[i]] = Math.min(dp[j + item[i]], dp[j] + price[i]);
			}
		}

		for (;;) {
			int n = sc.nextInt();
			if (n == 0) return;
			System.out.println(dp[n]);
		}
	}

	public static void main(String[] args) {
		new AOJ_0106().run();
	}
}
