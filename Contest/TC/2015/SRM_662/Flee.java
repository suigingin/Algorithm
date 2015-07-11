import java.util.Scanner;

public class Flee {
	Scanner sc = new Scanner(System.in);
	double max = Integer.MAX_VALUE;
	double EPS = 1e-8;

	public double maximalSafetyLevel(int[] x, int[] y) {
		int size = x.length;
		Point o = new Point(0, 0);
		Point[] p = new Point[size];

		for (int i = 0; i < size; i++) p[i] = new Point(x[i], y[i]);

		for (int i = 0; i < size; i++) {
			double d = Math.hypot(p[i].x, p[i].y);
			max = Math.min(max, d);
		}
		if (size <= 2) return max;

		int[] ccw = new int[3];
		for (int i = 0; i < size; i++) ccw[i] = ccw(p[i], o, p[(i + 1) % size]);
		if (!(ccw[0] == ccw[1] && ccw[1] == ccw[2] && ccw[2] != 0)) return max;

		double d = 0;
		for (int i = 0; i < x.length; i++) {
			for (int j = i + 1; j < x.length; j++) {
				double midX = (x[i] + x[j]) / 2;
				double midY = (y[i] + y[j]) / 2;
				d = Math.max(d, Math.hypot(x[j] - midX, y[j] - midY));
			}
		}
		max = Math.min(max, d);
		return max;
	}

	class Point {
		double x;
		double y;

		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	int ccw(Point p1, Point p2, Point p3) {
		Point a = new Point(p2.x - p1.x, p2.y - p1.y);
		Point b = new Point(p3.x - p1.x, p3.y - p1.y);
		if (crossProduct(a, b) > EPS)  return  1;  // counter clockwise
		if (crossProduct(a, b) < -EPS) return -1;  // clockwise
		if (dot(a, b) < 0)             return  2;  // c--a--b on line
		if (norm(a) < norm(b))         return -2;  // a--b--c on line
		else                           return  0;
	}

	double crossProduct(Point a, Point b) {
		return a.x * b.y - a.y * b.x;
	}

	double dot(Point a, Point b) {
		return a.x * b.x + a.y * b.y;
	}

	double norm(Point a) {
		return Math.sqrt(a.x * a.x + a.y * a.y);
	}
}
