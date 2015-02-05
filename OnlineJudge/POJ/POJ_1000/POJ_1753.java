import java.util.HashSet;
import java.util.LinkedList;

public class POJ_1753 {
	MyScanner sc = new MyScanner();
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };

	void run() {
		String start = "";
		for (int i = 0; i < 4; i++) {
			start += sc.next();
		}
		LinkedList<String> que = new LinkedList<String>();
		HashSet<String> set = new HashSet<String>();
		que.add(start);
		set.add(start);
		int cnt = 0;
		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				String now = que.poll();
				boolean allw = true;
				boolean allb = true;
				for (int j = 0; j < now.length(); j++) {
					if (now.charAt(j) == 'w') {
						allb = false;
					}
					if (now.charAt(j) == 'b') {
						allw = false;
					}
				}
				if (allb || allw) {
					System.out.println(cnt);
					return;
				}
				for (int j = 0; j < 16; j++) {
					char[][] tmp = new char[4][4];
					for (int k = 0; k < 16; k++) {
						tmp[k / 4][k % 4] = now.charAt(k);
					}
					int h = j / 4;
					int w = j % 4;
					tmp[h][w] = (tmp[h][w] == 'b') ? 'w' : 'b';
					for (int l = 0; l < 4; l++) {
						int nh = h + dy[l];
						int nw = w + dx[l];
						if (inner(nh, nw, 4, 4)) {
							tmp[nh][nw] = (tmp[nh][nw] == 'b') ? 'w' : 'b';
						}
					}
					StringBuilder next = new StringBuilder();
					for (int l = 0; l < 4; l++) {
						next.append(String.valueOf(tmp[l]));
					}
					if (!set.contains(next.toString())) {
						set.add(next.toString());
						que.add(next.toString());
					}
				}
			}
			cnt++;
		}
		System.out.println("Impossible");
	}

	public static void main(String[] args) {
		new POJ_1753().run();
	}

	boolean inner(int h, int w, int limH, int limW) {
		return 0 <= h && h < limH && 0 <= w && w < limW;
	}

	class MyScanner {

		String next() {
			try {
				StringBuilder res = new StringBuilder("");
				int c = System.in.read();
				while (Character.isWhitespace(c))
					c = System.in.read();
				do {
					res.append((char) c);
				} while (!Character.isWhitespace(c = System.in.read()));
				return res.toString();
			} catch (Exception e) {
				return null;
			}
		}

		char[][] nextCharField(int n, int m) {
			char[][] in = new char[n][m];
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < m; j++) {
					in[i][j] = s.charAt(j);
				}
			}
			return in;
		}
	}
}
