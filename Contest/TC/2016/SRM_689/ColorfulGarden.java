import java.util.Arrays;

public class ColorfulGarden {
	public String[] rearrange(String[] garden) {
		String[] res = new String[2];
		res[0] = res[1] = "";
		int n = garden[0].length();
		int[] c = new int[26];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				c[garden[i].charAt(j) - 'a']++;
			}
		}
		Pair[] p = new Pair[26];
		for (int i = 0; i < 26; i++) p[i] = new Pair((char) ('a' + i), c[i]);
		Arrays.sort(p);
		if (p[1].cnt == 0) return new String[0];
		res[0] += p[0].color; p[0].cnt--;
		res[1] += p[1].color; p[1].cnt--;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				boolean put = false;
				for (int k = 0; k < 26; k++) {
					if (j == 0) {
						if (res[0].charAt(i - 1) != p[k].color && p[k].cnt > 0) {
							res[0] += p[k].color;
							p[k].cnt--;
							put = true;
							break;
						}
					} else {
						if (res[1].charAt(i - 1) != p[k].color && res[0].charAt(i) != p[k].color && p[k].cnt > 0) {
							res[1] += p[k].color;
							p[k].cnt--;
							put = true;
							break;
						}
					}
				}
				if (!put) return new String[0];
				Arrays.sort(p);
			}
		}
		return res;
	}

	class Pair implements Comparable<Pair> {

		char color;
		int cnt;

		public Pair(char color, int cnt) {
			super();
			this.color = color;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Pair arg0) {
			return arg0.cnt - this.cnt;
		}
	}
}
