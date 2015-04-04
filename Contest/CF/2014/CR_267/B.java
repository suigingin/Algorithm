import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	@SuppressWarnings("unused")
	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();

		int[] army = new int[m];
		for (int i = 0; i < m; i++) {
			army[i] = sc.nextInt();
		}

		int fedor = sc.nextInt();
		int ans = 0;
		for (int i = 0; i < m; i++) {
			if (Integer.bitCount(army[i] ^ fedor) <= k) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
