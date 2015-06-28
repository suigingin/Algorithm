import java.util.ArrayList;
import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);
	final int MOD = 1000000007;
	
	ArrayList<Integer>[] tree;
	boolean[] v;
	int[] a;
	int n, d;

	void run() {

		d = sc.nextInt();
		n = sc.nextInt();
		a = new int[n];
		tree = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			tree[i] = new ArrayList<Integer>();
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n - 1; i++) {
			int s = sc.nextInt() - 1;
			int t = sc.nextInt() - 1;
			tree[s].add(t);
			tree[t].add(s);
		}
		long cnt = 0;
		for (int i = 0; i < n; i++) {
			v = new boolean[n];
			cnt = (cnt + dfs(i, i)) % MOD;
		}
		System.out.println(cnt);
	}

	long dfs(int u, int root) {
		v[u] = true;
		long res = 1;
		for (int next : tree[u]) {
			if (!v[next]) {
				if (a[next] < a[root] || a[next] > a[root] + d) continue;
				if (a[next] == a[root] && next < root) continue;
				res = (res * (dfs(next, root) + 1)) % MOD;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		new D().run();
	}
}
