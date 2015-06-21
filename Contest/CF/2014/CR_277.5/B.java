import java.util.Arrays;

public class B {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		int[] a = sc.nextIntArray(n);
		int m = sc.nextInt();
		int[] b = sc.nextIntArray(m);
		Arrays.sort(a);
		Arrays.sort(b);
		int cnt = 0;
		boolean[] f = new boolean[m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (Math.abs(a[i] - b[j]) <= 1 && !f[j]) {
					f[j] = true;
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
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

		int[] nextIntArray(int n) {
			int[] in = new int[n];
			for (int i = 0; i < n; i++) {
				in[i] = nextInt();
			}
			return in;
		}
	}
}
