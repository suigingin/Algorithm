import java.util.Stack;

public class Histgram {

	// ヒストグラムの最大面積を返す
	// -前提条件
	// ・負のグラフには対応していない
	// ・ｈ[n]は0:番兵
	long getMaxArea(int[] h) {
		long area = 0;
		Stack<Rect> st = new Stack<Rect>();
		for (int i = 0; i <= h.length; i++) {
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
		return area;
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
