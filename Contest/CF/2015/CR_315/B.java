package CR_315;

import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		boolean[] used = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			if (a[i] <= n && !used[a[i]]) used[a[i]] = true;
			else a[i] = -1;
		}
		int num = 1;
		for (int i = 0; i < n; i++) {
			if (a[i] == -1) {
				while (used[num]) num++;
				a[i] = num;
				used[num] = true;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) sb.append(a[i] + " ");
		System.out.println(sb);
	}

	public static void main(String[] args) {
		new B().run();
	}
}