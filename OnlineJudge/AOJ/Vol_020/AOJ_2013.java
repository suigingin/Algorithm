public class AOJ_2013 {
	MyScanner sc = new MyScanner();

	void run() {
		for (;;) {
			int n = sc.nextInt();
			if (n == 0) {
				return;
			}
			int[] range = new int[86410];
			for (int i = 0; i < n; i++) {
				String[] s = sc.next().split(":");
				String[] t = sc.next().split(":");
				int ss = Integer.valueOf(s[0]) * 3600 + Integer.valueOf(s[1]) * 60 + Integer.valueOf(s[2]);
				int tt = Integer.valueOf(t[0]) * 3600 + Integer.valueOf(t[1]) * 60 + Integer.valueOf(t[2]);
				range[ss]++;
				range[tt]--;
			}
			int max = range[0];
			for (int i = 1; i < range.length; i++) {
				range[i] += range[i - 1];
				max = Math.max(max, range[i]);
			}
			System.out.println(max);
		}
	}

	public static void main(String[] args) {
		new AOJ_2013().run();
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
	}
}

