import java.util.Arrays;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void solve1() {
		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) p[i] = sc.nextInt();
		init(n);
		for (int i = 0; i < n; i++) {
			String r = sc.next();
			for (int j = 0; j < n; j++) {
				if (r.charAt(j) == '1') union(i, j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (p[i] > p[j] && same(i, j)) swap(p, i, j);
			}
		}
		out(p);
	}

	int[] par;
	int[] rank;

	void init(int n) {
		par = new int[n];
		rank = new int[n];
		Arrays.fill(par, -1);
	}

	void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) {
			return;
		}
		if (rank[x] < rank[y]) {
			par[y] += par[x];
			par[x] = y;
		} else {
			par[x] += par[y];
			par[y] = x;
			if (rank[x] == rank[y]) {
				rank[x]++;
			}
		}
	}

	int find(int x) {
		if (par[x] < 0) return x;
		else return par[x] = find(par[x]);
	}

	boolean same(int x, int y) {
		return find(x) == find(y);
	}

	void solve2() {
		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) p[i] = sc.nextInt();

		boolean[][] f = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String r = sc.next();
			for (int j = 0; j < n; j++) {
				f[i][j] = r.charAt(j) == '1' ? true : false;
			}
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					f[i][j] |= f[i][k] && f[k][j];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (p[i] > p[j] && f[i][j]) swap(p, i, j);
			}
		}
		out(p);
	}

	public static void main(String[] args) {
		new B().solve2();
	}

	void swap(int[] x, int a, int b) {
		int tmp = x[a];
		x[a] = x[b];
		x[b] = tmp;
	}

	void out(int[] a) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			out.append((i == 0 ? "" : " ") + a[i]);
		}
		System.out.println(out);
	}
}
