import java.util.HashSet;

public class POJ_3050 {
	MyScanner sc = new MyScanner();
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };

	int[][] f;
	HashSet<String> set;

	void run() {
		f = sc.nextInt2dArray(5, 5);
		set = new HashSet<String>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(0, i, j, String.valueOf(f[i][j]));
			}
		}
		System.out.println(set.size());
	}

	void dfs(int depth, int h, int w, String s) {
		if (depth == 6) {
			set.add(s);
			return;
		}
		for (int j = 0; j < 4; j++) {
			int nh = h + dy[j];
			int nw = w + dx[j];
			if (inner(nh, nw, 5, 5)) {
				dfs(depth + 1, nh, nw, s + f[h][w]);
			}
		}
	}

	public static void main(String[] args) {
		new POJ_3050().run();
	}

	boolean inner(int h, int w, int limH, int limW) {
		return 0 <= h && h < limH && 0 <= w && w < limW;
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

		int[] nextIntArray(int n) {
			int[] in = new int[n];
			for (int i = 0; i < n; i++) {
				in[i] = nextInt();
			}
			return in;
		}

		int[][] nextInt2dArray(int n, int m) {
			int[][] in = new int[n][m];
			for (int i = 0; i < n; i++) {
				in[i] = nextIntArray(m);
			}
			return in;
		}
	}
}
