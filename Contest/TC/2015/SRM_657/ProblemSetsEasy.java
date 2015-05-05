public class ProblemSetsEasy {
	public int maxSets(int E, int EM, int M, int MH, int H) {
		for (int t = 200000; t >= 0; t--) {
			if (ok(t, E, EM, M, MH, H)) {
				return t;
			}
		}
		return 0;
	}

	boolean ok(int t, int E, int EM, int M, int MH, int H) {
		if (t > E)      EM -= t - E;
		if (EM < 0)     return false;
		if (t > M + EM) MH -= t - (M + EM);
		if (MH < 0)     return false;
		if (MH + H < t) return false;
		return true;
	}
}
