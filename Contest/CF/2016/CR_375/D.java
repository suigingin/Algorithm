import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };

	int n, m, k;
	char[][] f;
	int[][] c;
	boolean[][] v;

	void run() {
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		f = new char[n][m];
		c = new int[n][m];
		v = new boolean[n][m];
		List<Pair> l = new ArrayList<>();
		for (int i = 0; i < n; i++) f[i] = sc.next().toCharArray();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (f[i][j] == '.' && !v[i][j]) {
					l.add(new Pair(dfs(i, j), i, j));
				}
			}
		}
		int lake = 0;
		Collections.sort(l);
		for (int i = 0; i < l.size(); i++) if (l.get(i).c < 1000) lake++;

		int cnt = 0;
		int id = 0;
		v = new boolean[n][m];
		while (lake-- > k) {
			dfs2(l.get(id).h, l.get(id).w);
			cnt += l.get(id).c;
			id++;
		}
	
		System.out.println(cnt);
		for (int i = 0; i < n; i++) System.out.println(String.valueOf(f[i]));
	}


	int dfs(int h, int w) {
		int cnt = 1;
		v[h][w] = true;
		for (int i = 0; i < 4; i++) {
			int nh = h + dy[i];
			int nw = w + dx[i];
			if (!inner(nh, nw, n, m)) cnt += 1000;
			else if (f[nh][nw] == '.' && !v[nh][nw]) cnt += dfs(nh, nw);
		}
		return cnt;
	}

	void dfs2(int h, int w) {
		v[h][w] = true;
		f[h][w] = '*';
		for (int i = 0; i < 4; i++) {
			int nh = h + dy[i];
			int nw = w + dx[i];
			if (inner(nh, nw, n, m) && f[nh][nw] == '.' && !v[nh][nw]) dfs2(nh, nw);
		}
	}

	class Pair implements Comparable<Pair> {

		int c;
		int h;
		int w;

		public Pair(int c, int h, int w) {
			super();
			this.c = c;
			this.h = h;
			this.w = w;
		}

		@Override
		public int compareTo(Pair arg0) {
			return this.c - arg0.c;
		}

	}

	public static void main(String[] args) {
		new D().run();
	}

	boolean inner(int h, int w, int limH, int limW) {
		return 0 <= h && h < limH && 0 <= w && w < limW;
	}
}
