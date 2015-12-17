import java.util.Scanner;

public class AOJ_0541 {
	Scanner sc = new Scanner(System.in);

	void run() {
		for (;;) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			if ((H | W | N) == 0) return;
			int[][] f = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					f[i][j] = sc.nextInt();
				}
			}
			int[][] dp = new int[H][W];
			dp[0][0] = N - 1;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (dp[i][j] > 0) {
						if (dp[i][j] % 2 == 0) {
							if (i + 1 < H) dp[i + 1][j] += dp[i][j] / 2;
							if (j + 1 < W) dp[i][j + 1] += dp[i][j] / 2;
						} else {
							if (i + 1 < H) dp[i + 1][j] += (f[i][j] == 0 ? 1 : 0) + dp[i][j] / 2;
							if (j + 1 < W) dp[i][j + 1] += (f[i][j] == 1 ? 1 : 0) + dp[i][j] / 2;
						}
					}
				}
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (dp[i][j] % 2 == 1) f[i][j] ^= 1;
				}
			}
			int h = 0;
			int w = 0;
			while (true) {
				if (h == H || w == W) {
					System.out.println(++h + " " + ++w);
					break;
				}
				if (f[h][w] == 1) w++;
				else h++;
			}
		}
	}

	public static void main(String[] args) {
		new AOJ_0541().run();
	}
}
