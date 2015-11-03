import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[101];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		int stay = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] == 1 || a[i - 1] == 1 && a[i + 1] == 1) {
				stay++;
			}
		}
		System.out.println(stay);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
