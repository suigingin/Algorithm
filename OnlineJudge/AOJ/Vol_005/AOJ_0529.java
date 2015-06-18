import java.util.Arrays;
import java.util.Scanner;

public class AOJ_0529 {
	Scanner sc = new Scanner(System.in);

	void run() {
		for (;;) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			if ((N | M) == 0)
				return;

			long[] p = new long[N + 1];
			long[] t = new long[(N + 2) * (N + 1) / 2];
			int index = 0;
			for (int i = 1; i <= N; i++) p[i] = sc.nextLong();
			for (int i = 0; i <= N; i++) {
				for (int j = i; j <= N; j++) {
					t[index++] = p[i] + p[j];
				}
			}
			Arrays.sort(t);

			long max = 0;
			for (int i = 0; i < t.length; i++) {
				long border = M - t[i];
				if (border < 0) continue;
				int later = binarySearch(t, border);
				max = Math.max(max, t[i] + t[later]);
			}
			System.out.println(max);
		}
	}

	int binarySearch(long[] t, long border) {
		int l = -1;
		int r = t.length;
		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (t[mid] <= border) l = mid;
			else r = mid;
		}
		return l;
	}

	public static void main(String[] args) {
		new AOJ_0529().run();
	}
}
