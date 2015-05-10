import java.util.Arrays;

public class RandomPancakeStack {

	int N, rem;
	int[] d;
	boolean[] used;
	double[][] memo;

	public double expectedDeliciousness(int[] d) {
		this.d = d;
		N = d.length;
		used = new boolean[N];
		memo = new double[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(memo[i], -1);
		}
		rem = N;
		return dfs(N, N);
	}

	double dfs(int top, int rem) {
		if (top == 0) return 0;
		if (memo[top][rem] != -1) return memo[top][rem];
		double res = 0;
		for (int i = 0; i < top; i++) {
			if (used[i]) continue;
			used[i] = true;
			res += d[i] + dfs(i, rem - 1);
			used[i] = false;
		}
		return memo[top][rem] = res / rem;
	}
}
