import java.util.Scanner;

public class POJ_3104 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		int k = sc.nextInt();
		if (k == 1) {
			int max = 0;
			for (int i = 0; i < n; i++) max = Math.max(max, a[i]);
			System.out.println(max);
			return;
		}

		int l = 0;
		int r = Integer.MAX_VALUE / 2;
		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (check(a, k, mid)) r = mid;
			else l = mid;
		}
		System.out.println(r);
	}

	boolean check(int[] a, int k, int time) {
		long machine = time;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > time) {
				int need = (a[i] - time) / (k - 1);
				if ((a[i] - time) % (k - 1) != 0) need++;
				machine -= need;
			}
		}
		return machine >= 0;
	}

	public static void main(String[] args) {
		new POJ_3104().run();
	}
}
