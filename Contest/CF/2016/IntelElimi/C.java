import java.util.Arrays;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	int n;
	int[] a, o;
	boolean[] f;
	long[] res;

	void run() {
		n = sc.nextInt();
		a = new int[n];
		o = new int[n];
		f = new boolean[n];
		res = new long[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		for (int i = 0; i < n; i++) o[i] = sc.nextInt() - 1;
		solve2();
	}

	void solve1() {
		int[] l = new int[n];
		int[] r = new int[n];
		long[] m = new long[n];
		for (int i = 0; i < n; i++) {
			m[i] = a[i];
			l[i] = i;
			r[i] = i;
		}
		long max = 0;
		for (int i = n - 1; i >= 0; i--) {
			res[i] = max;
			f[o[i]] = true;
			long rsum = 0;
			long lsum = 0;
			int li = o[i];
			int ri = o[i];
			if (o[i] + 1 < n && f[o[i] + 1]) {
				rsum += m[r[o[i] + 1]];
				ri = r[o[i] + 1];
			}
			if (o[i] - 1 >= 0 && f[o[i] - 1]) {
				lsum += m[l[o[i] - 1]];
				li = l[o[i] - 1];
			}

			r[li] = ri;
			l[ri] = li;
			long sum = a[o[i]] + rsum + lsum;
			m[ri] = m[li] = sum;
			max = Math.max(max, sum);
		}
		out();
	}

	void solve2() {
		UnionFind uf = new UnionFind();
		uf.init(n);
		long max = 0;
		for (int i = n - 1; i >= 0; i--) {
			res[i] = max;
			f[o[i]] = true;
			if (o[i] + 1 < n && f[o[i] + 1])  uf.union(o[i], o[i] + 1);
			if (o[i] - 1 >= 0 && f[o[i] - 1]) uf.union(o[i], o[i] - 1);
			max = Math.max(max, uf.sum[uf.find(o[i])]);
		}
		out();
	}

	public class UnionFind {

		int [] par;
		long[] sum;
		int[] rank;
		int groupCnt;

		void init(int n) {
			groupCnt = n;
			par = new int[n];
			rank = new int[n];
			sum = new long[n];
			Arrays.fill(par, -1);
			for (int i = 0; i < n; i++) sum[i] = a[i];
		}

		void union(int x, int y) {
			x = find(x);
			y = find(y);
			if (x == y) {
				return;
			}
			groupCnt--;
			if (rank[x] < rank[y]) {
				sum[y] += sum[x];
				par[y] += par[x];
				par[x] = y;
			} else {
				sum[x] += sum[y];
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

		int getGroupSize(int x) {
			return -par[find(x)];
		}

		int getGroupCnt() {
			return groupCnt;
		}
	}

	void out() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) sb.append(res[i] + "\n");
		System.out.print(sb);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
