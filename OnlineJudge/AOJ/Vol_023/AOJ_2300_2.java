public class AOJ_2300_2 {
	MyScanner sc = new MyScanner();

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		double[][] dis = new double[n][3];
		double max = 0;
		for (int i = 0; i < n; i++) {
			dis[i][0] = sc.nextDouble();
			dis[i][1] = sc.nextDouble();
			dis[i][2] = sc.nextDouble();
		}
		for (int i = 0; i < (1 << n); i++) {
			if (Integer.bitCount(i) == m) {
				double d = 0;
				for (int j = 0; j < n; j++) {
					for (int k = j + 1; k < n; k++) {
						if ((i & (1 << j)) != 0 && (i & (1 << k)) != 0) {
							for (int l = 0; l < 3; l++) {
								d += (dis[j][l] - dis[k][l])
										* (dis[j][l] - dis[k][l]);
							}
						}
					}
				}
				max = Math.max(max, d);
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		new AOJ_2300_2().run();
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

		double nextDouble() {
			return Double.parseDouble(next());
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
