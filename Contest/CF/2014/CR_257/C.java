import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();

		if (n + m - 2 < k) {
			System.out.println(-1);
			return;
		}

		long ans = 0;

		// cut n at first
		long nl = n;
		long ml = m;
		if (k <= n - 1) {
			nl = n / (k + 1);
		} else {
			nl = 1;
			ml = m / (k - (n - 1) + 1);
		}
		ans = Math.max(ans, nl * ml);

		// cut m at first
		nl = n;
		ml = m;
		if (k <= m - 1) {
			ml = m / (k + 1);
		} else {
			ml = 1;
			nl = n / (k - (m - 1) + 1);
		}
		ans = Math.max(ans, nl * ml);
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
