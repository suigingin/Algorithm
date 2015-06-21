import java.util.Arrays;

public class B {
	MyScanner sc = new MyScanner();

	void run() {

		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] B = sc.nextInt2dArray(m, n);
		int[][] A = new int[m][n];

		for (int i = 0; i < m; i++) Arrays.fill(A[i], 1);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (B[i][j] == 0) {
					for (int k = 0; k < n; k++) A[i][k] = 0;
					for (int k = 0; k < m; k++) A[k][j] = 0;
				}
			}
		}

		int[][] makeB = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (A[i][j] == 1) {
					for (int k = 0; k < n; k++) makeB[i][k] = 1;
					for (int k = 0; k < m; k++) makeB[k][j] = 1;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (makeB[i][j] != B[i][j]) {
					System.out.println("NO");
					return;
				}
			}
		}
		StringBuilder out = new StringBuilder("YES\n");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) out.append(A[i][j] + " ");
			out.append("\n");
		}
		System.out.print(out);
	}

	public static void main(String[] args) {
		new B().run();
	}

	class MyScanner {
		int nextInt() {
			try {
				int c = System.in.read();
				while (c != '-' && (c < '0' || '9' < c))
					c = System.in.read();
				if (c == '-')
					return -nextInt();
				int res = 0;
				do {
					res *= 10;
					res += c - '0';
					c = System.in.read();
				} while ('0' <= c && c <= '9');
				return res;
			} catch (Exception e) {
				return -1;
			}
		}

		int[] nextIntArray(int n) {
			int[] in = new int[n];
			for (int i = 0; i < n; i++) {
				in[i] = nextInt();
			}
			return in;
		}

		int[][] nextInt2dArray(int n, int m) {
			int[][] in = new int[n][m];
			for (int i = 0; i < n; i++) {
				in[i] = nextIntArray(m);
			}
			return in;
		}
	}
}
