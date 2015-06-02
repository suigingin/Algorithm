import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);
	final int MOD = 1000000007;

	void run() {
		int t = sc.nextInt();
		int k = sc.nextInt();
		int[] dp = new int[100001];
		int[] sum = new int[100001];
		dp[0] = 1;
		for (int i = 1; i <= 100000; i++) {
			dp[i] = dp[i - 1];
			if (i - k >= 0) dp[i] += dp[i - k];
			dp[i] %= MOD;
		}

		for (int i = 1; i <= 100000; i++) {
			sum[i] = sum[i - 1] + dp[i];
			sum[i] %= MOD;
		}

		while (t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(((sum[b] - sum[a - 1]) + MOD) % MOD);
		}
	}

	public static void main(String[] args) {
		new D().run();
	}
}
