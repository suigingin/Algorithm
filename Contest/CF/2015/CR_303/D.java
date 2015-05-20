import java.util.Arrays;

public class D {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		int[] t = sc.nextIntArray(n);
		Arrays.sort(t);
		long time = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (t[i] >= time) {
				cnt++;
				time += t[i];
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new D().run();
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
