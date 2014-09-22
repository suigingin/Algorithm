import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Prim {
	Scanner sc = new Scanner(System.in);
	int M = 10000000;

	void run() {
		int n = sc.nextInt(); // edge
		int m = sc.nextInt(); // node
		int allCost = 0;
		int[][] cost = new int[n][n];
		int[] min = new int[n];
		boolean[] use = new boolean[n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(cost[i], M);
			cost[i][i] = 0;
		}
		Arrays.fill(min, M);
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			int c = sc.nextInt();
			cost[s][t] = cost[t][s] = c;
		}
		min[0] = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (true) {
			int v = -1;
			for (int j = 0; j < n; j++) {
				if (!use[j] && (v == -1 || min[v] > min[j])) {
					v = j;
				}
			}
			if (v == -1) {
				break;
			}
			if (min[v] != 0) {
				allCost += min[v];
				list.add(min[v]);
			}
			use[v] = true;
			for (int j = 0; j < n; j++) {
				if (!use[j] && cost[v][j] < min[j]) {
					min[j] = cost[v][j];
				}
			}
		}
		debug(list);
		System.out.println(allCost);
	}

	public static void main(String[] args) {
		new Prim().run();
	}

	void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
}

