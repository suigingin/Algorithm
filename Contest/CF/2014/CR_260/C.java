import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int M = 100000;
		long[] dp = new long[M + 1];
		long[] cnt = new long[M + 1];
		for (int i = 0; i < n; i++) {
			cnt[sc.nextInt()]++;
		}
		dp[1] = cnt[1];
		for (int i = 2; i <= M; i++) {
			dp[i] = cnt[i] * i;
			dp[i] = Math.max(dp[i - 1], dp[i] + dp[i - 2]);
		}
		System.out.println(dp[M]);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
