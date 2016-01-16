import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class AOJ_0519 {
	Scanner sc = new Scanner(System.in);

	int N, M;
	int[] indeg;
	ArrayList<Integer>[] G;
	ArrayList<Integer> res;
	boolean[] V;
	boolean multi;

	@SuppressWarnings("unchecked")
	void run() {
		N = sc.nextInt();
		M = sc.nextInt();
		indeg = new int[N];
		G = new ArrayList[N];
		res = new ArrayList<Integer>();
		V = new boolean[N];
		multi = false;
		for (int i = 0; i < N; i++) G[i] = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			int v = sc.nextInt() - 1;
			int u = sc.nextInt() - 1;
			G[v].add(u);
			indeg[u]++;
		}

		topologicalSort();

		StringBuilder o = new StringBuilder();
		for (int i = 0; i < N; i++) o.append(res.get(i) + "\n");
		System.out.print(o);
		System.out.println(multi ? 1 : 0);
	}

	void topologicalSort() {
		for (int u = 0; u < N; u++) {
			if (indeg[u] == 0 && !V[u]) {
				bfs(u);
			}
		}
	}

	void bfs(int s) {
		V[s] = true;
		LinkedList<Integer> que = new LinkedList<Integer>();
		que.add(s);
		while (!que.isEmpty()) {
			int u = que.poll();
			res.add(u + 1);
			for (int i = 0; i < G[u].size(); i++) {
				int v = G[u].get(i);
				indeg[v]--;
				if (indeg[v] == 0 && !V[v]) {
					que.add(v);
					V[v] = true;
				}
			}
			if (que.size() > 1) multi = true;
		}
	}

	public static void main(String[] args) {
		new AOJ_0519().run();
	}
}
