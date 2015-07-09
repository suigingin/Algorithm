import java.util.Scanner;

public class SegmentTreeRMQ {
	Scanner sc = new Scanner(System.in);

	int n, q;
	int dat[];

	void init() {
		dat = new int[n * 2 - 1];
		for (int i = 0; i < n * 2 - 1; i++) {
			dat[i] = Integer.MAX_VALUE;
		}
	}

	int query(int a, int b, int k, int l, int r) {
		if (a <= l && r <= b) return dat[k];
		if (r <= a || b <= l) return Integer.MAX_VALUE;
		int vl = query(a, b, k * 2 + 1, l, (l + r) / 2);
		int vr = query(a, b, k * 2 + 2, (l + r) / 2, r);
		return Math.min(vl, vr);
	}

	void update(int i, int x) {
		i += n - 1;
		dat[i] = x;
		while (i > 0) {
			i = (i - 1) / 2;
			dat[i] = Math.min(dat[i * 2 + 1], dat[i * 2 + 2]);
		}
	}

	void display() {
		StringBuilder sb = new StringBuilder();
		int h = 0;
		int index = 0;
		while (index < dat.length) {
			for (int i = 0; i < Math.pow(2, h); i++) sb.append(dat[index++] + " ");
			sb.append("\n");
			h++;
		}
		System.out.print(sb);
	}

	void run() {
		// nn : 要素数
		//  q : クエリ
		//  n : 用意するノードの数
		int nn = sc.nextInt();
		q = sc.nextInt();
		n = 1;
		while (n < nn) n *= 2;

		init();

		while (q-- > 0) {
			int com = sc.nextInt();
			if (com == 0) {
				// i番目の要素をxに更新 (0-indexed: 0 <= i < nn)
				int i = sc.nextInt();
				int x = sc.nextInt();
				update(i, x);
			} else if (com == 1) {
				// [x ,y+1) の半開区間における最小値を返す
				int x = sc.nextInt();
				int y = sc.nextInt() + 1;
				System.out.println(query(x, y, 0, 0, n));
			} else {
				display();
			}
		}
	}

	public static void main(String[] args) {
		new SegmentTreeRMQ().run();
	}
}
