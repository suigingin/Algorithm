import java.util.Arrays;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] f = new int[n];
		for (int i = 0; i < n; i++) f[i] = sc.nextInt();
		int min = 0;
		Arrays.sort(f);
		for (int i = n - 1; i >= 0; i -= k) min += (f[i] - 1) * 2;
		System.out.println(min);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
