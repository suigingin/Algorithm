import java.util.Scanner;

public class AOJ_0516 {
	Scanner sc = new Scanner(System.in);

	void run() {
		for (;;) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			if ((n | k) == 0) return;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) a[i] = sc.nextInt();
			int tmp = 0;
			int ans = -Integer.MAX_VALUE / 2;
			for (int i = 0; i < k; i++) tmp += a[i];
			for (int i = k; i < n; i++) {
				tmp += a[i];
				tmp -= a[i - k];
				ans = Math.max(ans, tmp);
			}
			System.out.println(ans);
		}
	}

	public static void main(String[] args) {
		new AOJ_0516().run();
	}
}
