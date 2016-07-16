import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] id = new int[n];
		for (int i = 0; i < n; i++) id[i] = sc.nextInt();
		for (long i = 1; i <= n; i++) {
			long sum = (i * (i + 1)) / 2;
			if (k <= sum) {
				k -= ((i - 1) * i) / 2;
				System.out.println(id[k - 1]);
				break;
			}
		}
	}

	public static void main(String[] args) {
		new B().run();
	}
}
