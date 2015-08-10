import java.util.Scanner;

public class AOJ_0097 {
	Scanner sc = new Scanner(System.in);

	void run() {
		long dp[][] = new long[10][1001];
		dp[0][0] = 1;
		for (int i = 0; i <= 100; i++) {
			for (int j = 8; j >= 0; j--) {
				for (int k = 0; k <= 1000; k++) {
					if (k + i <= 1000) dp[j + 1][k + i] += dp[j][k];
				}
			}
		}
		for (;;) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			if ((n | s) == 0) return;
			System.out.println(dp[n][s]);
		}
	}

	public static void main(String[] args) {
		new AOJ_0097().run();
	}
}
