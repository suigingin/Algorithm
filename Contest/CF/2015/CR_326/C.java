public class C {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		int M = 1000000;
		int[] c = new int[M + 2];
		for (int i = 0; i < n; i++) c[sc.nextInt()]++;

		int bitCnt = 0;
		for (int i = 0; i <= M; i++) {
			c[i + 1] += c[i] / 2;
			bitCnt += c[i] % 2;
		}
		while (c[M + 1] > 0) {
			bitCnt += c[M + 1] % 2;
			c[M + 1] /= 2;
		}
		System.out.println(bitCnt);
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
