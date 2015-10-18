import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		long n = sc.nextLong();
		long ans = 1;
		for (long i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				ans *= i;
				while (n % i == 0) n /= i;
			}
		}
		System.out.println(ans * n);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
