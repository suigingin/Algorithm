import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);
	int n, m, w;
	int[] a;

	void run() {
		n = sc.nextInt();
		m = sc.nextInt();
		w = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		int l = 0;
		int r = Integer.MAX_VALUE / 2;
		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (check(mid)) l = mid;
			else r = mid;
		}
		System.out.println(l);
	}

	boolean check(int min) {
		int[] add = new int[n];
		int addWater = 0;
		int addAll = 0;
		for (int i = 0; i < n; i++) {
			// addしたインデックスからw離れたらその分を引く
			addWater -= (i - w >= 0) ? add[i - w] : 0;
			if (a[i] + addWater < min) {
				add[i] = min - (a[i] + addWater);
				addAll += add[i];
				addWater += add[i];
			}
			if (addAll > m) return false;
		}
		return addAll <= m;
	}

	public static void main(String[] args) {
		new C().run();
	}
}
