import java.util.Scanner;
import java.util.TreeSet;

public class C {
	Scanner sc = new Scanner(System.in);
	String s;
	int n;
	boolean[][] v;
	boolean[][] memo;
	TreeSet<String> set;

	void run() {
		s = sc.next();
		n = s.length();
		set = new TreeSet<>();
		v = new boolean[n + 5][5];
		memo = new boolean[n + 5][5];
		for (int i = 5; i < n; i++) {
			dfs(i, 2);
			dfs(i, 3);
		}
		System.out.println(set.size());
		for (String s : set) System.out.println(s);
	}

	boolean dfs(int i, int j) {
		if (i + j > n) return false;
		if (i + j == n) {
			set.add(s.substring(i, i + j));
			return true;
		}
		if (v[i][j]) return memo[i][j];
		v[i][j] = true;
		boolean ret = false;
		int nextP = i + j;
		if (j == 2) {
			if (dfs(nextP, 3) || (nextP + 2 <= n && !s.substring(i, i + 2).equals(s.substring(nextP, nextP + 2)) && dfs(nextP, 2))) {
				ret = true;
			}
		} else {
			if (dfs(nextP, 2) || (nextP + 3 <= n && !s.substring(i, i + 3).equals(s.substring(nextP, nextP + 3)) && dfs(nextP, 3))) {
				ret = true;
			}
		}
		if (ret) set.add(s.substring(i, i + j));
		return memo[i][j] = ret;
	}

	public static void main(String[] args) {
		new C().run();
	}
}
