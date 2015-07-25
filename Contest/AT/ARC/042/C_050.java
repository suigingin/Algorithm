import java.util.Scanner;

public class C_050 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int P = sc.nextInt();
		int[] a = new int[N]; // weight
		int[] b = new int[N]; // value
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}

		// sを選び、a[s]以上の重さから回収する
		int ans = 0;
		for (int s = 0; s < N; s++) {
			int max = 0;
			int[][] dp = new int[N + 1][P + 1];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= P; j++) {
					if (i == s || a[i] < a[s] || j - a[i] < 0) dp[i + 1][j] = dp[i][j];
					else dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - a[i]] + b[i]);
					max = Math.max(max, dp[i + 1][j]);
				}
			}
			ans = Math.max(ans, max + b[s]);
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new C_050().run();
	}
}
