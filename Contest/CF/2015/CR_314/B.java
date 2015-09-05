import java.util.HashSet;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();
		int res = 0;
		int empty = 0;
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			int r = sc.nextInt();
			if (s.equals("+")) {
				if (empty == 0) res++;
				else empty--;
				set.add(r);
			} else {
				if (!set.contains(r)) res++;
				empty++;
			}
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
