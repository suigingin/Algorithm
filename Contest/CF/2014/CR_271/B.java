import java.util.Arrays;
import java.util.TreeMap;

public class B {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		int[] a = sc.nextIntArray(n);
		int m = sc.nextInt();
		int[] q = sc.nextIntArray(m);
		solve1(n, a, m, q);
		solve2(n, a, m, q);
		solve3(n, a, m, q);
	}

	void solve1(int n, int[] a, int m, int[] q) {
		StringBuilder out = new StringBuilder();
		int[] sum = new int[n];
		sum[0] = a[0];
		for (int i = 1; i < n; i++) sum[i] = sum[i - 1] + a[i];
		for (int i = 0; i < m; i++) out.append(lower_bound(sum, q[i]) + 1 + "\n");
		System.out.print(out);
	}

	void solve2(int n, int[] a, int m, int[] q) {
		StringBuilder out = new StringBuilder();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		map.put(a[0], 1);
		for (int i = 1; i < n; i++) map.put(map.lastKey() + a[i], i + 1);
		for (int i = 0; i < m; i++) out.append(map.ceilingEntry(q[i]).getValue() + "\n");
		System.out.print(out);
	}

	void solve3(int n, int[] a, int m, int[] q) {
		StringBuilder out = new StringBuilder();
		int[] sum = new int[n];
		sum[0] = a[0];
		for (int i = 1; i < n; i++) sum[i] = sum[i - 1] + a[i];
		for (int i = 0; i < m; i++) {
			int t = Arrays.binarySearch(sum, q[i]);
			out.append((t < 0 ? -t : t + 1) + "\n");
		}
		System.out.print(out);
	}

	public static void main(String[] args) {
		new B().run();
	}

	// find minimum i (a[i] >= border)
	int lower_bound(int a[], int border) {
		int l = -1;
		int r = a.length;
		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (border <= a[mid]) {
				r = mid;
			} else {
				l = mid;
			}
		}
		// r = l + 1
		return r;
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
