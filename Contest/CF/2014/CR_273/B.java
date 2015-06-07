import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();

		long max = (n - m + 1) * (n - m) / 2;
		long minc1 = n / m;
		long minc2 = n % m;

		// n%m team -> n/m+1 men 
		// m-n%m team -> n/m men 
		long min = 0;
		min += minc2 * (minc1 + 1) * minc1 / 2;
		min += (m - minc2) * (minc1 - 1) * minc1 / 2;
		System.out.println(min + " " + max);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
