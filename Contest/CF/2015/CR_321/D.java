import java.util.Arrays;
import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);
	int n, m, k;
	long[] a;
	long[][] memo, add;

	void run() {
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		add = new long[n][n];
		memo = new long[n][1 << n];
		a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
			Arrays.fill(memo[i], -1);
		}
		for (int i = 0; i < k; i++) add[sc.nextInt() - 1][sc.nextInt() - 1] = sc.nextLong();

		long max = 0;
		for (int i = 0; i < n; i++) max = Math.max(max, tsp(i, 1 << i) + a[i]);
		System.out.println(max);
	}

	long tsp(int v, int mask) {
		if (memo[v][mask] != -1)         return memo[v][mask];
		if (Integer.bitCount(mask) == m) return 0;

		long res = 0;
		for (int i = 0; i < n; i++) {
			if ((mask & (1 << i)) != 0) continue;
			res = Math.max(res, a[i] + tsp(i, mask | (1 << i)) + add[i][v]);
		}
		return memo[v][mask] = res;
	}

	public static void main(String[] args) {
		new D().run();
	}
}
