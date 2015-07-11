import java.util.Scanner;

public class PKU_3264 {
	Scanner sc = new Scanner(System.in);

	int n, q;
	int datMin[], datMax[];

	void init() {
		datMin = new int[n * 2 - 1];
		datMax = new int[n * 2 - 1];
		for (int i = 0; i < n * 2 - 1; i++) {
			datMin[i] = Integer.MAX_VALUE;
			datMax[i] = 0;
		}
	}

	int queryMin(int a, int b, int k, int l, int r) {
		if (a <= l && r <= b) return datMin[k];
		if (r <= a || b <= l) return Integer.MAX_VALUE;
		int vl = queryMin(a, b, k * 2 + 1, l, (l + r) / 2);
		int vr = queryMin(a, b, k * 2 + 2, (l + r) / 2, r);
		return Math.min(vl, vr);
	}

	int queryMax(int a, int b, int k, int l, int r) {
		if (a <= l && r <= b) return datMax[k];
		if (r <= a || b <= l) return 0;
		int vl = queryMax(a, b, k * 2 + 1, l, (l + r) / 2);
		int vr = queryMax(a, b, k * 2 + 2, (l + r) / 2, r);
		return Math.max(vl, vr);
	}

	void update(int i, int x, boolean f) {
		i += n - 1;
		datMin[i] = datMax[i] = x;
		if (f) {
			while (i > 0) {
				i = (i - 1) / 2;
				datMin[i] = Math.min(datMin[i * 2 + 1], datMin[i * 2 + 2]);
			}
		} else {
			while (i > 0) {
				i = (i - 1) / 2;
				datMax[i] = Math.max(datMax[i * 2 + 1], datMax[i * 2 + 2]);
			}
		}
	}

	void run() {
		// nn : 要素数
		// q : クエリ
		// n : 用意するノードの数
		int nn = sc.nextInt();
		q = sc.nextInt();
		n = 1;
		while (n < nn) n *= 2;

		init();
		for (int i = 0; i < nn; i++) {
			int height = sc.nextInt();
			update(i, height, true);
			update(i, height, false);
		}

		StringBuilder out = new StringBuilder();
		while (q-- > 0) {
			// [x ,y+1) の半開区間における最小値/最大値
			int x = sc.nextInt() - 1;
			int y = sc.nextInt();
			int min = queryMin(x, y, 0, 0, n);
			int max = queryMax(x, y, 0, 0, n);
			out.append(max - min + "\n");
		}
		System.out.print(out);
	}

	public static void main(String[] args) {
		new PKU_3264().run();
	}
}
