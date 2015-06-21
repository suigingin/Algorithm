import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int p = sc.nextInt();
		char[] c = sc.next().toCharArray();

		// 0-indexed かつ 左半分で操作する
		if (p > n / 2) p = n - p;
		else p--;

		// どちら側から修正するか
		int right = p;
		int left = p;
		for (int i = p; i < n / 2; i++) {
			if (c[i] != c[n - i - 1]) right = i;
		}
		for (int i = p; i >= 0; i--) {
			if (c[i] != c[n - i - 1]) left = i;
		}

		boolean leftF = false;
		if (right != -1 && Math.abs(p - right) > Math.abs(p - left)) {
			leftF = true;
		}

		// 移動コスト
		int cost = 0;
		if (leftF) {
			cost += Math.abs(p - left) * 2;
			cost += Math.abs(p - right);
		} else {
			cost += Math.abs(p - right) * 2;
			cost += Math.abs(p - left);
		}

		for (int i = 0; i < n / 2; i++) {
			if (c[i] != c[n - i - 1]) {
				int i1 = c[i];
				int i2 = c[n - i - 1];
				cost += Math.min(Math.abs(i1 - i2), Math.abs(-Math.abs(i1 - i2) + 26));
			}
		}
		System.out.println(cost);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
