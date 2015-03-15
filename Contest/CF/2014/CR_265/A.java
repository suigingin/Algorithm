public class A {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		String s = sc.next();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			cnt++;
			if (s.charAt(i) == '0') {
				break;
			}
		}
		System.out.println(cnt);
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
