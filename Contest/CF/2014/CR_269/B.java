import java.util.Arrays;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		Pair[] p = new Pair[n];
		for (int i = 0; i < n; i++) p[i] = new Pair(sc.nextInt(), i + 1);
		Arrays.sort(p);
		int cnt = 0;
		for (int i = 0; i < n - 1; i++) {
			if (p[i].difficult == p[i + 1].difficult) cnt++;
		}
		if (cnt < 2) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			cnt = 2;
			print(p); cnt--;
			for (int i = 0; i < n - 1; i++) {
				if (cnt >= 0 && p[i].difficult == p[i + 1].difficult) {
					swap(p, i, i + 1);
					print(p); cnt--;
				}
			}
		}
	}

	class Pair implements Comparable<Pair> {

		int difficult;
		int task;

		public Pair(int difficult, int task) {
			super();
			this.difficult = difficult;
			this.task = task;
		}

		@Override
		public int compareTo(Pair arg0) {
			if (this.difficult == arg0.difficult) {
				return this.task - arg0.task;
			}
			return this.difficult - arg0.difficult;
		}
	}

	public static void main(String[] args) {
		new B().run();
	}

	void swap(Pair[] x, int a, int b) {
		Pair tmp = x[a];
		x[a] = x[b];
		x[b] = tmp;
	}

	void print(Pair p[]) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < p.length; i++) {
			sb.append((i == 0 ? "" : " ") + p[i].task);
		}
		System.out.println(sb);
	}
}
