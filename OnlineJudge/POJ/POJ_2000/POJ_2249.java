public class POJ_2249 {
	MyScanner sc = new MyScanner();

	void run() {
		for (;;) {
			long n = sc.nextLong();
			long m = sc.nextLong();
			if ((n | m) == 0) {
				return;
			}
			System.out.println(combination(n, m));
		}
	}

	long combination(long n, long m) {
		m = Math.min(m, n - m);
		long res = 1;
		for (long i = n - m + 1, j = 1; j <= m; i++, j++) {
			res *= i;
			res /= j;
		}
		return res;
	}

	public static void main(String[] args) {
		new POJ_2249().run();
	}
}

class MyScanner {
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
