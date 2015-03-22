import java.util.Arrays;

public class POJ_2376 {
	MyScanner sc = new MyScanner();

	void run() {
		int N = sc.nextInt();
		int T = sc.nextInt();
		Pair[] p = new Pair[N];
		for (int i = 0; i < N; i++) {
			p[i] = new Pair(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(p);
		int cnt = 0;
		int from = 0;
		int i = 0;
		while (from < T) {
			int to = 0;
			for (; i < N && p[i].a <= from + 1; i++) {
				to = Math.max(to, p[i].b);
			}
			if (to == 0) {
				System.out.println(-1);
				return;
			}
			from = to;
			cnt++;
		}
		System.out.println(cnt);
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
		new POJ_2376().run();
	}

	class MyScanner {
		int nextInt() {
			try {
				int c = System.in.read();
				while (c != '-' && (c < '0' || '9' < c))
					c = System.in.read();
				if (c == '-')
					return -nextInt();
				int res = 0;
				do {
					res *= 10;
					res += c - '0';
					c = System.in.read();
				} while ('0' <= c && c <= '9');
				return res;
			} catch (Exception e) {
				return -1;
			}
		}
	}
}
