public class PublicTransit {

	public int minimumLongestDistance(int R, int C) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				for (int k = i; k < R; k++) {
					for (int l = j; l < C; l++) {
						// teleport (i,j) <-> (k,l)
						int max = 0;
						// check all two point
						for (int sr = 0; sr < R; sr++) {
							for (int sc = 0; sc < C; sc++) {
								for (int tr = 0; tr < R; tr++) {
									for (int tc = 0; tc < C; tc++) {
										// (sr,sc) -> (tr,tc)
										int path1 = Math.abs(tr - sr) + Math.abs(tc - sc);
										int path2 = Math.abs(sr - i) + Math.abs(sc - j) + Math.abs(tr - k) + Math.abs(tc - l);
										int path3 = Math.abs(sr - k) + Math.abs(sc - l) + Math.abs(tr - i) + Math.abs(tc - j);
										max = Math.max(max, Math.min(path1, Math.min(path2, path3)));
									}
								}
							}
						}
						min = Math.min(min, max);
					}
				}
			}
		}
		return min;
	}
}
