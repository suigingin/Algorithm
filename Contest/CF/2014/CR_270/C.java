import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		String[][] name = new String[n][2];
		for (int i = 0; i < n; i++) {
			name[i][0] = sc.next();
			name[i][1] = sc.next();
		}
		int p = sc.nextInt() - 1;
		String pre = name[p][0].compareTo(name[p][1]) < 0 ? name[p][0] : name[p][1];
		for (int i = 1; i < n; i++) {
			p = sc.nextInt() - 1;
			// s <= t
			String s = name[p][0].compareTo(name[p][1]) < 0 ? name[p][0] : name[p][1];
			String t = name[p][0].compareTo(name[p][1]) > 0 ? name[p][0] : name[p][1];
			if (pre.compareTo(s) <= 0)      pre = s;
			else if (pre.compareTo(t) <= 0) pre = t;
			else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	public static void main(String[] args) {
		new C().run();
	}
}
