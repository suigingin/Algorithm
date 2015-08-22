import java.util.Arrays;
import java.util.Scanner;

public class AOJ_0299 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int M = sc.nextInt();
		int p = sc.nextInt();
		int[] d = new int[M + 1];
		for (int i = 0; i < M; i++) d[i] = sc.nextInt();
		d[M] = p;
		Arrays.sort(d);
		int min = Integer.MAX_VALUE;
		int start = Arrays.binarySearch(d, p);
		for (int i = 0; i <= M; i++) {
			// to right
			int right = 0;
			if (start + i > M) {
				right += N - d[start];
				right += d[(start + i) % (M + 1)];
			} else {
				right += d[start + i] - d[start];
			}
			// to left
			int left = 0;
			if (start + i + 1 > M) {
				left += d[start] - d[(start + i + 1) % (M + 1)];
			} else {
				left += d[start];
				left += N - d[(start + i + 1) % (M + 1)];
			}
			min = Math.min(min, Math.min(right * 2 + left, right + left * 2));
		}
		System.out.println(min * 100);
	}

	public static void main(String[] args) {
		new AOJ_0299().run();
	}
}
