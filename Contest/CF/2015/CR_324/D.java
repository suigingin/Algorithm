import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		if (isPrime(N)) {
			System.out.println(1);
			System.out.println(N);
		} else {
			for (int q = N - 2; q >= 2; q -= 2) {
				if (isPrime(q)) {
					// N-qは偶数(N,qが奇数より)のためゴールドバッハの予想が成り立つ
					// (4以上の偶数は２つの素数の和で表すことができる)
					int even = N - q;
					if (even == 2) {
						System.out.println(2);
						System.out.println(2 + " " + q);
					} else {
						for (int i = 2; i <= even; i++) {
							if (isPrime(i) && isPrime(even - i)) {
								System.out.println(3);
								System.out.println(i + " " + (even - i) + " " + q);
								return;
							}
						}
					}
					return;
				}
			}
		}
	}

	boolean isPrime(int N) {
		if (N <= 1) return false;
		for (int i = 2; i * i <= N; i++) {
			if (N % i == 0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new D().run();
	}
}
