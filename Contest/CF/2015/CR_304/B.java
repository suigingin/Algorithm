import java.util.Arrays;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		Arrays.sort(a);
		int add = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] == a[j]) {
					a[j]++;
					add++;
				}
			}
		}
		System.out.println(add);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
