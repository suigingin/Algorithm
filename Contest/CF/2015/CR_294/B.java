public class B {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		long sum1 = calc(n);
		long sum2 = calc(n - 1);
		long sum3 = calc(n - 2);
		System.out.println(sum1 - sum2);
		System.out.println(sum2 - sum3);
	}

	long calc(int n) {
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += sc.nextInt();
		}
		return sum;
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
	}
}
