import java.util.Arrays;

public class B {
	MyScanner sc = new MyScanner();

	void run() {
		long n = sc.nextLong();
		long k = sc.nextLong();
		String s = sc.next();
		long[] cnt = new long[26];
		for (int i = 0; i < n; i++) {
			cnt[s.charAt(i) - 'A']++;
		}
		Arrays.sort(cnt);
		long ans = 0;
		for (int i = cnt.length - 1; i >= 0; i--) {
			if (k > cnt[i]) {
				ans += cnt[i] * cnt[i];
				k -= cnt[i];
			} else {
				ans += k * k;
				break;
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new B().run();
	}

	class MyScanner {

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
	}
}
