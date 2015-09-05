import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < n; i++) x[i] = sc.nextInt();
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			int max = 0;
			if (i == 0) {
				min = x[i + 1] - x[0];
				max = x[n - 1] - x[0];
			} else if (i == n - 1) {
				min = x[i] - x[i - 1];
				max = x[i] - x[0];
			} else {
				min = Math.min(x[i + 1] - x[i], x[i] - x[i - 1]);
				max = Math.max(x[n - 1] - x[i], x[i] - x[0]);
			}
			out.append(min + " " + max + "\n");
		}
		System.out.print(out);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
