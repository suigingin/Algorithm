public class C {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		int p = sc.nextInt();
		char max = (char) ('a' + p);
		char[] c = sc.next().toCharArray();
		for (int i = n - 1; i >= 0; i--) {
			char add = (char) (c[i] + 1);
			for (char u = add; u < max; u++) {
				if (palindromeCheck(c, u, i)) {
					c[i] = u;
					for (int j = i + 1; j < n; j++) {
						for (char uu = 'a'; uu < max; uu++) {
							if (palindromeCheck(c, uu, j)) {
								c[j] = uu;
								break;
							}
						}
					}
					System.out.println(String.valueOf(c));
					return;
				}
			}
		}
		System.out.println("NO");
	}

	boolean palindromeCheck(char[] c, char add, int index) {
		if (index > 1) {
			return c[index - 2] != add && c[index - 1] != add;
		} else if (index > 0) {
			return c[index - 1] != add;
		} else {
			return true;
		}
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
