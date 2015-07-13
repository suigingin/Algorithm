package geometry;


public class Geometry {
	double EPS = 1e-8;

	class Point {
		double x;
		double y;

		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	// 線分p1-p2と線分p3-p4が交差しているかを判定 true->交差(=含みで接する含む) false->交差せず
	boolean lineCross(Point p1, Point p2, Point p3, Point p4) {
		double a = (p1.x - p2.x) * (p3.y - p1.y) + (p1.y - p2.y) * (p1.x - p3.x);
		double b = (p1.x - p2.x) * (p4.y - p1.y) + (p1.y - p2.y) * (p1.x - p4.x);
		double c = (p3.x - p4.x) * (p1.y - p3.y) + (p3.y - p4.y) * (p3.x - p1.x);
		double d = (p3.x - p4.x) * (p2.y - p3.y) + (p3.y - p4.y) * (p3.x - p2.x);
		return a * b <= 0 && c * d <= 0;
	}

	// counterClockWise p1->p2->p3が反時計周りなら1 時計周りなら-1を返す
	double ccw(Point p1, Point p2, Point p3) {
		Point a = new Point(p2.x - p1.x, p2.y - p1.y);
		Point b = new Point(p3.x - p1.x, p3.y - p1.y);
		if (crossProduct(a, b) > EPS)  return  1;// counter clockwise
		if (crossProduct(a, b) < -EPS) return -1;// clockwise
		if (dot(a, b) < 0)             return  2;// c--a--b on line
		if (norm(a) < norm(b))         return -2; // a--b--c on line
		else                           return  0;
	}

	// 外積
	double crossProduct(Point a, Point b) {
		return a.x * b.y - a.y * b.x;
	}

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

