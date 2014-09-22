import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {

	Scanner sc = new Scanner(System.in);
	int M = 10000;

	void run() {
		int n = sc.nextInt(); // node
		int m = sc.nextInt(); // edge

		int start = sc.nextInt();
		int terminal = sc.nextInt();

		int graph[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(graph[i], M);
		}
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			graph[s][t] = sc.nextInt();
		}

		// Dijkstra
		int len[] = new int[n]; // minimum graphance
		boolean v[] = new boolean[n]; // decision flag
		for (int i = 0; i < n; i++) {
			len[i] = M;
		}
		len[start] = 0;
		for (int i = 0; i < n; i++) {
			// search minimum neighbor node
			int p = 0;
			int min = M;
			for (int j = 0; j < n; j++) {
				if (!v[j] && len[j] < min) {
					p = j;
					min = len[j];
				}
			}
			v[p] = true;
			for (int j = 0; j < n; j++) {
				if ((len[p] + graph[p][j]) < len[j]) {
					len[j] = len[p] + graph[p][j];
				}
			}
		}
		System.out.println(len[terminal]);
	}

	public static void main(String[] args) {
		new Dijkstra().run();
	}
}
