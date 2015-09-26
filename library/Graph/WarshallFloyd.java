public class WarshallFloyd {
	int[][] dist;
	int n;

	void run() {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// i -> k -> j とkを経由し距離が短くなる場合は更新
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
}

