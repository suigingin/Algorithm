public class WaterTank {
	int N;

	public double minOutputRate(int[] t, int[] x, int C) {
		N = t.length;
		long[] tt = new long[N], xx = new long[N];
		for (int i = 0; i < N; i++) tt[i] = t[i];
		for (int i = 0; i < N; i++) xx[i] = x[i];
		double left = 0;
		double right = 1000000;
		for (int m = 0; m < 100; m++) {
			double mid = (left + right) / 2;
			if (check(tt, xx, C, mid)) right = mid;
			else left = mid;
		}
		return right;
	}

	boolean check(long[] t, long[] x, int C, double out) {
		double water = 0;
		for (int i = 0; i < N; i++) {
			water += x[i] * t[i];
			water -= out * t[i];
			if (water < 0) water = 0;
			if (water > C) return false;
		}
		return true;
	}
}
