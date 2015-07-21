import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		ArrayList<Pair> A = new ArrayList<Pair>();
		ArrayList<Pair> B = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int a = sc.nextInt();
			if (x > 0) A.add(new Pair(x, a));
			else       B.add(new Pair(x, a));
		}
		Collections.sort(A);
		Collections.sort(B, Collections.reverseOrder());
		int res = 0;
		for (int i = 0; i < Math.min(A.size(), B.size() + 1); i++) res += A.get(i).app;
		for (int i = 0; i < Math.min(A.size() + 1, B.size()); i++) res += B.get(i).app;
		System.out.println(res);
	}

	class Pair implements Comparable<Pair> {

		int d;
		int app;

		public Pair(int d, int app) {
			super();
			this.d = d;
			this.app = app;
		}

		@Override
		public int compareTo(Pair arg0) {
			if (this.d == arg0.d) {
				return this.app - arg0.app;
			}
			return this.d - arg0.d;
		}
	}

	public static void main(String[] args) {
		new A().run();
	}
}
