import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int q = sc.nextInt();
		Pos[][] p = new Pos[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				p[i][j] = new Pos(i, j, 0);
			}
		}
		while (q-- > 0) {
			int t = sc.nextInt();
			if (t == 1 || t == 2) {
				int d = sc.nextInt() - 1;
				if (t == 1) {
					Pos tmp = p[d][0];
					for (int i = 0; i < m - 1; i++) p[d][i] = p[d][i + 1];
					p[d][m - 1] = tmp;
				} else {
					Pos tmp = p[0][d];
					for (int i = 0; i < n - 1; i++) p[i][d] = p[i + 1][d];
					p[n - 1][d] = tmp;
				}
			} else {
				int r = sc.nextInt() - 1;
				int c = sc.nextInt() - 1;
				int v = sc.nextInt();
				p[r][c].v = v;
			}
		}
		int[][] out = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				out[p[i][j].h][p[i][j].w] = p[i][j].v;
			}
		}
		
		StringBuilder o = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) o.append(out[i][j] +" ");
			o.append("\n");
		}
		System.out.print(o);
	}

	class Pos {
		int h, w, v;

		public Pos(int h, int w, int v) {
			super();
			this.h = h;
			this.w = w;
			this.v = v;
		}
	}

	public static void main(String[] args) {
		new C().run();
	}
}
