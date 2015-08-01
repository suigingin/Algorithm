import java.util.Scanner;

public class AOJ_0120 {
	Scanner sc = new Scanner(System.in);

	int N;
	double L;
	double[] r;
	double[][] memo;

	void run() {
		L: while (sc.hasNext()) {
			String[] in = sc.nextLine().split(" ");
			L = Double.valueOf(in[0]);
			N = in.length - 1;
			r = new double[N];
			for (int i = 0; i < N; i++) r[i] = Double.valueOf(in[i + 1]);

			memo = new double[N][1 << N];
			for (int i = 0; i < N; i++) {
				if (r[i] + tsp(i, 1 << i) <= L) {
					System.out.println("OK");
					continue L;
				}
			}
			System.out.println("NA");
		}
	}

	double tsp(int v, int mask) {
		if (memo[v][mask] != 0)   return memo[v][mask];
		if (mask == (1 << N) - 1) return r[v];

		double res = Double.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if ((mask & (1 << i)) != 0) continue;
			double rr = Math.sqrt((r[v] + r[i]) * (r[v] + r[i]) - (r[v] - r[i]) * (r[v] - r[i]));
			res = Math.min(res, rr + tsp(i, mask | 1 << i));
		}
		return memo[v][mask] = res;
	}

	public static void main(String[] args) {
		new AOJ_0120().run();
	}
}
