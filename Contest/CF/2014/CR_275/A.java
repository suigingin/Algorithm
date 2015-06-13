import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		long l = sc.nextLong();
		long r = sc.nextLong();
		for (long a = l; a <= r; a++) {
			for (long b = a + 1; b <= r; b++) {
				for (long c = b + 1; c <= r; c++) {
					if (gcd(a, b) == 1 && gcd(b, c) == 1 && gcd(a, c) != 1) {
						System.out.println(a + " " + b + " " + c);
						return;
					}
				}
			}
		}
		System.out.println(-1);
	}

	long gcd(long a, long b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
