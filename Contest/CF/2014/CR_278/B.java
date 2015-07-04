import java.util.Arrays;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[4];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		Arrays.sort(a);
		if (n == 4) {
			System.out.println(check(a[0], a[1], a[2], a[3]) ? "YES" : "NO");
		} else if (n == 3) {
			for (int i = 1; i <= 2000; i++) {
				int[] aa = { i, a[1], a[2], a[3] };
				Arrays.sort(aa);
				if (check(aa[0], aa[1], aa[2], aa[3])) {
					System.out.println("YES");
					System.out.println(i);
					return;
				}
			}
			System.out.println("NO");
		} else if (n == 2) {
			for (int i = 1; i <= 2000; i++) {
				for (int j = 1; j <= 2000; j++) {
					int[] aa = { i, j, a[2], a[3] };
					Arrays.sort(aa);
					if (check(aa[0], aa[1], aa[2], aa[3])) {
						System.out.println("YES");
						System.out.println(i);
						System.out.println(j);
						return;
					}
				}
			}
			System.out.println("NO");
		} else if (n == 1) {
			System.out.println("YES");
			System.out.println(a[3]);
			System.out.println(a[3] * 3);
			System.out.println(a[3] * 3);
		} else {
			System.out.println("YES");
			System.out.println("1");
			System.out.println("1");
			System.out.println("3");
			System.out.println("3");
		}
	}

	boolean check(double a, double b, double c, double d) {
		if ((a + b + c + d) / 4 == (b + c) / 2 && (b + c) / 2 == d - a) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		new B().run();
	}
}
