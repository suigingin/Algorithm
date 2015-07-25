import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);
	double EPS = 1e-8;

	void run() {
		Point o = new Point(sc.nextInt(), sc.nextInt());
		int N = sc.nextInt();
		Point[] p = new Point[N];
		for (int i = 0; i < N; i++) p[i] = new Point(sc.nextDouble(), sc.nextDouble());

		double min = Double.MAX_VALUE / 2;
		for (int i = 0; i < N; i++) {
			double d = pointToLineSegment(o, p[i], p[(i + 1) % N]);
			min = Math.min(d, min);
		}
		System.out.println(min);
	}

	class Point {
		double x;
		double y;

		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	double pointToLineSegment(Point o, Point a, Point b) {
		Point subAB = new Point(a.x - b.x, a.y - b.y);
		Point subBA = new Point(b.x - a.x, b.y - a.y);
		Point subOA = new Point(o.x - a.x, o.y - a.y);
		Point subOB = new Point(o.x - b.x, o.y - b.y);
		if (dot(subBA, subOA) < EPS)      return Math.hypot(subOA.x, subOA.y);
		else if (dot(subAB, subOB) < EPS) return Math.hypot(subOB.x, subOB.y);
		else return crossProduct(subBA, subOA) / Math.hypot(subBA.x, subBA.y);
	}

	double crossProduct(Point a, Point b) {
		return a.x * b.y - a.y * b.x;
	}

	double dot(Point a, Point b) {
		return a.x * b.x + a.y * b.y;
	}

	public static void main(String[] args) {
		new B().run();
	}
}
