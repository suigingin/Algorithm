import java.util.Arrays;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		long x1 = sc.nextLong();
		long x2 = sc.nextLong();
		Pair[] p = new Pair[n];

		for (int i = 0; i < n; i++) {
			long k = sc.nextLong();
			long b = sc.nextLong();
			long y1 = k * x1 + b;
			long y2 = k * x2 + b;
			p[i] = new Pair(y1, y2);
		}

		Arrays.sort(p);
		for (int i = 0; i < n - 1; i++) {
			if (p[i].y2 > p[i + 1].y2) {
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("No");
	}

	class Pair implements Comparable<Pair> {

		long y1;
		long y2;

		public Pair(long y1, long y2) {
			super();
			this.y1 = y1;
			this.y2 = y2;
		}

		@Override
		public int compareTo(Pair arg0) {
			if (this.y1 == arg0.y1) {
				return this.y2 > arg0.y2 ? 1 : -1;
			}
			return this.y1 > arg0.y1 ? 1 : -1;
		}
	}

	public static void main(String[] args) {
		new B().run();
	}
}
