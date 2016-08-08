import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		StringBuilder s = new StringBuilder();
		int m = 0;
		for (int i = 0; i < n; i++) {
			boolean f = a[i] % 2 == 0 ? true : false;
			if (m == 1) m = f ? 2 : 1;
			else m = f ? 1 : 2;
			s.append(m + "\n");
		}
		System.out.print(s);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
