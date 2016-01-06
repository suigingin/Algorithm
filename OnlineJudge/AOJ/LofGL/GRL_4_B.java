import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GRL_4_B {
	Scanner sc = new Scanner(System.in);

	int N, M;
	int[] indeg;
	boolean[] V;
	ArrayList<Integer>[] G;
	ArrayList<Integer> res;

	@SuppressWarnings("unchecked")
	void run() {
		N = sc.nextInt();
		M = sc.nextInt();
		indeg = new int[N];
		G = new ArrayList[N];
		V = new boolean[N];
		res = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) G[i] = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			G[s].add(t);
			indeg[t]++;
		}
		topologicalSort();
	}

	void topologicalSort() {
		for (int u = 0; u < N; u++) {
			if (indeg[u] == 0 && !V[u]) {
				bfs(u);
			}
		}
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < N; i++) out.append(res.get(i) + "\n");
		System.out.print(out);
	}

	void bfs(int s) {
		LinkedList<Integer> que = new LinkedList<Integer>();
		que.add(s);
		V[s] = true;
		while (!que.isEmpty()) {
			int u = que.poll();
			res.add(u);
			for (int i = 0; i < G[u].size(); i++) {
				int v = G[u].get(i);
				indeg[v]--;
				if (indeg[v] == 0 && !V[v]) {
					que.add(v);
					V[v] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		new GRL_4_B().run();
	}
}
