import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int q = sc.nextInt();
		int one = 0;
		int two = 1;
		while (q-- > 0) {
			int d = sc.nextInt();
			if (d == 1) {
				int move = sc.nextInt();
				one += move;
				two += move;
			} else {
				one = one + (one % 2 == 1 ? -1 : 1);
				two = two + (two % 2 == 1 ? -1 : 1);
			}
			one %= n;
			two %= n;
			if (one < 0) one = n + one;
			if (two < 0) two = n + two;

		}
		two--;
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) p[(i + one) % n] = i + 1;
			else            p[(i + two) % n] = i + 1;
		}
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < n; i++) s.append(p[i] + " ");
		System.out.println(s);
	}

	public static void main(String[] args) {
		new D().run();
	}
}
