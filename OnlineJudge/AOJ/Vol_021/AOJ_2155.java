import java.util.Arrays;

public class AOJ_2155 {
	MyScanner sc = new MyScanner();

	void run() {
		for (;;) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			if ((N | M) == 0) {
				return;
			}
			boolean[] virus = new boolean[N];
			virus[0] = true;
			Info[] info = new Info[M];
			for (int i = 0; i < M; i++) {
				info[i] = new Info(sc.nextInt(), sc.nextInt() - 1,
						sc.nextInt() - 1);
			}
			Arrays.sort(info);
			for (int i = 0; i < M; i++) {
				if (virus[info[i].s]) {
					virus[info[i].d] = true;
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (virus[i]) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

	class Info implements Comparable<Info> {
		int time;
		int s;
		int d;

		public Info(int time, int s, int d) {
			super();
			this.time = time;
			this.s = s;
			this.d = d;
		}

		@Override
		public int compareTo(Info arg0) {
			return this.time - arg0.time;
		}
	}

	public static void main(String[] args) {
		new AOJ_2155().run();
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

