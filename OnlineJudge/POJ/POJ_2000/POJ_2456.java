import java.util.Arrays;
import java.util.Scanner;

public class POJ_2456 {
	Scanner sc = new Scanner(System.in);
	int N, C;
	int[] x;

	void run() {
		N = sc.nextInt();
		C = sc.nextInt();
		x = new int[N];
		for (int i = 0; i < N; i++) x[i] = sc.nextInt();
		Arrays.sort(x);

		int l = -1;
		int r = 1000000000;

		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (check(mid)) l = mid;
			else r = mid;
		}
		System.out.println(l);
	}

	boolean check(int D) {
		int c = C - 1;
		int prev = x[0];
		for (int i = 1; i < N; i++) {
			if (x[i] - prev >= D) {
				c--;
				prev = x[i];
			}
		}
		return c <= 0 ? true : false;
	}

	public static void main(String[] args) {
		new POJ_2456().run();
	}
}
