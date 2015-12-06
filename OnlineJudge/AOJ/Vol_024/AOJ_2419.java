import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class AOJ_2419 {
	Scanner sc = new Scanner(System.in);
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };
	int[] dx2 = { 1, 0, 0, -1, 1, -1, -1, 1 };
	int[] dy2 = { 0, 1, -1, 0, 1, 1, -1, -1 };

	void run() {
		int w = sc.nextInt();
		int h = sc.nextInt();
		char[][] f = new char[h][w];
		int[][] hole = new int[h][w];
		for (int i = 0; i < h; i++) Arrays.fill(hole[i], 1);
		int num = 0;
		int sh = 0;
		int sw = 0;
		for (int i = 0; i < h; i++) {
			String in = sc.next();
			for (int j = 0; j < w; j++) {
				f[i][j] = in.charAt(j);
				if (f[i][j] == 'S') {
					sh = i;
					sw = j;
				}
				if (f[i][j] == 'M') f[i][j] = (char) (num++ + '0');
				if (f[i][j] == '#') {
					LinkedList<Info> que = new LinkedList<Info>();
					que.add(new Info(0, i, j));
					int cost = 3;
					while (cost != 0) {
						int s = que.size();
						for (int k = 0; k < s; k++) {
							Info now = que.poll();
							for (int l = 0; l < 8; l++) {
								int nh = now.h + dy2[l];
								int nw = now.w + dx2[l];
								if (inner(nh, nw, h, w) && hole[nh][nw] < cost) {
									hole[nh][nw] = cost;
									que.add(new Info(0, nh, nw));
								}
							}
						}
						cost--;
					}
				}
			}
		}

		LinkedList<Info> que = new LinkedList<Info>();
		int[][][] cost = new int[1 << num][h][w];
		for (int i = 0; i < 1 << num; i++) {
			for (int j = 0; j < h; j++) {
				Arrays.fill(cost[i][j], Integer.MAX_VALUE / 10);
			}
		}
		cost[0][sh][sw] = 0;
		que.add(new Info(0, sh, sw));
		int min = Integer.MAX_VALUE / 10;
		while (!que.isEmpty()) {
			Info now = que.poll();
			if (Character.isDigit(f[now.h][now.w])) {
				int m = Integer.valueOf(f[now.h][now.w] - '0');
				if (cost[now.bit][now.h][now.w] < cost[now.bit | (1 << m)][now.h][now.w]) {
					cost[now.bit | (1 << m)][now.h][now.w] = cost[now.bit][now.h][now.w];
					now.bit |= 1 << m;
				}
			}
			if (f[now.h][now.w] == 'G' && now.bit == (1 << num) - 1) {
				min = Math.min(min, cost[(1 << num) - 1][now.h][now.w]);
			}
			for (int i = 0; i < 4; i++) {
				int nh = now.h + dy[i];
				int nw = now.w + dx[i];
				if (inner(nh, nw, h, w) && f[nh][nw] != '#') {
					if (cost[now.bit][now.h][now.w] + hole[now.h][now.w] < cost[now.bit][nh][nw]) {
						cost[now.bit][nh][nw] = cost[now.bit][now.h][now.w] + hole[now.h][now.w];
						que.add(new Info(now.bit, nh, nw));
					}
				}
			}
		}
		System.out.println(min);
	}

	class Info {
		int bit;
		int h;
		int w;

		/**
		 * @param h
		 * @param w
		 */
		public Info(int bit, int h, int w) {
			super();
			this.bit = bit;
			this.h = h;
			this.w = w;
		}
	}

	public static void main(String[] args) {
		new AOJ_2419().run();
	}

	boolean inner(int h, int w, int limH, int limW) {
		return 0 <= h && h < limH && 0 <= w && w < limW;
	}
}
