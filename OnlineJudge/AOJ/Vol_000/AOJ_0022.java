import java.util.Scanner;

public class AOJ_0022 {
	Scanner sc = new Scanner(System.in);

	void run() {
		for (;;) {
			int n = sc.nextInt();
			if (n == 0) return;

			int[] a = new int[n];
			int[] dp = new int[n];
			for (int i = 0; i < n; i++) a[i] = sc.nextInt();
			dp[0] = a[0];

			int max = a[0];
			for (int i = 1; i < n; i++) {
				dp[i] = Math.max(dp[i - 1] + a[i], a[i]);
				max = Math.max(max, dp[i]);
			}
			System.out.println(max);
		}
	}

	public static void main(String[] args) {
		new AOJ_0022().run();
	}
}
