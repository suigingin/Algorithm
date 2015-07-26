import java.util.Scanner;

public class AOJ_0092 {
	Scanner sc = new Scanner(System.in);

	void run() {
		for (;;) {
			int n = sc.nextInt();
			if (n == 0) return;
			int[][] block = new int[n][n];
			for (int i = 0; i < n; i++) {
				String row = sc.next();
				for (int j = 0; j < n; j++) {
					block[i][j] = (row.charAt(j) == '*') ? 0 : 1;
				}
			}
			int max = 0;
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < n; j++) {
					if (block[i][j] == 0) continue;
					block[i][j] = Math.min(block[i - 1][j], Math.min(block[i - 1][j - 1], block[i][j - 1])) + 1;
					max = Math.max(max, block[i][j]);
				}
			}
			System.out.println(max);
		}
	}

	public static void main(String[] args) {
		new AOJ_0092().run();
	}
}
