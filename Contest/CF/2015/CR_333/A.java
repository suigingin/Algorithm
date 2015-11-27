import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int bx = sc.nextInt();
		long[] x = new long[n];
		for (int i = 0; i < n; i++) x[i] = sc.nextLong();
		int m = sc.nextInt();
		int by = sc.nextInt();
		long[] y = new long[m];
		for (int i = 0; i < m; i++) y[i] = sc.nextLong();
		long X = 0;
		long Y = 0;
		long base = 1;
		for (int i = n - 1; i >= 0; i--) {
			X += base * x[i];
			base *= bx;
		}
		base = 1;
		for (int i = m - 1; i >= 0; i--) {
			Y += base * y[i];
			base *= by;
		}
		System.out.println((X == Y) ? "=" : (X > Y) ? ">" : "<");
	}

	public static void main(String[] args) {
		new A().run();
	}
}
