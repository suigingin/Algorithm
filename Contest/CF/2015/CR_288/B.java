import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		char[] c = sc.next().toCharArray();
		int n = c.length;
		int last = c[n - 1] - '0';
		for (int i = 0; i < n - 1; i++) {
			int d = c[i] - '0';
			if (d % 2 == 0 && d < last) {
				swap(c, i, n - 1);
				System.out.println(String.valueOf(c));
				return;
			}
		}
		for (int i = n - 2; i >= 0; i--) {
			int d = c[i] - '0';
			if (d % 2 == 0 && d >= last) {
				swap(c, i, n - 1);
				System.out.println(String.valueOf(c));
				return;
			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) {
		new B().run();
	}

	void swap(char[] x, int a, int b) {
		char tmp = x[a];
		x[a] = x[b];
		x[b] = tmp;
	}
}
