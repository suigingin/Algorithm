import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int t = sc.nextInt() - 1;
		int[] a = new int[n - 1];
		for (int i = 0; i < n - 1; i++) a[i] = sc.nextInt();
		int now = 0;
		while (now < a.length) {
			now += a[now];
			if (now == t) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

	public static void main(String[] args) {
		new A().run();
	}
}
