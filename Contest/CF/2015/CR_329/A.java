import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		ArrayList<String> l = new ArrayList<String>();
		ArrayList<HashSet<Character>> st = new ArrayList<HashSet<Character>>();
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			HashSet<Character> set = new HashSet<Character>();
			for (int j = 0; j < s.length(); j++) {
				set.add(s.charAt(j));
				if (set.size() > 2) break;
			}
			if (set.size() <= 2) {
				l.add(s);
				st.add(set);
			}
		}
		int max = 0;
		// 選べるのはc1とc2のみからなる文字列
		for (char c1 = 'a'; c1 <= 'z'; c1++) {
			for (char c2 = c1; c2 <= 'z'; c2++) {
				int len = 0;
				for (int i = 0; i < l.size(); i++) {
					HashSet<Character> hs = st.get(i);
					boolean ok = true;
					for (char o = 'a'; o <= 'z'; o++) {
						if (o == c1 || o == c2) continue;
						if (hs.contains(o)) {
							ok = false;
							break;
						}
					}
					if (ok) len += l.get(i).length();
				}
				max = Math.max(max, len);
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
