import java.util.Arrays;

public class C {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		long score = 0;
		long all = 0;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			all += a[i];
		}
		score += all;
		Arrays.sort(a);
		for (int i = 0; i < n - 1; i++) {
			score += all;
			all -= a[i];
		}
		System.out.println(score);
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
