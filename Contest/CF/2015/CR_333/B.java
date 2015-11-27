import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt() + 1;

		// two pointer
		int l = 0;
		int r = 0;
		int max = 0;
		int[] memo = new int[200000];
		while (l <= r) {
			// 2個差が存在しない限り進める
			while (r < n && memo[a[r] + 2] == 0 && memo[a[r] - 2] == 0) {
				memo[a[r]]++;
				max = Math.max(max, r - l + 1);
				r++;
			}

			// この段階でa[r]に対して2個差が存在 or rが右端に到達
			// 2個差がなくなるまでlを進める
			if (r >= n) break;
			while (l + 1 <= r && (memo[a[r] + 2] != 0 || memo[a[r] - 2] != 0)) {
				memo[a[l]]--;
				l++;
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
