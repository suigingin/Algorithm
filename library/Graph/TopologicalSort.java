class TopologicalSort {
	int N, M, index;
	int[] indeg, res;
	boolean[] V;
	List<Integer> G[];

	public TopologicalSort(int n, int m, List<Integer> g[]) {
		super();
		N = n;
		M = m;
		G = g;
	}

	void init() {
		indeg = new int[N];
		V = new boolean[N];
		res = new int[N];
		index = 0;
		for (int i = 0; i < N; i++) {
			for (int e : G[i]) {
				indeg[e]++;
			}
		}
	}

	int[] execute() {
		for (int u = 0; u < N; u++) {
			if (indeg[u] == 0 && !V[u]) {
				bfs(u);
			}
		}
		return res;
	}

	void bfs(int s) {
		V[s] = true;
		LinkedList<Integer> que = new LinkedList<>();
		que.add(s);
		while (!que.isEmpty()) {
			int u = que.poll();
			res[index++] = u;
			for (int v : G[u]) {
				indeg[v]--;
				if (indeg[v] == 0 && !V[v]) {
					que.add(v);
					V[v] = true;
				}
			}
		}
	}
}
