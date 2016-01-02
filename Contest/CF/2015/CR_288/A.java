import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		boolean[][] f = new boolean[n][m];
		int res = 0;
		for (int i = 1; i <= k; i++) {
			int h = sc.nextInt() - 1;
			int w = sc.nextInt() - 1;
			f[h][w] = true;
			if (h + 1 < n && w + 1 < m)   if (f[h][w + 1] && f[h + 1][w] && f[h + 1][w + 1]) res = i;
			if (h - 1 >= 0 && w + 1 < m)  if (f[h][w + 1] && f[h - 1][w] && f[h - 1][w + 1]) res = i;
			if (h - 1 >= 0 && w - 1 >= 0) if (f[h][w - 1] && f[h - 1][w] && f[h - 1][w - 1]) res = i;
			if (h + 1 < n && w - 1 >= 0)  if (f[h][w - 1] && f[h + 1][w] && f[h + 1][w - 1]) res = i;
			if (res != 0) break;
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
