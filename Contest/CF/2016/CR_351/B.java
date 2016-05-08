import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		if (m == 0) {
			System.out.println(n - 1);
			return;
		}
		List<Integer> s = new ArrayList<>();
		List<Integer> t = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			if (v < u) {
				s.add(v);
				t.add(u);
			} else {
				s.add(u);
				t.add(v);
			}
		}
		Collections.sort(s);
		Collections.sort(t);
		System.out.println(s.get(s.size() - 1) >= t.get(0) ? 0 : t.get(0) - s.get(s.size() - 1));
	}

	public static void main(String[] args) {
		new B().run();
	}
}
