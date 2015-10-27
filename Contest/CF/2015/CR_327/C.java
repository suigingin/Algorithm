import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n + 2];
		for (int i = 1; i <= n; i++) a[i] = sc.nextInt();
		a[0] = a[1];
		a[n + 1] = a[n];
		int max = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] != a[i + 1] && a[i + 1] != a[i + 2]) {
				int l = i;
				int cnt = 2;
				i += 2;
				while (i + 1 <= n && a[i] != a[i + 1]) {
					cnt++;
					i++;
				}
				if (cnt % 2 == 0) {
					for (int j = l; j <= i; j++) a[j] = a[l];
				} else {
					for (int j = l; j <= l + (i - l) / 2; j++) a[j] = a[l];
					for (int j = l + (1 + i - l) / 2; j <= i; j++) a[j] = a[i];
				}
				max = Math.max(max, cnt / 2);
			}
		}
		StringBuilder out = new StringBuilder();
		for (int i = 1; i <= n; i++) out.append(a[i] + " ");
		System.out.println(max);
		System.out.println(out);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
