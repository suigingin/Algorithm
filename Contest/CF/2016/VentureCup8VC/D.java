import java.util.Arrays;
import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		Arrays.sort(a);
		long[] d = new long[5002];
		long[] c = new long[5002];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				d[a[j] - a[i]]++;
			}
		}
		for (int i = 5000; i > 0; i--) c[i] = c[i + 1] + d[i];

		double ans = 0;
		for (int i = 1; i <= 5000; i++) {
			if (d[i] > 0) {
				for (int j = 1; j <= 5000; j++) {
					if(d[j] > 0 && i + j <= 5000) ans += d[i] * d[j] * c[i + j + 1];
				}
			}
		}
		ans /= Math.pow(n * (n - 1) / 2, 3);
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new D().run();
	}
}
