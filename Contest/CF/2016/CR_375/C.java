import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		int[] c = new int[m];
		int[] f = new int[m + 1];

		// 配列aにおける値[1-m]の要素数をそれぞれMまで増やす
		int M = n / m;
		int C = 0;

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			if (a[i] <= m) c[a[i] - 1]++;
			else f[m]++;
		}
		for (int i = 0; i < m; i++) {
			if (c[i] - M > 0) f[i] = c[i] - M;
		}

		for (int i = 0, j = 0; i < n; i++) {
			while (j < m && c[j] >= M) j++;
			if (f[a[i] <= m ? (a[i] - 1) : m] > 0 && j < m) {
				f[a[i] <= m ? (a[i] - 1) : m]--;
				C++;
				a[i] = (j + 1);
				c[j]++;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(M + " " + C + "\n");
		for (int i = 0; i < n; i++) sb.append(a[i] + " ");
		System.out.println(sb);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
