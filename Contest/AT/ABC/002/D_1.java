import java.util.ArrayList;
import java.util.Scanner;

public class D_1 {
	Scanner sc = new Scanner(System.in);

	int N, M, max;
	boolean[][] g;

	void run() {
		N = sc.nextInt();
		M = sc.nextInt();
		g = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			g[a][b] = g[b][a] = true;
		}
		max = 0;
		dfs(0, new ArrayList<Integer>());
		System.out.println(max);
	}

	void dfs(int depth, ArrayList<Integer> l) {
		if (depth == N) {
			for (int i = 0; i < l.size(); i++) {
				for (int j = i + 1; j < l.size(); j++) {
					if (!g[l.get(i)][l.get(j)]) return;
				}
			}
			max = Math.max(max, l.size());
		} else {
			dfs(depth + 1, l);
			l.add(depth);
			dfs(depth + 1, l);
			l.remove(l.size() - 1);
		}
	}

	public static void main(String[] args) {
		new D_1().run();
	}
}
