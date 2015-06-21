import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();

		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					if (a[j] < min) {
						min = a[j];
						minIndex = j;
					}
				}
			}
			if (minIndex != i) {
				cnt++;
				swap(a, i, minIndex);
				sb.append(i + " " + minIndex + "\n");
			}
		}
		System.out.println(cnt);
		if (cnt != 0) System.out.print(sb);
	}

	public static void main(String[] args) {
		new A().run();
	}

	void swap(int[] x, int a, int b) {
		int tmp = x[a];
		x[a] = x[b];
		x[b] = tmp;
	}
}
