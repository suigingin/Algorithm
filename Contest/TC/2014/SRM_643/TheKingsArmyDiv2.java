public class TheKingsArmyDiv2 {
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };

	public int getNumber(String[] state) {
		int R = state.length;
		int C = state[0].length();
		boolean happy = false;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (state[i].charAt(j) == 'H') {
					happy = true;
					for (int k = 0; k < 4; k++) {
						int nh = i + dy[k];
						int nw = j + dx[k];
						if (inner(nh, nw, R, C)) {
							if (state[nh].charAt(nw) == 'H') {
								return 0;
							}
						}
					}
				}
			}
		}
		return happy ? 1 : 2;
	}

	boolean inner(int h, int w, int limH, int limW) {
		return 0 <= h && h < limH && 0 <= w && w < limW;
	}
}
