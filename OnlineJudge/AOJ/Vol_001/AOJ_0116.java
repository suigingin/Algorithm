import java.util.Scanner;
import java.util.Stack;

public class AOJ_0116 {
	Scanner sc = new Scanner(System.in);

	void run() {
		for (;;) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			if ((H | W) == 0) return;

			int[][] f = new int[H][W + 1];
			for (int i = 0; i < H; i++) {
				String row = sc.next();
				for (int j = 0; j < W; j++) {
					if (i == 0) f[i][j] = (row.charAt(j) == '.') ? 1 : 0;
					else        f[i][j] = (row.charAt(j) == '.') ? f[i - 1][j] + 1 : 0;
				}
			}

			long area = 0;
			for (int h = 0; h < H; h++) {
				Stack<Rect> st = new Stack<Rect>();
				for (int i = 0; i < f[h].length; i++) {
					if (st.isEmpty() || st.peek().height < f[h][i]) st.push(new Rect(i, f[h][i]));
					else if (st.peek().height > f[h][i]) {
						int lastPos = 0;
						while (!st.isEmpty() && st.peek().height > f[h][i]) {
							Rect use = st.pop();
							area = Math.max(area, (i - use.pos) * use.height);
							lastPos = use.pos;
						}
						st.push(new Rect(lastPos, f[h][i]));
					}
				}
			}
			System.out.println(area);
		}
	}

	public static void main(String[] args) {
		new AOJ_0116().run();
	}

	class Rect {
		int pos;
		long height;

		public Rect(int pos, long height) {
			super();
			this.pos = pos;
			this.height = height;
		}
	}
}
