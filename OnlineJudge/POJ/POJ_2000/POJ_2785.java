import java.util.Arrays;
import java.util.Scanner;

public class POJ_2785 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		int[] c = new int[N];
		int[] d = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		int[] sum = new int[N * N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum[i * N + j] = a[i] + b[j];
			}
		}
		Arrays.sort(sum);
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int tmp = c[i] + d[j];
				cnt += upper_bound(sum, -tmp) - lower_bound(sum, -tmp);
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new POJ_2785().run();
	}

	// find minimum i (k <= a[i])
	int lower_bound(int a[], int k) {
		int l = -1;
		int r = a.length;
		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (k <= a[mid]) r = mid;
			else l = mid;
		}
		return r;
	}

	// find minimum i (k < a[i])
	int upper_bound(int a[], int k) {
		int l = -1;
		int r = a.length;
		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (k < a[mid]) r = mid;
			else l = mid;
		}
		return r;
	}
}
