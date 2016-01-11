import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };

	int N, M, sN, sM;
	char[][] f;
	boolean[][] v;
	boolean ok;

	void run() {
		N = sc.nextInt();
		M = sc.nextInt();
		for (int i = 0; i < N; i++) f[i] = sc.next().toCharArray();
		v = new boolean[N][M];
		ok = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!v[i][j]) {
					sN = i;
					sM = j;
					dfs(i, j, i, j, f[i][j]);
				}
			}
		}
		System.out.println(ok ? "Yes" : "No");
	}

	void dfs(int pN, int pM, int n, int m, char c) {
		v[n][m] = true;
		for (int i = 0; i < 4; i++) {
			int nextN = n + dy[i];
			int nextM = m + dx[i];
			if (!inner(nextN, nextM, N, M) || (nextN == pN && nextM == pM) || f[nextN][nextM] != c) continue;
			if (v[nextN][nextM]) ok = true;
			if (!v[nextN][nextM]) dfs(n, m, nextN, nextM, c);
		}
	}

	public static void main(String[] args) {
		new B().run();
	}

	boolean inner(int h, int w, int limH, int limW) {
		return 0 <= h && h < limH && 0 <= w && w < limW;
	}
}
