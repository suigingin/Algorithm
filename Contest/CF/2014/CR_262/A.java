public class A {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int d = 0;
		while (n > 0) {
			n--;
			d++;
			if (d % m == 0) {
				n++;
			}
		}
		System.out.println(d);
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
	}
}
