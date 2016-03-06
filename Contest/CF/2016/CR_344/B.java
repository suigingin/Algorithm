import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int rN[] = new int[n];
		int rC[] = new int[n];
		int cN[] = new int[m];
		int cC[] = new int[m];
		for (int i = 0; i < k; i++) {
			int c = sc.nextInt();
			int p = sc.nextInt();
			int a = sc.nextInt();
			if (c == 1) {
				rN[p - 1] = a;
				rC[p - 1] = i + 1;
			} else {
				cN[p - 1] = a;
				cC[p - 1] = i + 1;
			}
		}
		StringBuilder o = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				o.append((rC[i] >= cC[j] ? rN[i] : cN[j]) + " ");
			}
			o.append("\n");
		}
		System.out.print(o);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
