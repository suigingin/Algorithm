import java.util.Arrays;
import java.util.Scanner;

public class POJ_3258 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int L = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] d = new int[N + 2];
		for (int i = 0; i < N; i++) d[i] = sc.nextInt();
		d[N] = 0;
		d[N + 1] = L;
		Arrays.sort(d);
		int l = 0;
		int r = Integer.MAX_VALUE / 2;
		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (check(d, mid, M)) l = mid;
			else r = mid;
		}
		System.out.println(l);
	}

	boolean check(int[] d, int min, int M) {
		int now = d[0];
		for (int i = 1; i < d.length; i++) {
			if (d[i] - now < min) M--;
			else now = d[i];
		}
		return M >= 0;
	}

	public static void main(String[] args) {
		new POJ_3258().run();
	}
}
