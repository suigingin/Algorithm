public class C {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		int[][] f = sc.nextInt2dArray(n, n);
		long[] left = new long[n * 2 - 1];
		long[] right = new long[n * 2 - 1];
		for (int i = 0; i < n * 2 - 1; i++) {
			int hl = i < n ? i : n - 1;
			int wl = i < n ? 0 : i - n + 1;
			while (inner(hl, wl, n, n)) {
				left[i] += f[hl--][wl++];
			}

			int hr = i < n ? i : n - 1;
			int wr = i < n ? n - 1 : n * 2 - i - 2;
			while (inner(hr, wr, n, n)) {
				right[i] += f[hr--][wr--];
			}
		}

		int x1, y1, x2, y2;
		x1 = y1 = x2 = y2 = 0;
		long max1 = -1;
		long max2 = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				long score = left[i + j] + right[n - j + i - 1] - f[i][j];
				if ((i + j) % 2 == 0) {
					if (score > max1) {
						max1 = score;
						x1 = i + 1;
						y1 = j + 1;
					}
				} else {
					if (score > max2) {
						max2 = score;
						x2 = i + 1;
						y2 = j + 1;
					}
				}
			}
		}
		System.out.println(max1 + max2);
		System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
	}

	public static void main(String[] args) {
		new C().run();
	}

	boolean inner(int h, int w, int limH, int limW) {
		return 0 <= h && h < limH && 0 <= w && w < limW;
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

		int[][] nextInt2dArray(int n, int m) {
			int[][] in = new int[n][m];
			for (int i = 0; i < n; i++) {
				in[i] = nextIntArray(m);
			}
			return in;
		}
	}
}
