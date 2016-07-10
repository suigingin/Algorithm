import java.util.HashSet;
import java.util.Set;

public class DistinguishableSetDiv2 {
	public int count(String[] s) {
		int cnt = 0;
		int n = s.length;
		int m = s[0].length();
		for (int i = 0; i < (1 << m); i++) {
			Set<String> set = new HashSet<>();
			for (int j = 0; j < n; j++) {
				String t = "";
				for (int k = 0; k < m; k++) {
					if ((i & 1 << k) > 0) t += s[j].charAt(k);
				}
				set.add(t);
			}
			if (set.size() == n) cnt++;
		}
		return cnt;
	}
}
