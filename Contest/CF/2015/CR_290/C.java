import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	HashMap<Character, Integer> indeg;
	HashSet<Character> V;
	HashMap<Character, HashSet<Character>> G;
	ArrayList<Character> res;

	void run() {
		indeg = new HashMap<Character, Integer>();
		V = new HashSet<Character>();
		G = new HashMap<Character, HashSet<Character>>();
		res = new ArrayList<Character>();
		for (char c = 'a'; c <= 'z'; c++) {
			indeg.put(c, 0);
			G.put(c, new HashSet<Character>());
		}
		int n = sc.nextInt();
		String[] s = new String[n];
		for (int i = 0; i < n; i++) s[i] = sc.next();
		for (int i = 0; i < n - 1; i++) {
			String s1 = s[i];
			String s2 = s[i + 1];
			int mm = Math.min(s1.length(), s2.length());
			boolean diff = false;
			for (int j = 0; j < mm; j++) {
				if (s1.charAt(j) != s2.charAt(j)) {
					diff = true;
					HashSet<Character> set = G.get(s1.charAt(j));
					if (!set.contains(s2.charAt(j))) {
						set.add(s2.charAt(j));
						G.put(s1.charAt(j), set);
						indeg.put(s2.charAt(j), indeg.get(s2.charAt(j)) + 1);
					}
					break;
				}
			}
			if (!diff && s1.length() > s2.length()) {
				System.out.println("Impossible");
				return;
			}
		}
		if (!topologicalSort()) System.out.println("Impossible");
		else {
			StringBuilder out = new StringBuilder();
			for (int i = 0; i < 26; i++) out.append(res.get(i));
			System.out.println(out);
		}
	}

	boolean topologicalSort() {
		for (char u = 'a'; u <= 'z'; u++) {
			if (indeg.get(u) == 0 && !V.contains(u)) {
				bfs(u);
			}
		}
		if (res.size() < 26) return false;
		return true;
	}

	void bfs(char s) {
		LinkedList<Character> que = new LinkedList<Character>();
		V.add(s);
		que.add(s);
		while (!que.isEmpty()) {
			char u = que.poll();
			res.add(u);
			for (Character v : G.get(u)) {
				indeg.put(v, indeg.get(v) - 1);
				if (indeg.get(v) == 0 && !V.contains(v)) {
					que.add(v);
					V.add(v);
				}
			}
		}
	}

	public static void main(String[] args) {
		new C().run();
	}
}
