import java.util.Arrays;

public class BiconnectedDiv1 {
	int[] w1, w2, memo;

	public int minimize(int[] q1, int[] q2) {
		int cost = 0;
		w1 = q1;
		w2 = q2;
		memo = new int[w1.length];
		Arrays.fill(memo, -1);
		for (int i = 0; i < w1.length; i++) cost += w1[i];
		for (int i = 0; i < w2.length; i++) cost += w2[i];
		return cost - solve(1);
	}

	int solve(int pos) {
		if (pos >= w1.length - 1) return 0;
		if (pos >= w2.length - 1) return w1[pos];
		if (memo[pos] != -1) return memo[pos];
		int res = 0;
		res = Math.max(res, solve(pos + 1) + w1[pos]);
		res = Math.max(res, solve(pos + 2) + w2[pos]);
		return memo[pos] = res;
	}
}
