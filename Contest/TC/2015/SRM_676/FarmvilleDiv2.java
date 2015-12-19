import java.util.Arrays;

public class FarmvilleDiv2 {
	public int minTime(int[] time, int[] cost, int budget) {
		int N = time.length;
		Pair[] p = new Pair[N];
		for (int i = 0; i < N; i++) p[i] = new Pair(time[i], cost[i]);
		Arrays.sort(p);
		for (int i = 0; i < N; i++) {
			int sub = Math.min(p[i].time, budget / p[i].cost);
			p[i].time -= sub;
			budget -= sub * p[i].cost;
		}

		int res = 0;
		for (int i = 0; i < N; i++) res += p[i].time;
		return res;
	}

	class Pair implements Comparable<Pair> {

		int time;
		int cost;

		public Pair(int time, int cost) {
			super();
			this.time = time;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pair arg0) {
			return this.cost - arg0.cost;
		}
	}
}
