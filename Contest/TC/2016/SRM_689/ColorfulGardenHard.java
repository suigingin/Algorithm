import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ColorfulGardenHard {
	final int MOD = 1000000007;
	String a, b;
	int n;
	int[][] memo;

	public int count(String garden, String forbid) {
		a = garden;
		b = forbid;
		n = garden.length();
		memo = new int[n + 1][1 << n];
		for (int i = 0; i <= n; i++) Arrays.fill(memo[i], -1);
		return bitDp(0, n);
	}

	int bitDp(int mask, int prev) {
		int depth = Integer.bitCount(mask);
		if (depth == n) return 1;
		if (memo[prev][mask] != -1) return memo[prev][mask];
		int res = 0;
		Set<Character> v = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if ((mask & 1 << i) > 0 || a.charAt(i) == b.charAt(depth)) continue;
			if (!v.contains(a.charAt(i)) && (prev == n || a.charAt(i) != a.charAt(prev))) {
				v.add(a.charAt(i));
				res += bitDp(mask | 1 << i, i);
				res %= MOD;
			}
		}
		return memo[prev][mask] = res;
	}
}
