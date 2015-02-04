import java.util.Arrays;

public class POJ_1989 {
	MyScanner sc = new MyScanner();

	void run() {
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0;
		int ans = 1;
		boolean[] use = new boolean[K];
		while (N-- > 0) {
			int num = sc.nextInt() - 1;
			if (!use[num]) {
				use[num] = true;
				cnt++;
				if (cnt == K) {
					cnt = 0;
					ans++;
					Arrays.fill(use, false);
				}
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new POJ_1989().run();
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
	}
}
