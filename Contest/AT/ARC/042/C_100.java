import java.util.Arrays;
import java.util.Scanner;

public class C_100 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int P = sc.nextInt();
		Pair[] p = new Pair[N];
		for (int i = 0; i < N; i++) p[i] = new Pair(sc.nextInt(), sc.nextInt());
		Arrays.sort(p);

		int ans = 0;
		int[] dp = new int[P + p[0].a + 1];
		for (int i = 0; i < N; i++) {
			for (int j = P + p[i].a; j >= p[i].a; j--) {
				dp[j] = Math.max(dp[j], dp[j - p[i].a] + p[i].b);
				ans = Math.max(ans, dp[j]);
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new C_100().run();
	}

	class Pair implements Comparable<Pair> {

		int a;
		int b;

		public Pair(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair arg0) {
			if (this.a == arg0.a) {
				return -(this.b - arg0.b);
			}
			return -(this.a - arg0.a);
		}
	}
}
