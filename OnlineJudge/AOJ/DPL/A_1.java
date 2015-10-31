import java.util.Arrays;
import java.util.Scanner;

public class A_1 {

	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] v = new int[m];
		for (int i = 0; i < m; i++) v[i] = sc.nextInt();
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE / 2);
		dp[0] = 0;
		for (int i = 0; i <= n; i++) {
			if (dp[i] != Integer.MAX_VALUE / 2) {
				for (int j = 0; j < m; j++) {
					if (i + v[j] <= n) dp[i + v[j]] = Math.min(dp[i + v[j]], dp[i] + 1);
				}
			}
		}
		System.out.println(dp[n]);
	}

	public static void main(String[] args) {
		new A_1().run();
	}
}
