import java.util.Scanner;

public class Dollars {
	Scanner sc = new Scanner(System.in);

	void run() {
		int[] c = { 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000 };
		int M = 30000;
		long[] dp = new long[M + 1];
		dp[0] = 1;
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j <= M; j++) {
				if (j + c[i] <= M) dp[j + c[i]] += dp[j];
			}
		}
		for (;;) {
			double d = sc.nextDouble();
			if (d == 0) return;
			d += 1e-9;
			String s = String.valueOf(d);
			if (d < 100) s = " " + s;
			if (d < 10)  s = " " + s;
			System.out.print(s.substring(0,6));
			System.out.printf("%17d\n", dp[(int) (d * 100)]);
		}
	}

	public static void main(String[] args) {
		new Dollars().run();
	}
}
