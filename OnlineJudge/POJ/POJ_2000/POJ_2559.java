import java.util.Scanner;
import java.util.Stack;

public class POJ_2559 {
	Scanner sc = new Scanner(System.in);

	void run() {
		for (;;) {
			int n = sc.nextInt();
			if (n == 0) return;
			int[] h = new int[n + 1];
			for (int i = 0; i < n; i++) h[i] = sc.nextInt();
			h[n] = 0;

			long area = 0;
			Stack<Rect> st = new Stack<Rect>();
			for (int i = 0; i <= n; i++) {
				if (st.isEmpty() || st.peek().height < h[i]) st.push(new Rect(i, h[i]));
				else if (st.peek().height > h[i]) {
					int lastPos = 0;
					while (!st.isEmpty() && st.peek().height > h[i]) {
						Rect use = st.pop();
						area = Math.max(area, (i - use.pos) * use.height);
						lastPos = use.pos;
					}
					st.push(new Rect(lastPos, h[i]));
				}
			}
			System.out.println(area);
		}
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

	public static void main(String[] args) {
		new POJ_2559().run();
	}
}
