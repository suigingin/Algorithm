import java.util.Arrays;

public class CorruptedMessage {
	public String reconstructMessage(String s, int k) {
		int l = s.length();
		int[] c = new int[26];
		for (int i = 0; i < s.length(); i++) {
			c[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (c[i] + k == l) {
				char[] res = new char[l];
				Arrays.fill(res, (char) (i + 'a'));
				return String.valueOf(res);
			}
		}
		return ":)";
	}
}
