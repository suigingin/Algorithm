import java.util.ArrayList;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);
	int n, cnt, l, r, x;
	int[] c;

	void run() {
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		x = sc.nextInt();
		cnt = 0;
		c = new int[n];
		for (int i = 0; i < n; i++) c[i] = sc.nextInt();
		dfs(0, 0, new ArrayList<Integer>());
		System.out.println(cnt);
	}

	void dfs(int d, int sum, ArrayList<Integer> use) {
		if (d == n) {
			int min = Integer.MAX_VALUE;
			int max = 0;
			for (int i = 0; i < use.size(); i++) {
				if (use.get(i) < min) min = use.get(i);
				if (use.get(i) > max) max = use.get(i);
			}
			if (l <= sum && sum <= r && max - min >= x) cnt++;
			return;
		}
		dfs(d + 1, sum, use);        use.add(c[d]);
		dfs(d + 1, sum + c[d], use); use.remove(use.size() - 1);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
