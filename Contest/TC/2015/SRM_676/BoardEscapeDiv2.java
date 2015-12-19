public class BoardEscapeDiv2 {
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };

	public String findWinner(String[] s, int k) {
		int R = s.length;
		int C = s[0].length();
		int sr = 0;
		int sc = 0;
		L: for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (s[i].charAt(j) == 'T') {
					sr = i;
					sc = j;
					break L;
				}
			}
		}
		// 1. can move
		// 2. one step goal
		boolean can = false;
		boolean one = false;
		for (int i = 0; i < 4; i++) {
			int nr = sr + dy[i];
			int nc = sc + dx[i];
			if (inner(nr, nc, R, C) && s[nr].charAt(nc) != '#') can = true;
			if (inner(nr, nc, R, C) && s[nr].charAt(nc) == 'E') one = true;
		}
		if (one)  return "Alice";
		if (!can) return "Bob";

		// 2stepでゴールできないルートがあるか
		boolean noTwoStep = false;
		for (int i = 0; i < 4; i++) {
			int nr = sr + dy[i];
			int nc = sc + dx[i];
			if (inner(nr, nc, R, C) && s[nr].charAt(nc) != '#') {
				boolean reach = false;
				for (int j = 0; j < 4; j++) {
					int nr2 = nr + dy[j];
					int nc2 = nc + dx[j];
					if (inner(nr2, nc2, R, C) && s[nr2].charAt(nc2) == 'E') reach = true;
				}
				if (!reach) noTwoStep = true;
			}
		}

		// 必ず2stepでゴールできてしまう
		if (!noTwoStep && k > 1) {
			return "Bob";
		} else {
			return k % 2 == 0 ? "Bob" : "Alice";
		}
	}

	boolean inner(int h, int w, int limH, int limW) {
		return 0 <= h && h < limH && 0 <= w && w < limW;
	}
}
