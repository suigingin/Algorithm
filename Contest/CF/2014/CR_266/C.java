public class C {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		long[] sum = new long[n];
		sum[0] = sc.nextLong();
		for (int i = 1; i < n; i++) {
			sum[i] = sum[i - 1] + sc.nextLong();
		}
		long div = sum[n - 1] / 3;
		long phase1 = 0;
		long phase2 = 0;
		if (n >= 3 && sum[n - 1] % 3 == 0) {
			for (int i = 0; i < n - 1; i++) {
				if (sum[i] == div * 2) {
					phase2 += phase1;
				}
				if (sum[i] == div) {
					phase1++;
				}
			}
		}
		System.out.println(phase2);
	}

	public static void main(String[] args) {
		new C().run();
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

		long nextLong() {
			return Long.parseLong(next());
		}

		String next() {
			try {
				StringBuilder res = new StringBuilder("");
				int c = System.in.read();
				while (Character.isWhitespace(c))
					c = System.in.read();
				do {
					res.append((char) c);
				} while (!Character.isWhitespace(c = System.in.read()));
				return res.toString();
			} catch (Exception e) {
				return null;
			}
		}
	}
}
