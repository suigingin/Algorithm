import java.util.Collections;
import java.util.PriorityQueue;

public class Istr {
	public int count(String s, int k) {
		int[] c = new int[26];
		for (int i = 0; i < s.length(); i++) c[s.charAt(i) - 'a']++;
		PriorityQueue<Integer> que = new PriorityQueue<Integer>(1, Collections.reverseOrder());
		for (int i = 0; i < 26; i++) que.add(c[i]);
		while (k-- > 0) que.add(que.poll() - 1);
		int res = 0;
		for (int val : que) res += val * val;
		return res;
	}
}
