import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		if (n == 1) {
			System.out.println(1);
			return;
		}
		int res = 0;
		if (n % 2 == 1) {
			if (m < (n / 2) + 1) res = m + 1;
			else res = m - 1;
		} else {
			if (m <= n / 2) res = m + 1;
			else res = m - 1;
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
