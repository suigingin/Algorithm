import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		long[] x = new long[n];
		long[] y = new long[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextLong();
			y[i] = sc.nextLong();
		}
		long max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, Math.abs(x[i] - x[j]));
				max = Math.max(max, Math.abs(y[i] - y[j]));
			}
		}
		System.out.println(max * max);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
