import java.util.Scanner;

public class POJ_1050 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int[][] a = new int[N][N];
		for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) a[i][j] = sc.nextInt();
		int max = a[0][0];
		int[][] sumH = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j == 0) sumH[j][i] = a[j][i];
				else        sumH[j][i] = sumH[j - 1][i] + a[j][i];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				int dp = a[0][0];
				for (int k = 0; k < N; k++) {
					if (i == 0) dp = Math.max(dp + sumH[j][k], sumH[j][k]);
					else        dp = Math.max(dp + sumH[j][k] - sumH[i - 1][k], sumH[j][k] - sumH[i - 1][k]);
					max = Math.max(max, dp);
				}
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		new POJ_1050().run();
	}
}
