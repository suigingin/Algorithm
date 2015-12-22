import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int h = sc.nextInt();
		long n = sc.nextLong();
		long cnt = 0;
		boolean toLeft = true;
		long l = 1;
		long r = (long) Math.pow(2, h);
		for (int i = h; i >= 0; i--) {
			long mid = (l + r) / 2;
			if (n <= mid) {
				if (toLeft) {
					cnt += 1;
					toLeft = !toLeft;
				} else {
					cnt += Math.pow(2, i);
				}
				r = mid;
			} else {
				if (toLeft) {
					cnt += Math.pow(2, i);
				} else {
					cnt += 1;
					toLeft = !toLeft;
				}
				l = mid + 1;
			}
		}
		System.out.println(cnt - 1);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
