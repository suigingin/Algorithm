import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);
	int n, m, cnt, from, to;
	boolean[][][] g;
	boolean[] v;

	void run() {
		n = sc.nextInt();
		m = sc.nextInt();
		g = new boolean[n][n][m];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			g[a][b][c] = true;
			g[b][a][c] = true;
		}
		int q = sc.nextInt();
		while (q-- > 0) {
			from = sc.nextInt() - 1;
			to = sc.nextInt() - 1;
			cnt = 0;
			for (int i = 0; i < m; i++) {
				v = new boolean[n];
				if (dfs(from, i)) cnt++;
			}
			System.out.println(cnt);
		}
	}

	boolean dfs(int now, int color) {
		v[now] = true;
		if (now == to) return true;
		boolean res = false;
		for (int i = 0; i < n; i++) {
			if (!v[i] && g[now][i][color]) {
				res |= dfs(i, color);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		new B().run();
	}
}
