import java.util.Scanner;

public class AOJ_0168 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int[] dp = new int[31];
		dp[0] = dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= 30; i++) dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		for (;;) {
			int n = sc.nextInt();
			if (n == 0) return;
			System.out.println((dp[n] / 3650) + 1);
		}
	}

	public static void main(String[] args) {
		new AOJ_0168().run();
	}
}
