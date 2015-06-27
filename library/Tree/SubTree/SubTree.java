import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SubTree {
	Scanner sc = new Scanner(System.in);
	ArrayList<Integer>[] tree;
	boolean[] v;
	int N;

	void run() {

		N = sc.nextInt();
		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) tree[i] = new ArrayList<Integer>();
		for (int i = 0; i < N - 1; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			tree[s].add(t);
			tree[t].add(s);
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			v = new boolean[N];
			cnt += dfs(i, i);
		}
		System.out.println(cnt);
	}

	int dfs(int u, int root) {
		v[u] = true;
		int res = 1;
		for (int next : tree[u]) {
			if (!v[next]) {
				if (next < u) continue;
				res = res * (dfs(next, root) + 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		new SubTree().run();
	}
}
