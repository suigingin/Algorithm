import java.util.HashMap;

public class D {
	MyScanner sc = new MyScanner();

	void run() {
		int[] cnt = sc.nextIntArray(26);
		String s = sc.next();

		long[] sum = new long[s.length()];
		sum[0] = cnt[s.charAt(0) - 'a'];
		for (int i = 1; i < s.length(); i++) {
			sum[i] = sum[i - 1] + cnt[s.charAt(i) - 'a'];
		}

		long ans = 0;
		for (char c = 'a'; c <= 'z'; c++) {
			HashMap<Long, Integer> map = new HashMap<Long, Integer>();
			for (int i = 0; i < s.length(); i++) {
				if (c == s.charAt(i)) {
					if (i - 1 >= 0 && map.containsKey(sum[i - 1])) {
						ans += map.get(sum[i - 1]);
					}
					map.put(sum[i], map.containsKey(sum[i]) ? map.get(sum[i]) + 1 : 1);
				}
			}
		}
		System.out.println(ans);
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

		int[] nextIntArray(int n) {
			int[] in = new int[n];
			for (int i = 0; i < n; i++) {
				in[i] = nextInt();
			}
			return in;
		}
	}
}
