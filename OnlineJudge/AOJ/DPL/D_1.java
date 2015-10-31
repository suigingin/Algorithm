import java.util.Arrays;
import java.util.Scanner;

public class D_1 {

	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();

		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE / 2);

		for (int i = 0; i < n; i++) {
			int insert = lower_bound(dp, a[i]);
			if (insert < n) dp[insert] = a[i];
		}
		System.out.println(lower_bound(dp, Integer.MAX_VALUE / 2));
	}

	// find minimum i (a[i] >= border)
	int lower_bound(int a[], int border) {
		int l = -1;
		int r = a.length;
		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (border <= a[mid]) {
				r = mid;
			} else {
				l = mid;
			}
		}
		// r = l + 1
		return r;
	}

	public static void main(String[] args) {
		new D_1().run();
	}
}
