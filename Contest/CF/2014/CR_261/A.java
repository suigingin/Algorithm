public class A {
	MyScanner sc = new MyScanner();

	void run() {
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		if (x1 == x2) {
			int d = Math.abs(y1 - y2);
			System.out.println((d + x1) + " " + y1 + " " + (d + x2) + " " + y2);
		} else if (y1 == y2) {
			int d = Math.abs(x1 - x2);
			System.out.println(x1 + " " + (d + y1) + " " + x2 + " " + (d + y2));
		} else if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
			System.out.println(x2 + " " + y1 + " " + x1 + " " + y2);
		} else {
			System.out.println(-1);
		}
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
