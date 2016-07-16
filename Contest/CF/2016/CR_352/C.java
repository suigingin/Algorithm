import java.util.Arrays;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		Point A = new Point(sc.nextDouble(), sc.nextDouble());
		Point B = new Point(sc.nextDouble(), sc.nextDouble());
		Point T = new Point(sc.nextDouble(), sc.nextDouble());
		int n = sc.nextInt();
		Point[] p = new Point[n];
		for (int i = 0; i < n; i++) p[i] = new Point(sc.nextDouble(), sc.nextDouble());
		double sum = 0;
		for (int i = 0; i < n; i++) sum += p[i].dist(T) * 2;
		Dist[] disA = new Dist[n];
		Dist[] disB = new Dist[n];
		for (int i = 0; i < n; i++) disA[i] = new Dist(p[i].dist(T) - p[i].dist(A), i);
		for (int i = 0; i < n; i++) disB[i] = new Dist(p[i].dist(T) - p[i].dist(B), i);
		Arrays.sort(disA);
		Arrays.sort(disB);
		double min = Double.MAX_VALUE;
		min = Math.min(min, sum - disA[0].dist);
		min = Math.min(min, sum - disB[0].dist);
		if (n >= 2) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if (disA[i].id != disB[j].id) min = Math.min(min, sum - disA[i].dist - disB[j].dist);
				}
			}
		}
		System.out.println(min);
	}

	class Dist implements Comparable<Dist> {
		double dist;
		int id;

		public Dist(double dist, int id) {
			super();
			this.dist = dist;
			this.id = id;
		}

		@Override
		public int compareTo(Dist o) {
			// TODO 自動生成されたメソッド・スタブ
			return this.dist - o.dist > 0 ? -1 : 1;
		}
	}

	class Point {
		double x;
		double y;

		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}

		double dist(Point p) {
			return Math.hypot(this.x - p.x, this.y - p.y);
		}
	}

	public static void main(String[] args) {
		new C().run();
	}
}
