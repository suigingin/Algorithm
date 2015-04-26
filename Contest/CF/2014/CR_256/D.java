import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);

	void run() {
		long n = sc.nextLong();
		long m = sc.nextLong();
		long k = sc.nextLong();
		long right = Long.MAX_VALUE;
		long left = 0;
		while (right - left > 1) {
			long mid = (left + right) / 2;
			long cnt = 0;
			long w = m;
			for (int i = 1; i <= n; i++) {
				while (w != 0 && w * i > mid) {
					w--;
				}
				cnt += w;
			}
			if (cnt < k) {
				left = mid;
			} else {
				right = mid;
			}
		}
		System.out.println(right);
	}

	public static void main(String[] args) {
		new D().run();
	}
}
