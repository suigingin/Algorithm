import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		if (k - n <= 0 || n == 4) {
			System.out.println(-1);
			return;
		}

		int[] t = new int[n];
		boolean[] v = new boolean[n + 1];
		v[a] = v[b] = v[c] = v[d] = true;
		t[0] = a;
		t[1] = c;
		t[n - 2] = d;
		t[n - 1] = b;
		for (int i = 2; i < n - 2; i++) {
			for (int j = 1; j <= n; j++) {
				if (!v[j]) {
					t[i] = j;
					v[j] = true;
					break;
				}
			}
		}

		StringBuilder s = new StringBuilder();

		for (int i = 0; i < n; i++) s.append(t[i] + " ");
		s.append("\n");

		s.append(c + " " + a + " ");
		for (int i = 2; t[i] != d; i++) s.append(t[i] + " ");
		s.append(b + " " + d + "\n");

		System.out.print(s);
	}

	public static void main(String[] args) {
		new D().run();
	}
}
