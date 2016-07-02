import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Bipartite {
	Scanner sc = new Scanner(System.in);
	int n, m;
	int[] color;
	Set<Integer> l[];
	List<Integer> A, B;

	@SuppressWarnings("unchecked")
	void run() {
		n = sc.nextInt();
		m = sc.nextInt();
		l = new HashSet[n];
		A = new ArrayList<>();
		B = new ArrayList<>();
		color = new int[n];
		for (int i = 0; i < n; i++) l[i] = new HashSet<>();
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt() - 1;
			int t = sc.nextInt() - 1;
			l[s].add(t);
			l[t].add(s);
		}
		for (int i = 0; i < n; i++) {
			if (color[i] == 0) {
				if (!isBipartite(i, 1)) {
					System.out.println("Not Bipartite");
					return;
				}
			}
		}
		System.out.println("Bipartite");
	}

	boolean isBipartite(int v, int c) {
		color[v] = c;
		for (Integer next : l[v]) {
			if (color[next] == c) return false;
			if (color[next] == 0 && !isBipartite(next, -c)) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new Bipartite().run();
	}
}
