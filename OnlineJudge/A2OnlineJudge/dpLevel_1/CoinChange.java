import java.util.Scanner;

public class CoinChange {
	Scanner sc = new Scanner(System.in);

	void run() {
		int[] ce = { 1, 5, 10, 25, 50 };
		int M = 10000;
		int[] dp = new int[M];
		dp[0] = 1;
		for (int i = 0; i < ce.length; i++) {
			for (int j = 0; j < M; j++) {
				if (j + ce[i] < M) {
					dp[j + ce[i]] += dp[j];
				}
			}
		}
		while (sc.hasNext()) {
			System.out.println(dp[sc.nextInt()]);
		}
	}

	public static void main(String[] args) {
		new CoinChange().run();
	}
}
