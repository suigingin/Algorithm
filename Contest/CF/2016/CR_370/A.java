import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		for (int i = 0; i < n - 1; i++) System.out.print(a[i] + a[i + 1] + " ");
		System.out.println(a[n - 1]);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
