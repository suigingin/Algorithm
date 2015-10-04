import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		boolean[] ok = new boolean[n];
		int turn = 0;
		int info = 0;
		while (info < n) {
			if (turn % 2 == 0) {
				for (int i = 0; i < n; i++) {
					if (!ok[i] && a[i] <= info) {
						ok[i] = true;
						info++;
					}
				}
			} else {
				for (int i = n - 1; i >= 0; i--) {
					if (!ok[i] && a[i] <= info) {
						ok[i] = true;
						info++;
					}
				}
			}
			turn++;
		}
		System.out.println(turn - 1);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
