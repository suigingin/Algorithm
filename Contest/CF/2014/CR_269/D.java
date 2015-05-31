public class D {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		int w = sc.nextInt();
		int[] a = sc.nextIntArray(n);
		int[] b = sc.nextIntArray(w);
		int[] aDiff = makeDiff(a);
		int[] bDiff = makeDiff(b);
		if (w == 1) {
			System.out.println(n);
		} else {
			System.out.println(kmp(aDiff, bDiff));
		}
	}

	int kmp(int[] S, int[] W) {
		int cnt = 0;
		int[] next = new int[W.length];
		for (int i = 1, k = 0; i < W.length; i++) {
			while (k > 0 && W[k] != W[i]) k = next[k - 1];
			if (W[k] == W[i]) k++;
			next[i] = k;
		}

		for (int i = 0, k = 0; i < S.length; i++) {
			while (k > 0 && W[k] != S[i]) k = next[k - 1];
			if (W[k] == S[i]) k++;
			if (k == W.length) {
				cnt++;
				k = next[k - 1];
			}
		}
		return cnt;
	}

	int[] makeDiff(int[] arr) {
		int[] d = new int[arr.length - 1];
		for (int i = 1; i < arr.length; i++) {
			d[i - 1] = arr[i] - arr[i - 1];
		}
		return d;
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

		int[] nextIntArray(int n) {
			int[] in = new int[n];
			for (int i = 0; i < n; i++) {
				in[i] = nextInt();
			}
			return in;
		}
	}
}
