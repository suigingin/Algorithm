import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		for (int i = 0; i < n; i++) {
			while (a[i] % 2 == 0) a[i] /= 2;
			while (a[i] % 3 == 0) a[i] /= 3;
		}
		for (int i = 0; i < n - 1; i++) {
			if (a[i] != a[i + 1]) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}

	public static void main(String[] args) {
		new C().run();
	}
}
