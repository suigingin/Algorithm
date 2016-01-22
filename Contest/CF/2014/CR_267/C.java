import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		long[] p = new long[n + 1];
		for (int i = 1; i <= n; i++) p[i] = p[i - 1] + sc.nextLong();
		long[][] dp = new long[2][n + 1];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				if (j + m <= n) {
					dp[(i + 1) & 1][j + m] = Math.max(dp[(i + 1) & 1][j + m - 1], dp[i & 1][j] + p[j + m] - p[j]);
				}
			}
		}
		System.out.println(dp[k & 1][n]);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
