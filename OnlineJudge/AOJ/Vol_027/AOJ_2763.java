import java.util.Scanner;

public class AOJ_2763 {
	Scanner sc = new Scanner(System.in);

	void run() {
		String s = sc.next();
		int N = s.length();
		RollingHash rh = new RollingHash();
		rh.init(s);
		int ans = Integer.MAX_VALUE;
		String res = "mitomerarenaiWA";
		int l = 0;
		int r = 0;
		for (int i = 0; i < N; i++) {
			int t = N - (i + 1) * 3;
			if (t > 0 && t % 2 == 0) {
				int A = i + 1;
				int B = t / 2;
				long a1 = rh.getHash1(0, A - 1);
				long b1 = rh.getHash1(A, A + B - 1);
				long a2 = rh.getHash1(A + B, A + B + A - 1);
				long b2 = rh.getHash1(A + B + A, A + B + A + B - 1);
				long a3 = rh.getHash1(A + B + A + B, N - 1);
				if (a1 == a2 && a2 == a3 && b1 == b2) {
					ans = Math.min(ans, i + t);
					l = A;
					r = B;
				}
			}
		}
		if (l != 0 && r != 0) res = "Love " + s.substring(0, l) + s.substring(l, l + r) + "!";
		System.out.println(res);
	}

	public class RollingHash {

		String S;
		int N, l, r;

		long B1 = 1007;
		long B2 = 1009;
		long H1 = 1000000007;
		long H2 = 1000000009;

		long[] Base1, Base2;
		long[] Hash1, Hash2;

		void init(String s) {
			S = s;
			N = s.length();
			l = 0;
			r = s.length() - 1;
			Base1 = new long[N + 1];
			Base2 = new long[N + 1];
			Hash1 = new long[N];
			Hash2 = new long[N];

			Base1[0] = Base2[0] = 1;
			Hash1[0] = Hash2[0] = s.charAt(0);
			for (int i = 1; i <= N; i++) Base1[i] = (Base1[i - 1] * B1) % H1;
			for (int i = 1; i <= N; i++) Base2[i] = (Base2[i - 1] * B2) % H2;
			for (int i = 1; i < N; i++) Hash1[i] = (Hash1[i - 1] * B1 + s.charAt(i)) % H1;
			for (int i = 1; i < N; i++) Hash2[i] = (Hash2[i - 1] * B2 + s.charAt(i)) % H2;
		}

		long getHash1(int l, int r) {
			long res = Hash1[r] - ((l == 0) ? 0 : Hash1[l - 1] * Base1[r - l + 1]);
			if (res < 0) res = (res + ((-res / H1) + 1) * H1) % H1;
			return res;
		}
	}

	public static void main(String[] args) {
		new AOJ_2763().run();
	}
}
