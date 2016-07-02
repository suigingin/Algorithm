import java.util.Arrays;
import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);
	int N, M;
	boolean[][] order;
	long[][] memo;

	void run() {
		N = sc.nextInt();
		M = sc.nextInt();
		order = new boolean[N][N];
		memo = new long[N][1 << N];
		for (int i = 0; i < N; i++) Arrays.fill(memo[i], -1);
		for (int i = 0; i < M; i++) order[sc.nextInt() - 1][sc.nextInt() - 1] = true;
		System.out.println(bitDP(0, 0));
	}

	long bitDP(int v, int mask) {
		if (memo[v][mask] != -1) return memo[v][mask];
		if (mask == (1 << N) - 1) return 1;
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			if ((mask & 1 << i) != 0) continue;
			boolean ok = true;
			for (int j = 0; j < N; j++) {
				if ((mask & 1 << j) > 0 && order[i][j]) {
					ok = false;
					break;
				}
			}
			if (ok) cnt += bitDP(i, mask | 1 << i);
		}
		return memo[v][mask] = cnt;
	}

	public static void main(String[] args) {
		new D().run();
	}
}
