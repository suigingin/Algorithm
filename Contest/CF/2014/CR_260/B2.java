public class B2 {
	MyScanner sc = new MyScanner();

	void run() {
		String in = sc.next();
		int mod = 0;
		for (int i = 0; i < in.length(); i++) {
			mod *= 10;
			mod += in.charAt(i) - '0';
			mod %= 4;
		}
		System.out.println(mod % 4 == 0 ? 4 : 0);
	}

	public static void main(String[] args) {
		new B2().run();
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
