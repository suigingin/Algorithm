import java.util.Arrays;
import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int l = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();

		int cnt = 0;
		StringBuilder sb = new StringBuilder();

		if (!find(a, x)) {
			cnt++;
			sb.append(x + " ");
		}
		if (!find(a, y)) {
			cnt++;
			sb.append(y);
		}

		if (cnt == 2) {
			L: for (int i = 0; i < n; i++) {
				int[] add = { a[i] + x, a[i] - x, a[i] + x, a[i] - x, a[i] + y, a[i] - y, a[i] + y, a[i] - y };
				int[] move = { y, y, -y, -y, x, x, -x, -x };
				for (int j = 0; j < 8; j++) {
					if (0 <= add[j] && add[j] <= l && Arrays.binarySearch(a, add[j] + move[j]) >= 0) {
						sb.setLength(0);
						sb.append(add[j]);
						cnt--;
						break L;
					}
				}
			}
		}

		sb.insert(0, cnt + (cnt > 0 ? "\n" : ""));
		System.out.println(sb);
	}

	boolean find(int[] a, int obj) {
		for (int i = 0; i < a.length; i++) {
			if (Arrays.binarySearch(a, a[i] + obj) >= 0) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		new D().run();
	}
}
