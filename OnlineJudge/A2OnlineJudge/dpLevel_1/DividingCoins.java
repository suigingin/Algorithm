import java.util.Scanner;

public class DividingCoins {
	Scanner sc = new Scanner(System.in);

	void solve1() {
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int sum = 0;
			int[] c = new int[n];
			for (int i = 0; i < n; i++) {
				c[i] = sc.nextInt();
				sum += c[i];
			}
			int half = sum / 2;
			int[][] dp = new int[2][half + 1];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= half; j++) {
					if (j - c[i] >= 0) dp[(i + 1) & 1][j] = Math.max(dp[i & 1][j], dp[i & 1][j - c[i]] + c[i]);
					else dp[(i + 1) & 1][j] = dp[i & 1][j];
				}
			}
			System.out.println(Math.abs(dp[n & 1][half] - (sum - dp[n & 1][half])));
		}
	}

	void solve2() {
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int sum = 0;
			int[] c = new int[n];
			for (int i = 0; i < n; i++) {
				c[i] = sc.nextInt();
				sum += c[i];
			}
			boolean[] dp = new boolean[sum + 1];
			dp[0] = true;
			for (int i = 0; i < n; i++) {
				for (int j = sum; j >= 0; j--) {
					if (dp[j] && j + c[i] <= sum) dp[j + c[i]] = true;
				}
			}
			int min = Integer.MAX_VALUE / 10;
			for (int i = 0; i <= sum; i++) {
				if (dp[i]) min = Math.min(min, Math.abs(i - (sum - i)));
			}
			System.out.println(min);
		}
	}

	public static void main(String[] args) {
		new DividingCoins().solve2();
	}
}
