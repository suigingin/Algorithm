import java.util.Arrays;

public class Tsp {
	Scanner sc = new Scanner(System.in);
	int N, M;
	int INF = Integer.MAX_VALUE / 2;
	int[][] graph, memo;

	void run() {
		N = sc.nextInt(); // edge number
		M = sc.nextInt(); // vertex number
		graph = new int[N][N];
		memo = new int[N][1 << N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(graph[i], INF);
			Arrays.fill(memo[i], -1);
		}
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			int cost = sc.nextInt();
			graph[s][t] = graph[t][s] = cost;
		}
		System.out.println(tsp(0, 1));
	}

	int tsp(int v, int mask) {
		if (memo[v][mask] != -1)  return memo[v][mask];
		if (mask == (1 << N) - 1) return graph[v][0];

		int res = INF;
		for (int i = 0; i < N; i++) {
			if ((mask & (1 << i)) != 0) continue;
			res = Math.min(res, graph[v][i] + tsp(i, mask | (1 << i)));
		}
		return memo[v][mask] = res;
	}

	public static void main(String[] args) {
		new Tsp().run();
	}
}
