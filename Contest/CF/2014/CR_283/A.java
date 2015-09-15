import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void solve1() {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		int sub = 1000;
		for (int i = 1; i < n - 1; i++) {
			int max = 0;
			for (int j = 1; j < n - 1; j++) {
				if (j == i) max = Math.max(max, a[j + 1] - a[j - 1]);
				else        max = Math.max(max, a[j + 1] - a[j]);
			}
			sub = Math.min(sub, max);
		}
		System.out.println(sub);
	}

	void solve2() {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		int min = 1000;
		int max = 0;
		for (int i = 0; i < n - 2; i++) min = Math.min(min, a[i + 2] - a[i]);
		for (int i = 0; i < n - 1; i++) max = Math.max(max, a[i + 1] - a[i]);
		System.out.println(Math.max(min, max));
	}

	public static void main(String[] args) {
		new A().solve2();
	}
}
