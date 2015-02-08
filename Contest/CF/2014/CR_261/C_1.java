import java.util.ArrayList;

public class C_1 {
	MyScanner sc = new MyScanner();

	ArrayList<int[]> list;
	int n, k, d;

	void run() {
		n = sc.nextInt();
		k = sc.nextInt();
		d = sc.nextInt();
		list = new ArrayList<int[]>();
		int tmp = 1;
		boolean ok = false;
		for (int i = 0; i < d; i++) {
			tmp *= k;
			if (tmp >= n) {
				ok = true;
				break;
			}
		}
		if (!ok) {
			System.out.println(-1);
			return;
		}
		generate(0, new int[d]);
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < n; j++) {
				out.append(list.get(j)[i] + " ");
			}
			out.append("\n");
		}
		System.out.print(out);
	}

	void generate(int depth, int a[]) {
		if (depth == d) {
			int[] add = a.clone();
			list.add(add);
			return;
		}

		for (int i = 1; i <= k; i++) {
			if (list.size() >= n) {
				return;
			}
			a[depth] = i;
			generate(depth + 1, a);
		}
	}

	public static void main(String[] args) {
		new C_1().run();
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
