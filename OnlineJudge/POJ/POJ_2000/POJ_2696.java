import java.util.Arrays;

public class POJ_2696 {
	MyScanner sc = new MyScanner();
	int[] p;
	int[] memo;

	void run() {
		int t = sc.nextInt();
		while (t-- > 0) {
			p = sc.nextIntArray(9);
			memo = new int[p[8] + 1];
			Arrays.fill(memo, -1);
			System.out.println(func(p[8]));
		}
	}

	int func(int i) {
		if (memo[i] >= 0) {
			return memo[i];
		}
		int res;
		if (i == 0) {
			res = p[0];
		} else if (i == 1) {
			res = p[1];
		} else if (i == 2) {
			res = p[2];
		} else if (i % 2 == 1) {
			res = (((p[3] * func(i - 1) + p[4] * func(i - 2) - p[5]
					* func(i - 3)) % p[6]) + p[6])
					% p[6];
		} else {
			res = (((p[5] * func(i - 1) - p[3] * func(i - 2) + p[4]
					* func(i - 3)) % p[7]) + p[7])
					% p[7];
		}
		return memo[i] = res;
	}

	public static void main(String[] args) {
		new POJ_2696().run();
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
