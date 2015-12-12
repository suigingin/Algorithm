import java.util.Scanner;

public class NonDecreasingDigit {

	Scanner sc = new Scanner(System.in);

	void run() {
		long[][] dp = new long[64][10];
		for (int i = 0; i < 10; i++) dp[0][i] = 1;
		for (int i = 0; i < 64; i++) dp[i][0] = 1;
		for (int i = 1; i < 64; i++) {
			for (int j = 1; j < 10; j++) {
				dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
			}
		}

		int P = sc.nextInt();
		while (P-- > 0) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			long ans = 0;
			for (int i = 0; i < 10; i++) ans += dp[N - 1][i];
			System.out.println(T + " " + ans);
		}
	}

	public static void main(String[] args) {
		new NonDecreasingDigit().run();
	}
}
