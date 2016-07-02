import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class C {
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
				if (!dfs(i, 1)) {
					System.out.println(-1);
					return;
				}
			}
		}

		StringBuilder o = new StringBuilder();
		o.append(A.size() + "\n");
		for (int i = 0; i < A.size(); i++) o.append(A.get(i) + " ");
		o.append("\n" + B.size() + "\n");
		for (int i = 0; i < B.size(); i++) o.append(B.get(i) + " ");
		System.out.println(o);
	}

	boolean dfs(int v, int c) {
		if (c == 1) A.add(v + 1);
		else B.add(v + 1);
		color[v] = c;
		for (Integer nex : l[v]) {
			if (color[nex] == c) return false;
			if (color[nex] == 0 && !dfs(nex, -c)) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new C().run();
	}
}
