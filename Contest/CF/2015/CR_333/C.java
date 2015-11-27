import java.util.Arrays;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);
	final int INF = Integer.MAX_VALUE / 1000;

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] rail = new int[n][n];
		int[][] road = new int[n][n];

		for (int i = 0; i < n; i++) Arrays.fill(road[i], 1);
		for (int i = 0; i < n; i++) Arrays.fill(rail[i], INF);
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt() - 1;
			int t = sc.nextInt() - 1;
			rail[s][t] = rail[t][s] = 1;
			road[s][t] = road[t][s] = INF;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					rail[i][j] = Math.min(rail[i][j], rail[i][k] + rail[k][j]);
					road[i][j] = Math.min(road[i][j], road[i][k] + road[k][j]);
				}
			}
		}
		if (road[0][n - 1] == INF || rail[0][n - 1] == INF) {
			System.out.println(-1);
			return;
		}
		System.out.println(road[0][n - 1] == 1 ? rail[0][n - 1] : road[0][n - 1]);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
