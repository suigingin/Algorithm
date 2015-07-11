import java.util.ArrayList;

public class ExactTreeEasy {
	public int[] getTree(int n, int m) {
		int[] res = new int[2 * (n - 1)];
		ArrayList<Integer> node = new ArrayList<Integer>();

		for (int i = 0; i < n - m; i++) {
			node.add(i);
			node.add(i + 1);
		}
		for (int i = 1; i < m; i++) {
			node.add(n - m);
			node.add(n - m + i);
		}
		for (int i = 0; i < node.size(); i++) res[i] = node.get(i);
		return res;
	}
}
