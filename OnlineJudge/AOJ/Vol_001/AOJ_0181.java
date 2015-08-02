import java.util.Scanner;

public class AOJ_0181 {
	Scanner sc = new Scanner(System.in);
	void run() {
		for (;;) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			if ((m | n) == 0) return;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) a[i] = sc.nextInt();
			int l = 0;
			int r = 1500001;
			while (r - l > 1) {
				int mid = (l + r) / 2;
				int width = 0;
				int mm = 1;
				boolean ok = false;
				for (int i = 0; i < n; i++) {
					if (width + a[i] > mid) {
						width = a[i];
						mm++;
					} else {
						width += a[i];
					}
					if (mm > m || a[i] > mid) break;
					if (i == n - 1) ok = true;
				}
				if(ok) r = mid;
				else   l = mid;
			}
			System.out.println(r);
		}
	}

	public static void main(String[] args) {
		new AOJ_0181().run();
	}
}
