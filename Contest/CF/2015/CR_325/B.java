import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a1 = new int[n - 1];
		int[] a2 = new int[n - 1];
		int[] b = new int[n];

		for (int i = 0; i < n - 1; i++) a1[i] = sc.nextInt();
		for (int i = 0; i < n - 1; i++) a2[i] = sc.nextInt();
		for (int i = 0; i < n; i++) b[i] = sc.nextInt();

		// i番目の要素 = i番目のmainAvenueを渡った時のコスト
		int[] go = new int[n];

		for (int i = 0; i < n; i++) {
			// i番目で渡る
			go[i] += b[n - 1 - i];
			for (int j = 0; j < n - 1; j++) {
				if (j >= i) go[i] += a1[n - 2 - j];
				else go[i] += a2[n - 2 - j];
			}
		}

		int min = Integer.MAX_VALUE / 2;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				min = Math.min(min, go[i] + go[j]);
			}
		}
		System.out.println(min);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
