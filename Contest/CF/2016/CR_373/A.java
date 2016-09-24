import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();

		if (a[n - 1] == 15) {
			System.out.println("DOWN");
			return;
		}

		if (a[n - 1] == 0) {
			System.out.println("UP");
			return;
		}

		if (n == 1) {
			System.out.println(-1);
			return;
		}
		
		System.out.println((a[n-1] > a[n-2])  ? "UP" : "DOWN");
	}

	public static void main(String[] args) {
		new A().run();
	}
}
