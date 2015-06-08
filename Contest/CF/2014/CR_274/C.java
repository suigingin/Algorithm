import java.util.Arrays;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		Pair[] p = new Pair[n];
		for (int i = 0; i < n; i++) p[i] = new Pair(sc.nextInt(), sc.nextInt());

		Arrays.sort(p);

		int minD = 0;
		for (Pair ele : p) {
			int b = ele.b;
			int a = ele.a;
			minD = b >= minD ? b : a;
		}
		System.out.println(minD);
	}

	class Pair implements Comparable<Pair> {

		int a;
		int b;

		public Pair(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair arg0) {
			if (this.a == arg0.a) {
				return this.b - arg0.b;
			}
			return this.a - arg0.a;
		}
	}

	public static void main(String[] args) {
		new C().run();
	}
}
