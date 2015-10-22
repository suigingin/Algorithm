import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinaryAppleTree {
	Scanner sc = new Scanner(System.in);

	int N, Q;
	ArrayList<Integer>[] g;
	int[][] apple, memo;

	@SuppressWarnings("unchecked")
	void run() {
		N = sc.nextInt();
		Q = sc.nextInt();
		apple = new int[N][N];
		memo = new int[N][N];
		g = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			g[i] = new ArrayList<Integer>();
			Arrays.fill(memo[i], -1);
		}
		for (int i = 0; i < N - 1; i++) {
			int s = sc.nextInt() - 1;
			int t = sc.nextInt() - 1;
			int a = sc.nextInt();
			g[s].add(t);
			g[t].add(s);
			apple[s][t] = apple[t][s] = a;
		}
		System.out.println(dfs(0, -1, Q));
	}

	int dfs(int cur, int prev, int rest) {
		if (rest <= 0) return 0;
		if (memo[cur][rest] != -1) return memo[cur][rest];

		int res = 0;
		for (int i = 0; i < g[cur].size(); i++) {
			for (int j = i + 1; j < g[cur].size(); j++) {
				if (g[cur].get(i) == prev || g[cur].get(j) == prev) continue;
				for (int k = 0; k <= rest; k++) {
					// 左右それぞれの子ノードへのブランチについてるリンゴ
					int lb = (k == 0) ? 0 : apple[cur][g[cur].get(i)];
					int rb = (k == rest) ? 0 : apple[cur][g[cur].get(j)];
					// 左右それぞれから回収できるリンゴの総和
					res = Math.max(res, lb + dfs(g[cur].get(i), cur, k - 1) + rb + dfs(g[cur].get(j), cur, rest - k - 1));
				}
			}
		}
		return memo[cur][rest] = res;
	}

	public static void main(String[] args) {
		new BinaryAppleTree().run();
	}
}
