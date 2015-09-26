import java.util.ArrayList;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] w = new int[n];
		int[] book = new int[m];
		for (int i = 0; i < n; i++) w[i] = sc.nextInt();
		for (int i = 0; i < m; i++) book[i] = sc.nextInt() - 1;
		ArrayList<Integer> l = new ArrayList<Integer>();
		boolean[] use = new boolean[n];
		for (int i = 0; i < m; i++) {
			if (!use[book[i]]) {
				l.add(book[i]);
				use[book[i]] = true;
			}
		}
		int cost = 0;
		for (int i = 0; i < m; i++) {
			int j = 0;
			while (l.get(j) != book[i]) {
				cost += w[l.get(j)];
				j++;
			}
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(l.remove(j));
			for (Integer ele : l) tmp.add(ele);
			l.clear();
			for (Integer ele : tmp) l.add(ele);
		}
		System.out.println(cost);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
