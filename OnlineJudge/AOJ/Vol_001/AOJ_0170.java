import java.util.Scanner;

public class AOJ_0170 {
	Scanner sc = new Scanner(System.in);

	int n;
	double G;
	Item[] item;
	int[] perm, ans;
	boolean[] used;

	void run() {
		for (;;) {
			n = sc.nextInt();
			if (n == 0) return;
			item = new Item[n];
			ans = new int[n];
			perm = new int[n];
			used = new boolean[n];
			G = Double.MAX_VALUE;

			for (int i = 0; i < n; i++) item[i] = new Item(sc.next(), sc.nextInt(), sc.nextInt());

			permutation(0, 0);

			for (int i = n - 1; i >= 0; i--) System.out.println(item[ans[i]].name);
		}
	}

	void permutation(int pos, int weight) {
		if (pos == n) {
			double tmp = 0;
			for (int i = 0; i < n; i++) tmp += item[perm[i]].w * (n - i);
			if (tmp / weight < G) {
				G = tmp / weight;
				for (int i = 0; i < n; i++) ans[i] = perm[i];
			}
		}
		for (int i = 0; i < n; i++) {
			if (!used[i]) {
				if (weight > item[i].s) {
					return;
				} else {
					perm[pos] = i;
					used[i] = true;
					permutation(pos + 1, weight + item[i].w);
					used[i] = false;
				}
			}
		}
	}
	
	class Item {
		String name;
		int w;
		int s;

		public Item(String name, int w, int s) {
			super();
			this.name = name;
			this.w = w;
			this.s = s;
		}
	}

	public static void main(String[] args) {
		new AOJ_0170().run();
	}
}
