import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		if (n >= m) {
			System.out.println("YES");
			return;
		}

		boolean[][] dp = new boolean[2][m];
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			for (int j = 0; j < m; j++) {
				if (dp[i & 1][j]) {
					dp[(i + 1) & 1][(j + a) % m] = true;
					dp[(i + 1) & 1][j] = true;
				}
			}
			dp[(i + 1) & 1][a % m] = true;
			if (dp[(i + 1) & 1][0]) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

	public static void main(String[] args) {
		new B().run();
	}
}
