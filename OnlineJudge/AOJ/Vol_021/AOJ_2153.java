import java.util.LinkedList;
import java.util.Scanner;

public class AOJ_2153 {
	Scanner sc = new Scanner(System.in);
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };

	void run() {
		for (;;) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			if ((w | h) == 0) {
				return;
			}
			char[][] f1 = new char[h][w];
			char[][] f2 = new char[h][w];
			int sw1, sh1, sw2, sh2;
			sw1 = sh1 = sw2 = sh2 = 0;
			for (int i = 0; i < h; i++) {
				String in1 = sc.next();
				String in2 = sc.next();
				for (int j = 0; j < w; j++) {
					f1[i][j] = in1.charAt(j);
					f2[i][j] = in2.charAt(j);
					if (f1[i][j] == 'L') {
						sw1 = j;
						sh1 = i;
					}
					if (f2[i][j] == 'R') {
						sw2 = j;
						sh2 = i;
					}
				}
			}
			boolean[][][][] visit = new boolean[h][w][h][w];
			boolean ok = false;
			visit[sh1][sw1][sh2][sw2] = true;
			LinkedList<Pos> que = new LinkedList<Pos>();
			que.add(new Pos(sh1, sw1, sh2, sw2));
			while (!que.isEmpty()) {
				Pos now = que.poll();
				if (f1[now.h1][now.w1] == '%' && f2[now.h2][now.w2] == '%') {
					ok = true;
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nh1 = now.h1 + dy[i];
					int nw1 = now.w1 + dx[i];
					int nh2 = now.h2 + dy[i];
					int nw2 = now.w2 + (dx[i] * -1);
					if (!inner(nh1, nw1, h, w) || f1[nh1][nw1] == '#') {
						nh1 = now.h1;
						nw1 = now.w1;
					}
					if (!inner(nh2, nw2, h, w) || f2[nh2][nw2] == '#') {
						nh2 = now.h2;
						nw2 = now.w2;
					}
					if ((f1[nh1][nw1] != '%' && f2[nh2][nw2] == '%')
							|| (f1[nh1][nw1] == '%' && f2[nh2][nw2] != '%')) {
						continue;
					}
					if (!visit[nh1][nw1][nh2][nw2]) {
						visit[nh1][nw1][nh2][nw2] = true;
						que.add(new Pos(nh1, nw1, nh2, nw2));
					}
				}
			}
			System.out.println(ok ? "Yes" : "No");
		}
	}

	class Pos {
		int w1;
		int h1;
		int w2;
		int h2;

		public Pos(int h1, int w1, int h2, int w2) {
			super();
			this.h1 = h1;
			this.w1 = w1;
			this.h2 = h2;
			this.w2 = w2;
		}
	}

	public static void main(String[] args) {
		new AOJ_2153().run();
	}

	boolean inner(int h, int w, int limH, int limW) {
		return 0 <= h && h < limH && 0 <= w && w < limW;
	}
}
