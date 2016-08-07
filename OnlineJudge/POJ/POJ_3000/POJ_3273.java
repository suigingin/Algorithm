import java.util.Scanner;

public class POJ_3273 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) a[i] = sc.nextInt();
		int l = 0;
		int r = Integer.MAX_VALUE / 2;
		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (check(a, mid, M)) r = mid;
			else l = mid;
		}
		System.out.println(r);
	}

	boolean check(int[] a, int min, int M) {
		int g = 1;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > min) return false;
			if (sum + a[i] > min) {
				g++;
				sum = a[i];
			} else {
				sum += a[i];
			}
		}
		return g <= M;
	}

	public static void main(String[] args) {
		new POJ_3273().run();
	}
}
