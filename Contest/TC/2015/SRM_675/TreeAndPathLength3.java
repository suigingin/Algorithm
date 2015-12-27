import java.util.ArrayList;

public class TreeAndPathLength3 {
	public int[] construct(int s) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(0); l.add(1);
		l.add(1); l.add(2);
		l.add(2); l.add(3);
		if (s == 1) return makeResult(l);
		l.add(3); l.add(4);
		if (s == 2) return makeResult(l);
		int nextNode = 5;
		int simplePath = 2;
		int left = 1;
		int right = 1;
		boolean addLeft = true;
		while (simplePath < s) {
			if (addLeft) {
				l.add(1);
				l.add(nextNode++);
				left++;
			} else {
				l.add(2);
				l.add(nextNode++);
				right++;
			}
			simplePath = (left + 1) * right;
			addLeft = !addLeft;
		}
		nextNode--;
		l.remove(l.size() - 1);
		l.remove(l.size() - 1);
		simplePath = ((addLeft) ? (left + 1) * (right - 1) : left * right) + 1;
		l.add(4); l.add(nextNode);
		while (simplePath < s) {
			l.add(nextNode);
			l.add(++nextNode);
			simplePath++;
		}
		return makeResult(l);
	}

	int[] makeResult(ArrayList<Integer> l) {
		int[] res = new int[l.size()];
		for (int i = 0; i < l.size(); i++) {
			res[i] = l.get(i);
		}
		return res;
	}
}
