import java.util.Scanner;

public class Geometry {
	Scanner sc = new Scanner(System.in);
	double EPS = 1e-8;

	class Point implements Comparable<Point> {
		double x;
		double y;

		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point arg0) {
			if (this.x == arg0.x)    return this.y - arg0.y > 0 ? 1 : -1;
			if (this.x - arg0.x > 0) return 1;
			else                     return -1;
		}
	}

	public Point[] pointArray(int n) {
		Point[] res = new Point[n];
		for (int i = 0; i < n; i++) res[i] = new Point(sc.nextDouble(), sc.nextDouble());
		return res;
	}

	// 線分p1->p2と線分p3->p4が交差しているかを判定 true->交差(=含みで接する含む) false->交差せず
	boolean lineCross(Point p1, Point p2, Point p3, Point p4) {
		double a = (p1.x - p2.x) * (p3.y - p1.y) + (p1.y - p2.y) * (p1.x - p3.x);
		double b = (p1.x - p2.x) * (p4.y - p1.y) + (p1.y - p2.y) * (p1.x - p4.x);
		double c = (p3.x - p4.x) * (p1.y - p3.y) + (p3.y - p4.y) * (p3.x - p1.x);
		double d = (p3.x - p4.x) * (p2.y - p3.y) + (p3.y - p4.y) * (p3.x - p2.x);
		return a * b <= 0 && c * d <= 0;
	}

	// 線分p1->p2と直線p3->p4が交差しているかを判定 true->交差(=含みで接する含む) false->交差せず
	boolean lineCross2(Point p1, Point p2, Point p3, Point p4) {
		double a = (p3.x - p4.x) * (p1.y - p3.y) + (p3.y - p4.y) * (p3.x - p1.x);
		double b = (p3.x - p4.x) * (p2.y - p3.y) + (p3.y - p4.y) * (p3.x - p2.x);
		return a * b <= 0;
	}

	// 0 : 任意の2点が重複
	// 1 : p1 -> p2 -> p3 が反時計回り(counter clockwise)
	// 2 : p1 -> p2 -> p3 が時計回り(clockwise)
	// 3 : p1 -> p2 -> p3 の直線
	// 4 : p2 -> p1 -> p3 の直線
	// 5 : p1 -> p3 -> p2 の直線
	int ccw(Point p1, Point p2, Point p3) {
		if (p1.x == p2.x && p1.y == p2.y || p2.x == p3.x && p2.y == p3.y || p3.x == p1.x && p3.y == p1.x) return 0;
		Point a = new Point(p2.x - p1.x, p2.y - p1.y);
		Point b = new Point(p3.x - p1.x, p3.y - p1.y);
		if (crossProduct(a, b) > EPS)  return 1;
		if (crossProduct(a, b) < -EPS) return 2;
		if (norm(a) < norm(b))         return 3;
		if (dot(a, b) < 0)             return 4;
		else                           return 5;
	}

	// 点o -> 直線abとの距離
	double pointToLine(Point o, Point a, Point b) {
		Point subBA = new Point(b.x - a.x, b.y - a.y);
		Point subOA = new Point(o.x - a.x, o.y - a.y);
		return Math.abs(crossProduct(subBA, subOA) / Math.hypot(subBA.x, subBA.y));
	}

	// 点o -> 線分abとの距離
	double pointToLineSegment(Point o, Point a, Point b) {
		Point subAB = new Point(a.x - b.x, a.y - b.y);
		Point subBA = new Point(b.x - a.x, b.y - a.y);
		Point subOA = new Point(o.x - a.x, o.y - a.y);
		Point subOB = new Point(o.x - b.x, o.y - b.y);
		if (dot(subBA, subOA) < EPS)      return Math.hypot(subOA.x, subOA.y);
		else if (dot(subAB, subOB) < EPS) return Math.hypot(subOB.x, subOB.y);
		else return crossProduct(subBA, subOA) / Math.hypot(subBA.x, subBA.y);
	}

	// 外積
	double crossProduct(Point a, Point b) {
		return a.x * b.y - a.y * b.x;
	}

	// 内積
	double dot(Point a, Point b) {
		return a.x * b.x + a.y * b.y;
	}

	double norm(Point a) {
		return Math.sqrt(a.x * a.x + a.y * a.y);
	}

	double triangleArea(Point p1, Point p2, Point p3) {
		return Math.abs((p3.y - p1.y) * (p2.x - p1.x) - (p2.y - p1.y) * (p3.x - p1.x)) / 2;
	}
}
