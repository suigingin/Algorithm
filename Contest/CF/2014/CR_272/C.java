import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);
	final int MOD = 1000000007;

	void run() {
		long a = sc.nextLong();
		long b = sc.nextLong();
		long m = ((b - 1) * b / 2) % MOD;
		long sum = 0;
		for (long k = 1; k <= a; k++) {
			sum += ((b * k + 1) % MOD) * m;
			sum %= MOD;
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
