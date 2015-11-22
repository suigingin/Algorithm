import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BearCavalry {
	final int MOD = 1000000007;

	public int countAssignments(int[] warriors, int[] horses) {
		long res = 0;
		int W = warriors.length;
		int H = horses.length;
		int top = warriors[0];
		int[] w = new int[W - 1];
		int[] h = new int[H];
		for (int i = 0; i < W - 1; i++) w[i] = warriors[i + 1];
		for (int i = 0; i < H; i++) h[i] = horses[i];
		Arrays.sort(w);
		Arrays.sort(h);
		for (int i = 0; i < H; i++) {
			// topがi番目のhorseを選ぶとする
			int Top = top * h[i];
			ArrayList<Integer> l = new ArrayList<Integer>();
			for (int j = 0; j < W - 1; j++) {
				int[] mul = new int[H - 1];
				for (int k = 0, index = 0; k < H; k++) {
					if (k == i) continue;
					mul[index++] = w[j] * h[k];
				}
				l.add(upper_bound(mul, Top - 1));
			}
			Collections.sort(l);
			long mul = 1;
			for (int j = 0; j < l.size(); j++) {
				if (l.get(j) - j <= 0) {
					mul = 0;
					break;
				}
				mul *= (l.get(j) - j);
				mul %= MOD;
			}
			if (mul > 0) {
				res = res + mul;
				res %= MOD;
			}
		}
		return (int) res % MOD;
	}

	// find minimum i (k < a[i])
	int upper_bound(int a[], int k) {
		int l = -1;
		int r = a.length;
		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (k < a[mid]) r = mid;
			else l = mid;
		}
		// r = l + 1
		return r;
	}
}
