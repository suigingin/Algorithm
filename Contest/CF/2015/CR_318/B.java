import java.util.ArrayList;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	@SuppressWarnings("unchecked")
	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer>[] g = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) g[i] = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			g[a].add(b);
			g[b].add(a);
		}
		int min = Integer.MAX_VALUE / 2;
		boolean[] used = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			int otherConnect = Integer.MAX_VALUE / 2;
			for (Integer ele2 : g[i]) {
				if (used[ele2]) continue;
				for (Integer ele3 : g[ele2]) {
					if (used[ele3] || ele3 == i) continue;
					if (g[ele3].contains(i)) otherConnect = Math.min(otherConnect, g[i].size() + g[ele2].size() + g[ele3].size() - 6);
				}
			}
			used[i] = true;
			min = Math.min(min, otherConnect);
		}
		System.out.println(min == Integer.MAX_VALUE / 2 ? -1 : min);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
