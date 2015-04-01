import java.util.Arrays;

public class C {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		long[] l = sc.nextLongArray(n);
		Arrays.sort(l);
		boolean one = false;
		boolean two = false;
		int s = 0;
		int t = 0;
		long area = 0;
		for (int i = n - 2; i >= 0; i--) {
			if (!one && l[i + 1] - l[i] <= 1) {
				s = i--;
				one = true;
			} else if (!two && one && l[i + 1] - l[i] <= 1) {
				t = i--;
				two = true;
			}
			if (one && two) {
				area += l[s] * l[t];
				one = two = false;
			}
		}
		System.out.println(area);
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

		long nextLong() {
			return Long.parseLong(next());
		}

		String next() {
			try {
				StringBuilder res = new StringBuilder("");
				int c = System.in.read();
				while (Character.isWhitespace(c))
					c = System.in.read();
				do {
					res.append((char) c);
				} while (!Character.isWhitespace(c = System.in.read()));
				return res.toString();
			} catch (Exception e) {
				return null;
			}
		}

		long[] nextLongArray(int n) {
			long[] in = new long[n];
			for (int i = 0; i < n; i++) {
				in[i] = nextLong();
			}
			return in;
		}
	}
}
