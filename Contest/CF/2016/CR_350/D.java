import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		for (int i = 0; i < n; i++) b[i] = sc.nextInt();

		long l = -1;
		long r = Integer.MAX_VALUE - 10;
		while (r - l > 1) {
			long mid = (l + r) / 2;
			if (check(mid, k, a, b)) l = mid;
			else r = mid;
		}
		System.out.println(l);
	}

	boolean check(long cnt, long k, int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			long make = b[i] / a[i];
			long rem = b[i] % a[i];
			if (make < cnt) k -= (cnt - make) * a[i] - rem;
			if (k < 0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new D().run();
	}
}
