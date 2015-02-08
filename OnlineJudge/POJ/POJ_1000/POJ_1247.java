public class POJ_1247 {
	MyScanner sc = new MyScanner();

	void run() {
		for (;;) {
			int N = sc.nextInt();
			if (N == 0) {
				return;
			}
			int[] a = sc.nextIntArray(N);
			int sum = 0;
			int half = 0;
			for (int i = 0; i < N; i++) {
				sum += a[i];
			}
			if (sum % 2 != 0) {
				System.out.println("No equal partitioning.");
				continue;
			}
			int index = 0;
			half = sum / 2;
			sum = 0;
			while (index < N && sum < half) {
				sum += a[index++];
			}
			if (sum > half) {
				System.out.println("No equal partitioning.");
			} else {
				System.out.print("Sam stops at position " + index);
				System.out.println(" and Ella stops at position " + (index + 1)	+ ".");
			}
		}
	}

	public static void main(String[] args) {
		new POJ_1247().run();
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
