import java.util.LinkedList;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		String h = sc.next();
		String w = sc.next();

		for (int sh = 0; sh < n; sh++) {
			for (int sw = 0; sw < m; sw++) {
				boolean[][] v = new boolean[n][m];
				boolean check = true;
				v[sh][sw] = true;

				LinkedList<Pair> que = new LinkedList<Pair>();
				que.add(new Pair(sh, sw));
				while (!que.isEmpty()) {
					int size = que.size();
					for (int i = 0; i < size; i++) {
						Pair now = que.poll();
						char d1 = h.charAt(now.hh);
						char d2 = w.charAt(now.ww);
						Pair next1 = new Pair(now.hh + (d2 == 'v' ? 1 : -1), now.ww);
						Pair next2 = new Pair(now.hh, now.ww + (d1 == '>' ? 1 : -1));
						if (inner(next1.hh, next1.ww, n, m) && !v[next1.hh][next1.ww]) {
							v[next1.hh][next1.ww] = true;
							que.add(next1);
						}
						if (inner(next2.hh, next2.ww, n, m) && !v[next2.hh][next2.ww]) {
							v[next2.hh][next2.ww] = true;
							que.add(next2);
						}
					}
				}
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						check &= v[i][j];
					}
				}
				if (!check) {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");
	}

	class Pair {
		int hh;
		int ww;

		public Pair(int hh, int ww) {
			super();
			this.hh = hh;
			this.ww = ww;
		}
	}

	public static void main(String[] args) {
		new B().run();
	}

	boolean inner(int h, int w, int limH, int limW) {
		return 0 <= h && h < limH && 0 <= w && w < limW;
	}
}
