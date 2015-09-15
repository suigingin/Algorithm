import java.util.ArrayList;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	@SuppressWarnings("unchecked")
	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Character>[] l = new ArrayList[n];
		
		for (int i = 0; i < n; i++) {
			l[i] = new ArrayList<Character>();
			String row = sc.next();
			for (int j = 0; j < m; j++) l[i].add(row.charAt(j));
		}

		int cnt = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < l[i].size(); j++) {
				if (l[i].get(j) > l[i + 1].get(j)) {
					// remove
					removeColumn(l, j);
					i = -1;
					cnt++;
					break;
				} else if (l[i].get(j) == l[i + 1].get(j)) {
					// nothing
				} else {
					// lexicographically
					break;
				}
			}
		}
		System.out.println(cnt);
	}

	void removeColumn(ArrayList<Character>[] l, int c) {
		for (int i = 0; i < l.length; i++) {
			l[i].remove(c);
		}
	}

	public static void main(String[] args) {
		new C().run();
	}
}
