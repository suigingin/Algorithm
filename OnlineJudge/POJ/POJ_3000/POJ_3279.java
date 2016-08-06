import java.util.Scanner;

public class POJ_3279 {
	Scanner sc = new Scanner(System.in);
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };

	int H, W;

	void run() {
		H = sc.nextInt();
		W = sc.nextInt();
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
				for (int j = 0; j < H; j++) for (int k = 0; k < W; k++) sb.append(r[j][k]);
				if (cnt < min && minS.compareTo(sb.toString()) > 0) {
					min = cnt;
					minS = sb.toString();
					ans = r;
				}
			}
		}
		if (min == 2000) {
			System.out.println("IMPOSSIBLE");
		} else {
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
		for (int i = 0; i < H; i++)
			for (int j = 0; j < W; j++) {
				if (a[i][j] == 1) return false;
			}
		return true;
	}

	public static void main(String[] args) {
		new POJ_3279().run();
	}
	
	boolean inner(int h, int w, int limH, int limW) {
		return 0 <= h && h < limH && 0 <= w && w < limW;
	}
}
