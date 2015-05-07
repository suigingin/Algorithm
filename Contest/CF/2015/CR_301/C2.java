import java.util.LinkedList;
import java.util.Scanner;

public class C2 {
	Scanner sc = new Scanner(System.in);
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] v = new int[n][m];
		char[][] f = new char[n][m];
		for (int i = 0; i < n; i++) {
			String in = sc.next();
			for (int j = 0; j < m; j++) {
				f[i][j] = in.charAt(j);
				v[i][j] = f[i][j] == '.' ? 2 : 1;
			}
		}
		int sh = sc.nextInt() - 1;
		int sw = sc.nextInt() - 1;
		int th = sc.nextInt() - 1;
		int tw = sc.nextInt() - 1;

		LinkedList<Pair> que = new LinkedList<Pair>();
		que.add(new Pair(sh, sw));
		v[sh][sw] = 2;
		while (!que.isEmpty()) {
			Pair p = que.poll();
			if (p.h == th && p.w == tw && v[th][tw] == 1) {
				System.out.println("YES");
				return;
			}
			if (v[p.h][p.w] == 1) {
				continue;
			}
			v[p.h][p.w]--;
			for (int i = 0; i < 4; i++) {
				int nh = p.h + dy[i];
				int nw = p.w + dx[i];
				if (inner(nh, nw, n, m)) {
					que.push(new Pair(nh, nw));
				}
			}
		}
		System.out.println("NO");
	}

	class Pair {

		int h;
		int w;

		public Pair(int h, int w) {
			super();
			this.h = h;
			this.w = w;
		}
	}

	public static void main(String[] args) {
		new C2().run();
	}

	boolean inner(int h, int w, int limH, int limW) {
		return 0 <= h && h < limH && 0 <= w && w < limW;
	}
}
