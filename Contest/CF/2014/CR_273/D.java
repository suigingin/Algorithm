import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);
	final int MOD = 1000000007;

	void run() {
		int r = sc.nextInt();
		int g = sc.nextInt();
		int h = 0;
		while (h * (h + 1) / 2 <= r + g) h++;
		h--;

		int[] pre = new int[r + 1];
		int[] next = new int[r + 1];
		pre[r] = 1;
		for (int i = 1; i <= h; i++) {
			for (int j = 0; j <= r; j++) {
				if (j + i <= r && pre[j + i] >= 1) {
					next[j] += pre[j + i];
					next[j] %= MOD;
				}
				int remGreen = r + g - j - (i - 1) * i / 2;
				if (pre[j] >= 1 && remGreen >= i) {
					next[j] += pre[j];
					next[j] %= MOD;
				}
			}
			for (int j = 0; j <= r; j++) {
				pre[j] = next[j];
				next[j] = 0;
			}
		}

		int ans = 0;
		for (int i = 0; i <= r; i++) {
			ans += pre[i];
			ans %= MOD;
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new D().run();
	}
}
