public class D {
	MyScanner sc = new MyScanner();

	void run() {

		int M = 5000000;

		int[] isPrime = new int[M + 1];
		for (int i = 2; i * i <= M; i++) {
			if (isPrime[i] != 0) continue;
			for (int j = i * 2; j <= M; j += i) isPrime[j] = i;
		}

		int[] pFactorCnt = new int[M + 1];
		int[] pFactorSum = new int[M + 1];
		for (int i = 2; i <= M; i++) {
			pFactorCnt[i] = (isPrime[i] == 0) ? 1 : pFactorCnt[i / isPrime[i]] + 1;
			pFactorSum[i] = pFactorSum[i - 1] + pFactorCnt[i];
		}

		int n = sc.nextInt();
		StringBuilder out = new StringBuilder();
		while (n-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			out.append(pFactorSum[a] - pFactorSum[b] + "\n");
		}
		System.out.print(out);
	}

	public static void main(String[] args) {
		new D().run();
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
