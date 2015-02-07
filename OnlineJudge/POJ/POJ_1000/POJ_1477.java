public class POJ_1477 {
	MyScanner sc = new MyScanner();

	void run() {
		int T = 1;
		for (;;) {
			int n = sc.nextInt();
			if (n == 0) {
				return;
			}
			int[] h = sc.nextIntArray(n);
			int cnt = 0;
			int ave = 0;
			for (int i = 0; i < n; i++) {
				ave += h[i];
			}
			ave /= n;
			for (int i = 0; i < n; i++) {
				if (h[i] > ave) {
					cnt += h[i] - ave;
				}
			}
			if (T != 1)	System.out.println();
			System.out.println("Set #" + T++);
			System.out.println("The minimum number of moves is " + cnt + ".");
		}
	}

	public static void main(String[] args) {
		new POJ_1477().run();
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
