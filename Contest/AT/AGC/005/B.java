import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class B {
	Scanner sc = new Scanner(System.in);

	void solve2() {
		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) p[sc.nextInt() - 1] = i;
		TreeSet<Integer> set = new TreeSet<>();
		set.add(-1);
		set.add(n);
		long cnt = 0;
		for (int i = 0; i < n; i++) {
			set.add(p[i]);
			int next = set.higher(p[i]);
			int prev = set.lower(p[i]);
			cnt += (p[i] - prev) * (long) (next - p[i]) * (i + 1);
		}
		System.out.println(cnt);
	}

	void solve1() {
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			b[a[i] - 1] = i;
		}
		long cnt = 0;

		UnionFind uf = new UnionFind();
		uf.init(N);

		for (int i = N - 1; i >= 0; i--) {
			int pos = b[i];
			long g1 = 1;
			long g2 = 1;
			if (pos + 1 < N && a[pos] < a[pos + 1]) {
				g1 += uf.getGroupSize(pos + 1);
				uf.union(pos, pos + 1);
			}
			if (pos - 1 >= 0 && a[pos] < a[pos - 1]) {
				g2 += uf.getGroupSize(pos - 1);
				uf.union(pos, pos - 1);
			}
			cnt += a[pos] * (g1 * g2);
		}

		System.out.println(cnt);
	}

	public class UnionFind {

		int[] par;
		int[] rank;
		int groupCnt;

		void init(int n) {
			groupCnt = n;
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
			groupCnt--;
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

		int getGroupSize(int x) {
			return -par[find(x)];
		}
	}

	public static void main(String[] args) {
		new B().solve2();
	}
}
