import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int h = sc.nextInt();
		int w = sc.nextInt();
		char[][] f = new char[h][w];
		for (int i = 0; i < h; i++) {
			String line = sc.next();
			for (int j = 0; j < w; j++) f[i][j] = line.charAt(j);
		}
		int[][] dpH = new int[h][w];
		int[][] dpW = new int[h][w];
		for (int i = 0; i < w; i++) {
			for (int j = 1, cnt = 0; j < h; j++) {
				if (f[j - 1][i] == '.' && f[j][i] == '.') cnt++;
				dpH[j][i] = cnt;
			}
		}
		for (int i = 0; i < h; i++) {
			for (int j = 1, cnt = 0; j < w; j++) {
				if (f[i][j - 1] == '.' && f[i][j] == '.') cnt++;
				dpW[i][j] = cnt;
			}
		}
		int q = sc.nextInt();
		StringBuilder out = new StringBuilder();
		while (q-- > 0) {
			int r1 = sc.nextInt() - 1;
			int c1 = sc.nextInt() - 1;
			int r2 = sc.nextInt() - 1;
			int c2 = sc.nextInt() - 1;
			int res = 0;
			for (int i = c1; i <= c2; i++) res += dpH[r2][i] - dpH[r1][i];
			for (int i = r1; i <= r2; i++) res += dpW[i][c2] - dpW[i][c1];
			out.append(res + "\n");
		}
		System.out.print(out);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
