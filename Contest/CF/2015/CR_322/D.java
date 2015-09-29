import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);

	int x1, y1, x2, y2, x3, y3;
	char[] X = { 'A', 'B', 'C' };

	void run() {
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		x2 = sc.nextInt();
		y2 = sc.nextInt();
		x3 = sc.nextInt();
		y3 = sc.nextInt();
		eightPattern();
	}

	void eightPattern() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					int A[] = { x1, y1 };
					int B[] = { x2, y2 };
					int C[] = { x3, y3 };
					if (i % 2 == 1) swap(A, 0, 1);
					if (j % 2 == 1) swap(B, 0, 1);
					if (k % 2 == 1) swap(C, 0, 1);
					if (getSquare(A, B, C, 0, 1, 2) || getSquare(B, C, A, 1, 2, 0) || getSquare(C, A, B, 2, 0, 1)) return;
				}
			}
		}
		System.out.println(-1);
	}

	boolean getSquare(int[] A, int[] B, int[] C, int p1, int p2, int p3) {

		StringBuilder out = new StringBuilder();
		int h = A[0] + B[0] + C[0];
		if (h == A[1] && h == B[1] && h == C[1]) {
			for (int i = 0; i < A[0]; i++) {
				for (int j = 0; j < h; j++) out.append(X[p1]);
				out.append("\n");
			}
			for (int i = 0; i < B[0]; i++) {
				for (int j = 0; j < h; j++) out.append(X[p2]);
				out.append("\n");
			}
			for (int i = 0; i < C[0]; i++) {
				for (int j = 0; j < h; j++) out.append(X[p3]);
				out.append("\n");
			}
			System.out.println(h);
			System.out.print(out);
			return true;
		} else if (B[0] == C[0]) {
			int w = B[1] + C[1];
			if (w == A[1] && w == A[0] + B[0]) {
				for (int i = 0; i < A[0]; i++) {
					for (int j = 0; j < w; j++) out.append(X[p1]);
					out.append("\n");
				}
				for (int i = 0; i < B[0]; i++) {
					for (int j = 0; j < B[1]; j++) out.append(X[p2]);
					for (int j = 0; j < C[1]; j++) out.append(X[p3]);
					out.append("\n");
				}
				System.out.println(w);
				System.out.print(out);
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		new D().run();
	}

	void swap(int[] x, int a, int b) {
		int tmp = x[a];
		x[a] = x[b];
		x[b] = tmp;
	}
}
