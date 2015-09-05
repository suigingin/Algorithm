import java.util.Scanner;
import java.util.TreeSet;

public class D {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int a = sc.nextInt();
		int m = sc.nextInt();
		int[] x = new int[m];
		for (int i = 0; i < m; i++) x[i] = sc.nextInt() - 1;
		int ships = (n + 1) / (a + 1);
		TreeSet<Integer> out = new TreeSet<Integer>();
		out.add(-1);
		out.add(n);
		for (int i = 0; i < m; i++) {
			int upper = out.higher(x[i]);
			int lower = out.lower(x[i]);
			ships -= (upper - lower) / (a + 1);
			ships += (x[i] - lower) / (a + 1);
			ships += (upper - x[i]) / (a + 1);
			out.add(x[i]);
			if (ships < k) {
				System.out.println(i + 1);
				return;
			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) {
		new D().run();
	}
}
