public class B_2 {
	MyScanner sc = new MyScanner();

	int n, cnt;
	int[] path;
	int[] need;

	void run() {
		n = sc.nextInt();
		path = sc.nextIntArray((int) Math.pow(2, n + 1) - 2);
		cnt = 0;
		dfs(0, 1);
		System.out.println(cnt);
	}

	int dfs(int d, int now) {

		if (d == n) {
			return 0;
		}

		int add = 0;
		int l = path[now * 2 - 2] + dfs(d + 1, now * 2);
		int r = path[now * 2 - 1] + dfs(d + 1, now * 2 + 1);

		add = Math.abs(l - r);
		cnt += add;
		return Math.max(l, r);
	}

	public static void main(String[] args) {
		new B_2().run();
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

		int[] nextIntArray(int n) {
			int[] in = new int[n];
			for (int i = 0; i < n; i++) {
				in[i] = nextInt();
			}
			return in;
		}
	}
}
