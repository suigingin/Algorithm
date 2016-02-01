public class C {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		int[][] f = new int[n][n];
		long[] upper = new long[n * 2 + 10];
		long[] lower = new long[n * 2 + 10];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				f[i][j] = sc.nextInt();
				upper[i - j + n] += f[i][j];
				lower[i + j] += f[i][j];
			}
		}
		long even = -1;
		long odd = -1;
		int h1, w1, h2, w2;
		h1 = w1 = h2 = w2 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				long sum = upper[i - j + n] + lower[i + j] - f[i][j];
				if ((i + j) % 2 == 0) {
					if (sum > even) {
						even = sum;
						h1 = i + 1;
						w1 = j + 1;
					}
				} else {
					if (sum > odd) {
						odd = sum;
						h2 = i + 1;
						w2 = j + 1;
					}
				}
			}
		}
		System.out.println(even + odd);
		System.out.println(h1 + " " + w1 + " " + h2 + " " + w2);
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
	}
}
