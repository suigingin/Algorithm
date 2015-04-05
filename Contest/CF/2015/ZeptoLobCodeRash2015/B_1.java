import java.util.Arrays;

public class B_1 {
	MyScanner sc = new MyScanner();

	int n, num, max, cnt;
	int[] path;
	int[] need;

	void run() {
		n = sc.nextInt();
		num = (int) Math.pow(2, n + 1) - 2;
		path = sc.nextIntArray(num);

		need = new int[num];
		Arrays.fill(need, Integer.MAX_VALUE);
		max = 0;
		cnt = 0;
		dfs(0, 0, 1);

		int left = (int) Math.pow(2, n) - 2;
		int right = left + (int) Math.pow(2, n);
		for (int i = left; i < right; i++) {
			need[i] = max - need[i];
		}
		for (int i = left; i < right; i++) {
			updateMin(i);
		}
		dfs2(0, 0, 1);
		System.out.println(cnt);
	}

	void dfs(int d, int sum, int now) {
		if (d == n) {
			need[now - 2] = sum;
			max = Math.max(max, sum);
			return;
		}
		dfs(d + 1, sum + path[now * 2 - 2], now * 2);
		dfs(d + 1, sum + path[now * 2 - 1], now * 2 + 1);
	}

	void dfs2(int d, int add, int now) {
		if (d == n) {
			return;
		}
		int left = now * 2;
		int right = now * 2 + 1;
		need[now * 2 - 2] -= add;
		need[now * 2 - 1] -= add;
		cnt += need[now * 2 - 2];
		cnt += need[now * 2 - 1];
		dfs2(d + 1, add + need[now * 2 - 2], left);
		dfs2(d + 1, add + need[now * 2 - 1], right);
	}

	void updateMin(int i) {
		while (i - 1 > 0) {
			i = (i - 2) / 2;
			need[i] = Math.min(need[i * 2 + 2], need[i * 2 + 3]);
		}
	}

	public static void main(String[] args) {
		new B_1().run();
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
	}
}
