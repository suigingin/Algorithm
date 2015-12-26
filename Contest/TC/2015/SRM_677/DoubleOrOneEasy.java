public class DoubleOrOneEasy {
	public int minimalSteps(int a, int b, int newA, int newB) {
		if (newA < a || newB < b) return -1;
		// newA,newB -> a,b
		int cnt = 0;
		int ans = Integer.MAX_VALUE;
		while (true) {
			if (newA < a || newB < b) break;
			if (newA - a == newB - b) ans = Math.min(ans, (cnt + newA - a));
			if (newA % 2 != newB % 2) break;
			if (newA % 2 == 0 && newB % 2 == 0) {
				newA /= 2;
				newB /= 2;
			} else {
				newA--;
				newB--;
			}
			cnt++;
		}
		if (ans == Integer.MAX_VALUE) return -1;
		else return ans;
	}
}
