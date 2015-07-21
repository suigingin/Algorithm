import java.util.HashSet;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n];

		int max = 0;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			max = Math.max(max, a[i]);
		}
		int[] step = new int[max + 1];
		int[] cnt = new int[max + 1];

		// a[i] -> 各値 への最短step数を記録
		HashSet<Integer> v = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = a[i], cost = 0; j <= max; j *= 2, cost++) {
				cnt[j]++;
				step[j] += cost;
				v.add(j);
			}
			for (int j = a[i] / 2, cost = 1; j >= 1; j /= 2, cost++) {
				cnt[j]++;
				step[j] += cost;
				v.add(j);
				for (int k = j * 2, c = 1; !v.contains(k) && k <= max; k *= 2, c++) {
					cnt[k]++;
					step[k] += cost + c;
					v.add(k);
				}
			}
			v.clear();
		}

		int min = Integer.MAX_VALUE / 2;
		for (int i = 1; i <= max; i++) {
			if (cnt[i] == n) min = Math.min(min, step[i]);
		}
		System.out.println(min);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
