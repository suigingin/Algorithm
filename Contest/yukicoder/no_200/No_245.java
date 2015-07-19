import java.util.Scanner;

public class No_245 {
	Scanner sc = new Scanner(System.in);

	int N;
	Point[][] p;

	void run() {
		N = sc.nextInt();
		p = pointArray(N);
		int max = 1;
		for (int i = 0; i < N; i++) {
			Point o1 = p[i][0];
			Point o2 = p[i][1];
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				Point p1 = p[j][0];
				Point p2 = p[j][1];
				max = Math.max(max, crossCnt(o1, p1));
				max = Math.max(max, crossCnt(o1, p2));
				max = Math.max(max, crossCnt(o2, p1));
				max = Math.max(max, crossCnt(o2, p2));
			}
		}
		System.out.println(max);
	}

	int crossCnt(Point s, Point t) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (lineCross(s, t, p[i][0], p[i][1])) cnt++;
		}
		return cnt;
	}

	// 直線p1->p2と線分p3->p4が交わるかどうか判定
	// p1 != p2 でなければ破綻することに注意
	boolean lineCross(Point p1, Point p2, Point p3, Point p4) {
		if (p1.x == p2.x && p1.y == p2.y) return false;
		int a = (p1.x - p2.x) * (p3.y - p1.y) + (p1.y - p2.y) * (p1.x - p3.x);
		int b = (p1.x - p2.x) * (p4.y - p1.y) + (p1.y - p2.y) * (p1.x - p4.x);
		return a * b <= 0;
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

	public Point[][] pointArray(int n) {
		Point[][] res = new Point[n][2];
		for (int i = 0; i < n; i++) {
			res[i][0] = new Point(sc.nextInt(), sc.nextInt());
			res[i][1] = new Point(sc.nextInt(), sc.nextInt());
		}
		return res;
	}

	public static void main(String[] args) {
		new No_245().run();
	}
}
