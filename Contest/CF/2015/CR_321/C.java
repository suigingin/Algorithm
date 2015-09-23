import java.util.ArrayList;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	int n, m, cnt;
	int[] a;
	boolean[] v;
	ArrayList<Integer>[] g;

	@SuppressWarnings("unchecked")
	void run() {
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		v = new boolean[n];
		g = new ArrayList[n];
		for (int i = 0; i < n; i++) g[i] = new ArrayList<Integer>();
		for (int i = 0; i < n - 1; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			g[s - 1].add(t - 1);
			g[t - 1].add(s - 1);
		}
		cnt = 0;
		dfs(0, a[0]);
		System.out.println(cnt);
	}

	void dfs(int now, int cat) {
		v[now] = true;
		if (g[now].size() == 1 && now != 0) {
			cnt++;
			return;
		}
		for (Integer next : g[now]) {
			if (!v[next]) {
				if (a[now] == 1 && a[next] + cat <= m) dfs(next, cat + a[next]);
				else if (a[now] == 0) dfs(next, a[next]);
			}
		}
	}

	public static void main(String[] args) {
		new C().run();
	}
}
