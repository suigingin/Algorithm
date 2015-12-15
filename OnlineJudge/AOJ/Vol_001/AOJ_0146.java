import java.util.ArrayList;
import java.util.Scanner;

public class AOJ_0146 {
	Scanner sc = new Scanner(System.in);
	int INF = Integer.MAX_VALUE / 10;
	int N;
	int[] num, dist, cnt;
	Res[][] memo;

	void run() {
		N = sc.nextInt();
		memo = new Res[N][1 << N];
		num = new int[N];
		dist = new int[N];
		cnt = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
			dist[i] = sc.nextInt();
			cnt[i] = sc.nextInt() * 20;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 1 << N; j++) {
				memo[i][j] = new Res(INF, -1);
			}
		}
		int minIndex = 0;
		double min = INF;
		for (int i = 0; i < N; i++) {
			double tmp = bitDp(i, 1 << i, cnt[i]);
			if (tmp < min) {
				min = tmp;
				minIndex = i;
			}
		}
		ArrayList<Integer> l = new ArrayList<Integer>();
		int mask = 1 << minIndex;
		l.add(minIndex);
		while (mask != (1 << N) - 1) {
			int next = memo[minIndex][mask].next;
			l.add(next);
			mask |= 1 << next;
			minIndex = next;
		}
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < N; i++) out.append((i == 0 ? "" : " ") + num[l.get(i)]);
		System.out.println(out);
	}

	double bitDp(int v, int mask, int gather) {
		if (memo[v][mask].min != INF) return memo[v][mask].min;
		if (mask == (1 << N) - 1) return 0;
		double res = INF;
		for (int i = 0; i < N; i++) {
			if ((mask & (1 << i)) == 0) {
				double tmp = bitDp(i, mask | 1 << i, gather + cnt[i]) + Math.abs(dist[v] - dist[i]) / (2000.0 / (70.0 + gather));
				if (tmp < res) {
					res = tmp;
					memo[v][mask].next = i;
				}
			}
		}
		return memo[v][mask].min = res;
	}

	class Res {
		double min;
		int next;

		/**
		 * @param min
		 * @param next
		 */
		public Res(double min, int next) {
			super();
			this.min = min;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		new AOJ_0146().run();
	}
}
