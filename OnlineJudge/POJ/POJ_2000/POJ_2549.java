import java.util.Arrays;
import java.util.Scanner;

public class POJ_2549 {
	Scanner sc = new Scanner(System.in);

	void run() {
		for (;;) {
			int n = sc.nextInt();
			if (n == 0) return;
			int[] s = new int[n];
			for (int i = 0; i < n; i++) s[i] = sc.nextInt();
			Pair[] p = new Pair[n * n - n];
			for (int i = 0, k = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) continue;
					p[k++] = new Pair(s[i] - s[j], s[i], s[j]);
				}
			}

			Arrays.sort(p);
			int res = -Integer.MAX_VALUE;

			// search s[a] + s[b] = s[d] - s[c]
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < n; b++) {
					if (a == b) continue;
					int lower = lower_bound(p, s[a] + s[b]);
					while (0 <= lower && lower < p.length && p[lower].num == s[a] + s[b]) {
						if (!p[lower].isDuplicate(s[a], s[b])) res = Math.max(res, p[lower].d);
						lower++;
					}
				}
			}
			System.out.println(res == -Integer.MAX_VALUE ? "no solution" : res);
		}
	}

	class Pair implements Comparable<Pair> {

		int num;
		int d;
		int c;

		public Pair(int num, int d, int c) {
			super();
			this.num = num;
			this.d = d;
			this.c = c;
		}

		@Override
		public int compareTo(Pair arg0) {
			if (this.num == arg0.num)
				return arg0.d - this.d;
			return this.num - arg0.num;
		}

		boolean isDuplicate(int A, int B) {
			return this.c == A || this.c == B || this.d == A || this.d == B;
		}
	}

	public static void main(String[] args) {
		new POJ_2549().run();
	}

	int lower_bound(Pair p[], int k) {
		int l = -1;
		int r = p.length;
		boolean f = false;
		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (k <= p[mid].num) r = mid;
			else l = mid;
			if (k == p[mid].num) f = true;
		}
		// r = l + 1
		return f ? r : -1;
	}
}
