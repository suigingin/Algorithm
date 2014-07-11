import java.util.Arrays;
import java.util.Scanner;

public class dikstr {

	Scanner sc = new Scanner(System.in);
	int M = 10000;

	void run() {
		int n = sc.nextInt(); //町の数
		int m = sc.nextInt(); //道の本数

		int start = sc.nextInt();
		int terminal = sc.nextInt();

		int dist[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], M);
		}
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			dist[s][t] = sc.nextInt();
		}
		
		// Dikstra
		int p = 0;
		int length[] = new int[m]; // minimum distance
		int v[] = new int[m]; // decision flag
		for (int k = 0; k < n; k++) {
			length[k] = M;
			v[k] = 0;
		}
		length[start] = 0;
		for (int i = 0; i < n; i++) {
			int min = M;// 最小の節点を探す
			for (int k = 0; k < n; k++) {
				if (v[k] == 0 && length[k] < min) {
					p = k;
					min = length[k];
				}
			}
			// 確定フラグ
			v[p] = 1;
			// pを経由してkに至長さがそれまでの最短経路より小さければ更新
			for (int k = 0; k < n; k++) {
				if ((length[p] + dist[p][k]) < length[k]) {
					length[k] = length[p] + dist[p][k];
				}
			}
		}
		System.out.println(length[terminal]);
	}

	public static void main(String[] args) {
		new dikstr().run();
	}

	void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
}

