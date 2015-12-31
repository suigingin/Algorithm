import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BearCavalry {
	final int MOD = 1000000007;

	public int countAssignments(int[] warriors, int[] h) {
		int N = warriors.length;
		int B = warriors[0];
		int[] w = new int[N - 1];
		long res = 0;
		for (int i = 1; i < N; i++) w[i - 1] = warriors[i];
		Arrays.sort(w);
		Arrays.sort(h);
		for (int i = 0; i < N; i++) {
			// Bがh[i]を選択
			int strength = B * h[i];
			ArrayList<Integer> l = new ArrayList<Integer>();
			for (int j = 0; j < N - 1; j++) {
				int lower = 0;
				for (int k = 0; k < N; k++) {
					if (i == k) continue;
					if (w[j] * h[k] >= strength) break;
					lower++;
				}
				l.add(lower);
			}
			Collections.sort(l);
			long add = 1;
			for (int j = 0; j < N - 1; j++) {
				if (l.get(j) - j <= 0) {
					add = 0;
					break;
				}
				add *= (l.get(j) - j);
				add %= MOD;
			}
			res += add;
			res %= MOD;
		}
		return (int) res;
	}
}
