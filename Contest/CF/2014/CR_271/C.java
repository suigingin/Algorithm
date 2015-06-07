import java.util.Arrays;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		while (n-- > 0) {
			Point[] p = new Point[4];
			Point[] o = new Point[4];
			for (int i = 0; i < 4; i++) {
				p[i] = new Point(sc.nextInt(), sc.nextInt());
				o[i] = new Point(sc.nextInt(), sc.nextInt());
			}
			int min = 100;
			for (int i = 0; i <= 3; i++) {
				for (int j = 0; j <= 3; j++) {
					for (int k = 0; k <= 3; k++) {
						for (int l = 0; l <= 3; l++) {
							int tot = i + j + k + l;
							int[] nx = new int[4];
							int[] ny = new int[4];
							int[] r = { i, j, k, l };
							for (int s = 0; s < 4; s++) {
								int[] rotated = rotate(p[s].x - o[s].x, p[s].y - o[s].y, r[s]);
								nx[s] = rotated[0] + o[s].x;
								ny[s] = rotated[1] + o[s].y;
							}
							if (isSquare(nx, ny)) min = Math.min(min, tot);
						}
					}
				}
			}
			System.out.println(min == 100 ? -1 : min);
		}
	}

	int[] rotate(int x, int y, int c) {
		if (c == 0) return new int[] { x, y };
		else if (c == 1) return new int[] { -y, x };
		else if (c == 2) return new int[] { -x, -y };
		else return new int[] { y, -x };
	}

	boolean isSquare(int[] xs, int[] ys) {
		long[] ds = new long[6];
		int at = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 4; j++) {
				ds[at] = (long)(xs[i] - xs[j]) * (xs[i] - xs[j]) + (ys[i] - ys[j]) * (ys[i] - ys[j]);
				at++;
			}
		}
		Arrays.sort(ds);
		if (ds[0] == 0) return false;
		return ds[0] == ds[3] && ds[4] == ds[5] && ds[4] == 2 * ds[0];
	}

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		new C().run();
	}
}
