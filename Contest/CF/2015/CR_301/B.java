import java.util.ArrayList;

public class B {
	MyScanner sc = new MyScanner();

	@SuppressWarnings("unused")
	void run() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int p = sc.nextInt();
		int x = sc.nextInt(); // not exceed
		int y = sc.nextInt(); // median not low
		int[] a = sc.nextIntArray(k);

		int need = n / 2 + 1;
		int cnt = 0;
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += a[i];
			if (a[i] >= y) {
				cnt++;
			}
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while (ans.size() < n - k) {
			if (cnt < need) {
				ans.add(y);
				sum += y;
				cnt++;
			} else {
				ans.add(1);
				sum++;
			}
		}
		if (sum <= x && cnt >= need) {
			for (int ele : ans) {
				System.out.print(ele + " ");
			}
		} else {
			System.out.println(-1);
		}
	}

	public static void main(String[] args) {
		new B().run();
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
