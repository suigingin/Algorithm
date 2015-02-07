public class POJ_1579 {
	MyScanner sc = new MyScanner();
	int[][][] memo;

	void run() {
		for (;;) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			memo = new int[21][21][21];
			if (a == -1 && b == -1 && c == -1) {
				return;
			}
			System.out.printf("w(%d, %d, %d) = ", a, b, c);
			System.out.println(func(a, b, c));
		}
	}

	int func(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		if (a > 20 || b > 20 || c > 20) {
			return func(20, 20, 20);
		}
		if (memo[a][b][c] != 0) {
			return memo[a][b][c];
		}
		if (a < b && b < c) {
			return memo[a][b][c] = func(a, b, c - 1) + func(a, b - 1, c - 1)
					- func(a, b - 1, c);
		}
		return memo[a][b][c] = func(a - 1, b, c) + func(a - 1, b - 1, c)
				+ func(a - 1, b, c - 1) - func(a - 1, b - 1, c - 1);
	}

	public static void main(String[] args) {
		new POJ_1579().run();
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
