import java.util.Arrays;
import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);
	int n, k;
	int[][][] memo;
	Pair[] train;

	void run() {
		int t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			k = sc.nextInt();
			train = new Pair[k];
			memo = new int[3][n][n + 10];
			for (int i = 0; i < 3; i++) for (int j = 0; j < n; j++) Arrays.fill(memo[i][j], -1);
			int cnt = 0;
			int row = 0;
			for (int i = 0; i < 3; i++) {
				String s = sc.next();
				for (int j = 0; j < n; j++) {
					char c = s.charAt(j);
					if (c == 's') row = i;
					if (c != '.' && c != 's') {
						int sw = j;
						while (j < n && s.charAt(j) == c) j++;
						train[cnt++] = new Pair(i, sw, --j);
					}
				}
			}
			System.out.println(dfs(row, 0, 0) == 1 ? "YES" : "NO");
		}
	}

	int dfs(int row, int col, int t) {
		if(memo[row][col][t] != -1) return memo[row][col][t];
		int res = 0;
		if (!check(row, col, t)) return res;
		if (col == n - 1) return res |= 1;
		if (check(row, col + 1, t)) {
			if (row - 1 >= 0) res |= dfs(row - 1, col + 1, t + 1);
			if (row + 1 < 3) res |= dfs(row + 1, col + 1, t + 1);
			res |= dfs(row, col + 1, t + 1);
		}
		return memo[row][col][t] = res;
	}

	boolean check(int row, int col, int t) {
		for (int i = 0; i < k; i++) {
			Pair p = train[i];
			if (row == p.h && p.w1 - (t * 2) <= col && col <= p.w2 - ((t - 1) * 2)) {
				return false;
			}
		}
		return true;
	}

	class Pair {

		int h;
		int w1;
		int w2;

		public Pair(int h, int w1, int w2) {
			super();
			this.h = h;
			this.w1 = w1;
			this.w2 = w2;
		}
	}

	public static void main(String[] args) {
		new D().run();
	}
}
