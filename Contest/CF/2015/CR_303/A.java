import java.util.Arrays;

public class A {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		int[][] a = sc.nextInt2dArray(n, n);
		boolean[] ok = new boolean[n];
		Arrays.fill(ok, true);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) ok[i] = false;
				if (a[i][j] == 3) {
					ok[j] = false;
					ok[i] = false;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (ok[i]) cnt++;
		}
		StringBuilder out = new StringBuilder(cnt + "\n");
		if (cnt >= 1) {
			for (int i = 0; i < n; i++) {
				if (ok[i]) out.append(i + 1 + " ");
			}
		}
		System.out.println(out);
	}

	public static void main(String[] args) {
		new A().run();
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
