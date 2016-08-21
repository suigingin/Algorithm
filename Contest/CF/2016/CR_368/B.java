import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	class Edge {
		int to, cost;
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	@SuppressWarnings("unchecked")
	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		boolean[] s = new boolean[n];
		List<Edge>[] l = new ArrayList[n];
		for (int i = 0; i < n; i++) l[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();
			l[a].add(new Edge(b, c));
			l[b].add(new Edge(a, c));
		}
		for (int i = 0; i < k; i++) s[sc.nextInt() - 1] = true;

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (!s[i]) continue;
			for (Edge e : l[i]) if (!s[e.to] && e.cost < res) res = e.cost;
		}
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
