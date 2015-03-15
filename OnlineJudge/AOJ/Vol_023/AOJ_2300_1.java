import java.util.ArrayList;

public class AOJ_2300_1 {
	MyScanner sc = new MyScanner();
	int n, m;
	double[][] dis;
	double max = 0;

	void run() {
		n = sc.nextInt();
		m = sc.nextInt();
		dis = new double[n][3];
		for (int i = 0; i < n; i++) {
			dis[i][0] = sc.nextDouble();
			dis[i][1] = sc.nextDouble();
			dis[i][2] = sc.nextDouble();
		}
		dfs(0, new ArrayList<Integer>());
		System.out.println(max);
	}

	void dfs(int index, ArrayList<Integer> select) {
		if (select.size() == m) {
			double d = 0;
			for (int i = 0; i < m; i++) {
				for (int j = i + 1; j < m; j++) {
					for (int k = 0; k < 3; k++) {
						d += (dis[select.get(i)][k] - dis[select.get(j)][k])
								* (dis[select.get(i)][k] - dis[select.get(j)][k]);
					}
				}
			}
			max = Math.max(max, d);
			return;
		}
		if (index >= n) {
			return;
		}
		select.add(index);
		dfs(index + 1, select);
		select.remove(select.size() - 1);
		dfs(index + 1, select);
	}

	public static void main(String[] args) {
		new AOJ_2300_1().run();
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
