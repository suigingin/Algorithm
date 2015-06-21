import java.util.ArrayList;
import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);

	@SuppressWarnings("unchecked")
	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[][] c = new boolean[n][n];
		ArrayList<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) graph[i] = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt() - 1;
			int t = sc.nextInt() - 1;
			c[s][t] = true;
			graph[s].add(t);
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i == j) continue;
				int path = 0;
				for (int k = 0; k < graph[i].size(); k++) {
					if (c[graph[i].get(k)][j]) path++;
				}
				cnt += path * (path - 1) / 2;
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new D().run();
	}
}
