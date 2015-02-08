public class B {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		int[] b = new int[n];
		int min = Integer.MAX_VALUE;
		int max = 1;
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
			min = Math.min(min, b[i]);
			max = Math.max(max, b[i]);
		}
		long minCnt = 0;
		long maxCnt = 0;
		long cnt = 0;
		for (int i = 0; i < n; i++) {
			if (b[i] == min) {
				minCnt++;
			}
			if (b[i] == max) {
				maxCnt++;
			}
		}
		cnt = (min == max) ? n * (n - 1) / 2 : minCnt * maxCnt;
		System.out.println(max - min + " " + cnt);
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
