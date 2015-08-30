import java.util.Scanner;

public class POJ_2663 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int[] dp = new int[31];
		dp[0] = 1;
		for (int i = 0; i <= 30; i++) {
			if (i - 2 >= 0) dp[i] += dp[i - 2] * 3;
			for (int j = 4; j <= 30; j += 2) {
				if (i - j >= 0) dp[i] += dp[i - j] * 2;
			}
		}
		for (;;) {
			int n = sc.nextInt();
			if (n == -1) return;
			System.out.println(dp[n]);
		}
	}

	public static void main(String[] args) {
		new POJ_2663().run();
	}
}
