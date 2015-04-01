public class B {
	MyScanner sc = new MyScanner();

	void run() {
		char[] c = sc.next().toCharArray();
		int[] t = new int[c.length + 1];
		int m = sc.nextInt();
		int[] a = sc.nextIntArray(m);
		for (int i = 0; i < m; i++) {
			t[a[i] - 1]++;
			t[c.length - a[i] + 1]--;
		}
		for (int i = 1; i < c.length / 2; i++) {
			t[i] += t[i - 1];
		}
		for (int i = 0; i < c.length / 2; i++) {
			if (t[i] % 2 != 0) {
				swap(c, i, c.length - i - 1);
			}
		}
		System.out.println(String.valueOf(c));
	}

	void swap(char[] x, int a, int b) {
		char tmp = x[a];
		x[a] = x[b];
		x[b] = tmp;
	}

	public static void main(String[] args) {
		new B().run();
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

		int[] nextIntArray(int n) {
			int[] in = new int[n];
			for (int i = 0; i < n; i++) {
				in[i] = nextInt();
			}
			return in;
		}
	}
}
