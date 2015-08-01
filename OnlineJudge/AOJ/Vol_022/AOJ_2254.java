import java.util.Scanner;

public class AOJ_2254 {
	Scanner sc = new Scanner(System.in);
	int N;
	int[][] t, memo;

	void run() {
		for (;;) {
			N = sc.nextInt();
			if (N == 0) return;
			t = new int[N][N + 1];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N + 1; j++) {
					t[i][j] = sc.nextInt();
				}
			}
			memo = new int[N][1 << N];
			int min = Integer.MAX_VALUE / 2;
			for (int i = 0; i < N; i++) min = Math.min(min, t[i][0] + tsp(i, 1 << i));
			System.out.println(min);
		}
	}

	int tsp(int v, int mask) {
		if (memo[v][mask] != 0)    return memo[v][mask];
		if (mask == (1 << N) - 1)  return 0;

		int res = Integer.MAX_VALUE / 2;
		for (int i = 0; i < N; i++) {
			if ((mask & (1 << i)) != 0) continue;
			int s = t[i][0];
			for (int j = 0; j <= N; j++) {
				if (i != j && (mask & (1 << j)) != 0) s = Math.min(s, t[i][j + 1]);
			}
			res = Math.min(res, s + tsp(i, mask | 1 << i));
		}
		return memo[v][mask] = res;
	}

	public static void main(String[] args) {
		new AOJ_2254().run();
	}
}
