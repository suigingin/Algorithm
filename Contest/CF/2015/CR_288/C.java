import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int m = sc.nextInt();
		int t = sc.nextInt();
		int r = sc.nextInt();
		int[] w = new int[1000];
		for (int i = 0; i < m; i++) w[400 + sc.nextInt()] = 1;
		if (t < r) {
			System.out.println(-1);
			return;
		}
		int ans = 0;
		boolean[] add = new boolean[1000];
		for (int i = 0; i < 1000; i++) {
			if (w[i] > 0) {
				int cnt = 0;
				for (int j = i - 1; j >= i - t; j--) if (add[j]) cnt++;
				if (cnt >= r) continue;
				for (int j = i - 1; j >= i - t; j--) {
					if (!add[j]) {
						add[j] = true;
						cnt++;
						ans++;
					}
					if (cnt == r) break;
				}
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
