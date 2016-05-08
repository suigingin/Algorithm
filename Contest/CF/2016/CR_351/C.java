import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] t = new int[n];
		int[] r = new int[n + 1];
		for (int i = 0; i < n; i++) t[i] = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int[] c = new int[n + 1];
			int maxc = 0;
			int color = 0;
			for (int j = i; j < n; j++) {
				c[t[j]]++;
				if (c[t[j]] > maxc) {
					maxc = c[t[j]];
					color = t[j];
				} else if (c[t[j]] == maxc && color > t[j]) {
					color = t[j];
				}
				r[color]++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) sb.append(r[i] + " ");
		System.out.println(sb);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
