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
