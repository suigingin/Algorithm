import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[][] t = new int[n][n];
		t[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i + 1 < n) t[i + 1][j] += t[i][j];
				if (j + 1 < n) t[i][j + 1] += t[i][j];
			}
		}
		System.out.println(t[n - 1][n - 1]);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
