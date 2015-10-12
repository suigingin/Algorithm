import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);
	final int MOD = 1000000007;

	void run() {
		int n = sc.nextInt();
		long A = 3;
		long B = 7;
		long rA = getPow(A, 3 * n);
		long rB = getPow(B, n);
		System.out.println((rA - rB + MOD) % MOD);
	}

	long getPow(long n, int m) {
		long res = 1;
		while (m > 0) {
			if ((m & 1) == 1) {
				res = (res * n) % MOD;
			}
			n = (n * n) % MOD;
			m >>= 1;
		}
		return res;
	}

	public static void main(String[] args) {
		new B().run();
	}
}
