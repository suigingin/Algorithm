import java.util.LinkedList;

public class POJ_2251 {
	MyScanner sc = new MyScanner();
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };
	int[] dz = { 1, -1 };

	void run() {
		for (;;) {
			int L = sc.nextInt();
			int R = sc.nextInt();
			int C = sc.nextInt();
			if ((L | R | C) == 0) {
				return;
			}
			char[][][] f = new char[L][R][C];
			int[][][] cost = new int[L][R][C];
			int sf, sh, sw, gf, gh, gw;
			sf = sh = sw = gh = gw = gf = 0;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String in = sc.next();
					for (int k = 0; k < C; k++) {
						f[i][j][k] = in.charAt(k);
						cost[i][j][k] = Integer.MAX_VALUE;
						if (f[i][j][k] == 'S') {
							sf = i;
							sh = j;
							sw = k;
						}
						if (f[i][j][k] == 'E') {
							gf = i;
							gh = j;
							gw = k;
						}
					}
				}
			}
			LinkedList<Info> que = new LinkedList<Info>();
			que.add(new Info(sf, sh, sw));
			cost[sf][sh][sw] = 0;
			while (!que.isEmpty()) {
				Info now = que.poll();
				for (int i = 0; i < 4; i++) {
					int nexth = now.h + dy[i];
					int nextw = now.w + dx[i];
					if (inner(now.f, nexth, nextw, L, R, C) && f[now.f][nexth][nextw] != '#') {
						if (cost[now.f][now.h][now.w] + 1 < cost[now.f][nexth][nextw]) {
							cost[now.f][nexth][nextw] = cost[now.f][now.h][now.w] + 1;
							que.add(new Info(now.f, nexth, nextw));
						}
					}
				}
				for (int i = 0; i < 2; i++) {
					int nextf = now.f + dz[i];
					if (inner(nextf, now.h, now.w, L, R, C)	&& f[nextf][now.h][now.w] != '#') {
						if (cost[now.f][now.h][now.w] + 1 < cost[nextf][now.h][now.w]) {
							cost[nextf][now.h][now.w] = cost[now.f][now.h][now.w] + 1;
							que.add(new Info(nextf, now.h, now.w));
						}
					}
				}
			}
			if (cost[gf][gh][gw] == Integer.MAX_VALUE) {
				System.out.println("Trapped!");
			} else {
				System.out.println("Escaped in " + cost[gf][gh][gw]	+ " minute(s).");
			}
		}
	}

	class Info {
		int f;
		int h;
		int w;

		public Info(int f, int h, int w) {
			super();
			this.f = f;
			this.h = h;
			this.w = w;
		}
	}

	public static void main(String[] args) {
		new POJ_2251().run();
	}

	boolean inner(int f, int h, int w, int limF, int limH, int limW) {
		return 0 <= f && f < limF && 0 <= h && h < limH && 0 <= w && w < limW;
	}

	class MyScanner {
		int nextInt() {
			try {
				int c = System.in.read();
				while (c != '-' && (c < '0' || '9' < c))
					c = System.in.read();
				if (c == '-')
					return -nextInt();
				int res = 0;
				do {
					res *= 10;
					res += c - '0';
					c = System.in.read();
				} while ('0' <= c && c <= '9');
				return res;
			} catch (Exception e) {
				return -1;
			}
		}

		String next() {
			try {
				StringBuilder res = new StringBuilder("");
				int c = System.in.read();
				while (Character.isWhitespace(c))
					c = System.in.read();
				do {
					res.append((char) c);
				} while (!Character.isWhitespace(c = System.in.read()));
				return res.toString();
			} catch (Exception e) {
				return null;
			}
		}
	}
}
