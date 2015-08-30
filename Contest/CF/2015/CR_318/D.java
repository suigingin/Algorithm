import java.util.Arrays;
import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] h = new int[n];
		for (int i = 0; i < n; i++) h[i] = sc.nextInt();

		int[] right = new int[n];
		int[] left = new int[n];
		right[0] = right[n - 1] = 1;
		left[0]  = left[n - 1]  = 1;
		for (int i = 1; i < n; i++)      right[i] = Math.min(right[i - 1] + 1, h[i]);
		for (int i = n - 2; i >= 0; i--) left[i]  = Math.min(left[i + 1] + 1, h[i]);

		int ans = 0;
		for (int i = 0; i < n; i++) ans = Math.max(ans, Math.min(right[i], left[i]));
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new D().run();
	}
}
