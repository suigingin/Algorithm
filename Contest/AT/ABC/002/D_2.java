import java.util.Scanner;

public class D_2 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int M = sc.nextInt();
		int max = 0;
		boolean[][] g = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			g[a][b] = g[b][a] = true;
		}
		for (int S = 0; S < 1 << N; S++) {
			boolean ok = true;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (j == k) continue;
					if ((S >> j & S >> k & 1) == 1 && !g[j][k]) ok = false;
				}
			}
			if (ok) max = Math.max(max, Integer.bitCount(S));
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		new D_2().run();
	}
}
