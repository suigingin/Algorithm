import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AOJ_1269 {
	Scanner sc = new Scanner(System.in);

	void run() {
		boolean[] isPrime = new boolean[1121];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i * i <= 1120; i++) {
			if (!isPrime[i]) continue;
			for (int j = i * 2; j <= 1120; j += i) isPrime[j] = false;
		}
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i = 1; i <= 1120; i++) {
			if (isPrime[i]) l.add(i);
		}

		int[][] dp = new int[15][1121];
		dp[0][0] = 1;
		for (int i = 0; i < l.size(); i++) {
			for (int j = 13; j >= 0; j--) {
				for (int k = 0; k <= 1120; k++) {
					if (dp[j][k] != 0 && k + l.get(i) <= 1120) {
						dp[j + 1][k + l.get(i)] += dp[j][k];
					}
				}
			}
		}
		for (;;) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			if ((n | k) == 0) return;
			System.out.println(dp[k][n]);
		}
	}

	public static void main(String[] args) {
		new AOJ_1269().run();
	}
}
