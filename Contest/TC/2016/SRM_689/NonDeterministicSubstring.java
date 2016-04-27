import java.util.HashSet;
import java.util.Set;

public class NonDeterministicSubstring {
	public long ways(String A, String B) {
		int al = A.length();
		int bl = B.length();
		Set<String> set = new HashSet<>();
		L :for (int i = 0; i < al; i++) {
			if (i + bl > al) break;
			for (int j = 0; j < bl; j++) {
				if(B.charAt(j) == '?') continue;
				if(A.charAt(i + j) != B.charAt(j)) continue L;
			}
			set.add(A.substring(i, i + bl));
		}
		return set.size();
	}
}
