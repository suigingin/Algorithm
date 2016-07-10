public class MakingPairs {

	public int get(int[] card) {
		int res = 0;
		for (int i = 0; i < card.length; i++) res += card[i] / 2;
		return res;
	}
}
