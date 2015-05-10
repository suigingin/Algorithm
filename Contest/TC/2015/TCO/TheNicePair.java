public class TheNicePair {

	public int solve(int[] A) {
		int max = -1;
		for (int d = 2; d <= 1000; d++) {
			for (int left = 0; left < A.length; left++) {
				int cnt = 0;
				for (int rignt = left; rignt < A.length; rignt++) {
					if (A[rignt] % d == 0) {
						cnt++;
					}
					int num = rignt - left + 1;
					if (cnt >= (num + 1) / 2) {
						max = Math.max(max, rignt - left);
					}
				}
			}
		}
		return max;
	}
}
