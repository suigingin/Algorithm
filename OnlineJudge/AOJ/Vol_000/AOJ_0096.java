import java.util.Scanner;

public class AOJ_0096 {
	Scanner sc = new Scanner(System.in);

	void run1() {
		int[][] dp = new int[4][4001];
		for (int i = 0; i <= 1000; i++) dp[0][i] = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <= 4000; j++) {
				for (int k = 0; k <= 1000; k++) {
					if (j + k <= 4000) dp[i + 1][j + k] += dp[i][j];
				}
			}
		}
		while (sc.hasNext()) System.out.println(dp[3][sc.nextInt()]);
	}

	void run2() {
		int[] cnt1 = new int[2001];
		int[] cnt2 = new int[4001];
		for (int i = 0; i <= 1000; i++) for (int j = 0; j <= 1000; j++) cnt1[i + j]++;
		for (int i = 0; i <= 2000; i++) for (int j = 0; j <= 2000; j++) cnt2[i + j] += cnt1[i] * cnt1[j];
		while (sc.hasNext()) System.out.println(cnt2[sc.nextInt()]);
	}

	public static void main(String[] args) {
		new AOJ_0096().run2();
	}
}
