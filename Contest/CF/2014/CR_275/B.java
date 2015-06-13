import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);
	int cnt1, cnt2, x, y;

	void run() {
		cnt1 = sc.nextInt();
		cnt2 = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		long l = -1;
		long r = Long.MAX_VALUE - 1;
		while (r - l > 1) {
			long mid = (l + r) / 2;
			if (check(mid)) r = mid;
			else l = mid;
		}
		System.out.println(r);
	}

	boolean check(long v) {
		long[] f = { v / x, v / y };
		long both = v / (x * y);
		long free = v - (f[0] + f[1] - both);

		f[0] -= both;
		f[1] -= both;

		long[] to = { cnt1 - f[1], cnt2 - f[0] };
		if (to[0] < 0) to[0] = 0;
		if (to[1] < 0) to[1] = 0;

		return to[0] + to[1] <= free;
	}

	public static void main(String[] args) {
		new B().run();
	}
}
