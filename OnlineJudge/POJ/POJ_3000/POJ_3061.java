import java.util.Scanner;

public class POJ_3061 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int S = sc.nextInt();
			int[] a = new int[N];
			for (int i = 0; i < N; i++) a[i] = sc.nextInt();
			int min = Integer.MAX_VALUE;
			int sum = 0;
			for (int l = 0, r = 0; r < N; r++) {
				sum += a[r];
				while (l <= r && sum >= S) {
					min = Math.min(min, r - l + 1);
					sum -= a[l++];
				}
			}
			System.out.println(min == Integer.MAX_VALUE ? 0 : min);
		}
	}

	public static void main(String[] args) {
		new POJ_3061().run();
	}
}
