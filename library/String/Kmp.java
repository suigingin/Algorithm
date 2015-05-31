public class Kmp {
	void kmp(String S, String W) {
		int[] next = new int[W.length()];
		for (int i = 1, k = 0; i < W.length(); i++) {
			while (k > 0 && W.charAt(k) != W.charAt(i)) k = next[k - 1];
			if (W.charAt(k) == W.charAt(i)) k++;
			next[i] = k;
		}

		for (int i = 0, k = 0; i < S.length(); i++) {
			while (k > 0 && W.charAt(k) != S.charAt(i)) k = next[k - 1];
			if (W.charAt(k) == S.charAt(i)) k++;
			if (k == W.length()) {
				System.out.println("match");
				k = next[k - 1];
			}
		}
	}
}
