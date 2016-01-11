import java.util.Arrays;
import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] f = new char[n][m];
		for (int i = 0; i < n; i++) Arrays.fill(f[i], '.');
		boolean left = true;
		int row = 0;
		while (row < n) {
			Arrays.fill(f[row], '#');
			if (row + 1 < n) f[row + 1][left ? m - 1 : 0] = '#';
			row += 2;
			left = !left;
		}
		out(f);
	}

	public static void main(String[] args) {
		new A().run();
	}

	void out(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
}
