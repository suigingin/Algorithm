import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		long a = sc.nextLong();
		if (a <= 2) {
			System.out.println(-1);
		} else if (a % 2 == 0) {
			long m = a / 2;
			System.out.println((m * m - 1) + " " + (m * m + 1));
		} else {
			long m = (a + 1) / 2;
			long n = a - m;
			System.out.println((2 * m * n) + " " + (m * m + n * n));
		}
	}

	public static void main(String[] args) {
		new C().run();
	}
}
