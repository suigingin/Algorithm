import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int cnt = (n * n + 1) / 2;
		if (cnt < k) {
			System.out.println("NO");
			return;
		}
		char[][] f = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i % 2 == 0) {
					f[i][j] = (j % 2 == 0) ? 'L' : 'S';
				} else {
					f[i][j] = (j % 2 == 1) ? 'L' : 'S';
				}
			}
		}
		L: for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (cnt == k) {
					break L;
				}
				if (f[i][j] == 'L') {
					f[i][j] = 'S';
					cnt--;
				}
			}
		}
		out(f);
	}

	public static void main(String[] args) {
		new B().run();
	}

	void out(char[][] array) {
		StringBuilder sb = new StringBuilder("YES\n");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sb.append(array[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
