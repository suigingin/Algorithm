public class ProblemSets {
	public long maxSets(long E, long EM, long M, long MH, long H) {
		long right = Long.MAX_VALUE;
		long left = 0;
		while (right - left > 1) {
			long mid = (left + right) / 2;
			if (ok(mid, E, EM, M, MH, H)) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return left;
	}

	boolean ok(long t, long e, long eM, long m, long mH, long h) {
		if (t > e) eM -= t - e;
		if (eM < 0) return false;
		if (t > m + eM) mH -= t - (m + eM);
		if (mH < 0) return false;
		if (mH + h < t) return false;
		return true;
	}
}
