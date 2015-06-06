import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class POJ_2236 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int D = sc.nextInt();
		int[] x = new int[N];
		int[] y = new int[N];
		boolean[] fix = new boolean[N];
		for (int i = 0; i < N; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		ArrayList<Integer> connect[] = new ArrayList[N];
		for (int i = 0; i < N; i++) connect[i] = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				double d = Math.hypot(x[i] - x[j], y[i] - y[j]);
				if (d <= D) {
					connect[i].add(j);
					connect[j].add(i);
				}
			}
		}
		init(N);
		StringBuilder out = new StringBuilder();
		while (sc.hasNext()) {
			String s = sc.next();
			if (s.equals("O")) {
				int p = sc.nextInt() - 1;
				fix[p] = true;
				for (int near : connect[p]) {
					if (fix[near]) union(p, near);
				}
			} else {
				int p = sc.nextInt() - 1;
				int q = sc.nextInt() - 1;
				out.append(fix[p] && fix[q] && same(p, q) ? "SUCCESS\n" : "FAIL\n");
			}
		}
		System.out.print(out);
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
		if (par[x] < 0) {
			return x;
		} else {
			return par[x] = find(par[x]);
		}
	}

	boolean same(int x, int y) {
		return find(x) == find(y);
	}

	public static void main(String[] args) {
		new POJ_2236().run();
	}
}
