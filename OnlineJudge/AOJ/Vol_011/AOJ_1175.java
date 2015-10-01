import java.util.Scanner;

public class AOJ_1175 {
	Scanner sc = new Scanner(System.in);
	int n;
	int[] x, y, r, c;
	byte[] memo;

	void run() {
		for (;;) {
			n = sc.nextInt();
			if (n == 0) return;
			x = new int[n];
			y = new int[n];
			r = new int[n];
			c = new int[n];
			memo = new byte[1 << n];
			for (int i = 0; i < 1 << n; i++) memo[i] = -1;
			for (int i = 0; i < n; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
				r[i] = sc.nextInt();
				c[i] = sc.nextInt();
			}
			int max = 0;
			// 最初に取る同色の２つの円を決める
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (c[i] != c[j]) continue;
					if (!noCover(i , j , 0)) continue;
					max = Math.max(max, 2 + bitDP(1 << i | 1 << j));
				}
			}
			System.out.println(max);
		}
	}

	int bitDP(int mask) {
		if (memo[mask] != -1) return memo[mask];

		byte res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (c[i] != c[j]) continue;
				// 既にi or jを取っている
				if ((mask & (1 << i)) != 0 || (mask & (1 << j)) != 0) continue;
				if (!noCover(i, j, mask)) continue;
				res = (byte) Math.max(res, 2 + bitDP(mask | (1 << i | 1 << j)));
			}
		}
		return memo[mask] = res;
	}

	boolean noCover(int i, int j, int mask) {
		for (int k = j - 1; k >= 0; k--) {
			// 既にkは取り除かれている
			if ((mask & 1 << k) != 0) continue;
			int pDis_j = (x[k] - x[j]) * (x[k] - x[j]) + (y[k] - y[j]) * (y[k] - y[j]);
			int rDis_j = (r[k] + r[j]) * (r[k] + r[j]);
			int pDis_i = (x[k] - x[i]) * (x[k] - x[i]) + (y[k] - y[i]) * (y[k] - y[i]);
			int rDis_i = (r[k] + r[i]) * (r[k] + r[i]);
			// kが上に重なっているので取れない
			if (pDis_j < rDis_j) return false;
			if (k < i && pDis_i < rDis_i) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new AOJ_1175().run();
	}
}
