import java.util.Scanner;

public class POJ_1222 {
	Scanner sc = new Scanner(System.in);
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };
	int H = 5;
	int W = 6;

	void run() {
		int N = sc.nextInt();
		for (int m = 1; m <= N; m++) {
			System.out.println("PUZZLE #" + m);
			int[][] f = new int[H][W];
			for (int i = 0; i < H; i++) for (int j = 0; j < W; j++) f[i][j] = sc.nextInt();
			int min = 2000;
			int[][] ans = new int[H][W];
			String minS = "2";

			for (int i = 0; i < 1 << W; i++) {
				int cnt = 0;
				int[][] c = arrayCopy(f);
				int[][] r = new int[H][W];
				for (int j = 0; j < W; j++) {
					if ((i & 1 << j) > 0) {
						cnt++;
						r[0][j] = 1;
						flip(c, 0, j);
					}
				}
				for (int j = 1; j < H; j++) {
					for (int k = 0; k < W; k++) {
						if (c[j - 1][k] == 1) {
							cnt++;
							r[j][k] = 1;
							flip(c, j, k);
						}
					}
				}
				if (isAllClear(c)) {
					StringBuilder sb = new StringBuilder();
					for (int j = 0; j < W; j++) sb.append(r[0][j]);
					if (cnt < min && minS.compareTo(sb.toString()) > 0) {
						min = cnt;
						minS = sb.toString();
						ans = r;
					}
				}
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) System.out.print(j != 0 ? " " + ans[i][j] : ans[i][j]);
				System.out.println();
			}
		}
	}

	void flip(int a[][], int h, int w) {
		a[h][w] ^= 1;
		for (int i = 0; i < 4; i++) {
			int nh = h + dy[i];
			int nw = w + dx[i];
			if (inner(nh, nw, H, W)) a[nh][nw] ^= 1;
		}
	}

	int[][] arrayCopy(int a[][]) {
		int[][] b = new int[H][W];
		for (int i = 0; i < H; i++) for (int j = 0; j < W; j++) b[i][j] = a[i][j];
		return b;
	}

	boolean isAllClear(int a[][]) {
		for (int j = 0; j < W; j++) if (a[H - 1][j] == 1) return false;
		return true;
	}

	public static void main(String[] args) {
		new POJ_1222().run();
	}

	boolean inner(int h, int w, int limH, int limW) {
		return 0 <= h && h < limH && 0 <= w && w < limW;
	}
}
