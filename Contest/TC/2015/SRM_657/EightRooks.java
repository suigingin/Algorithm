public class EightRooks {
	public String isCorrect(String[] board) {
		int cnt = 0;
		boolean ok = true;
		boolean[] row = new boolean[8];
		boolean[] col = new boolean[8];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length(); j++) {
				if (board[i].charAt(j) == 'R') {
					cnt++;
					if (row[i] || col[j]) {
						ok = false;
					} else {
						row[i] = col[j] = true;
					}
				}
			}
		}
		return cnt == 8 && ok ? "Correct" : "Incorrect";
	}
}
