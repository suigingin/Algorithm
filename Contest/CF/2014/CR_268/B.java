import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int p = sc.nextInt();
		int q = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		boolean[] ok = new boolean[1001];
		for (int i = 0; i < p; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for (int j = a; j <= b; j++) ok[j] = true;
		}
		int cnt = 0;
		int[][] x = new int[q][2];
		for (int i = 0; i < q; i++) {
			x[i][0] = sc.nextInt();
			x[i][1] = sc.nextInt();
		}

		L: for (int w = l; w <= r; w++) {
			for (int i = 0; i < q; i++) {
				for (int j = x[i][0]; j <= x[i][1]; j++) {
					if (j + w <= 1000 && ok[j + w]) {
						cnt++;
						continue L;
					}
				}
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
