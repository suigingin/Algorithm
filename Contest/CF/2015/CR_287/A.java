import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] a = new int[n][2];
		for (int i = 0; i < n; i++) {
			a[i][0] = sc.nextInt();
			a[i][1] = i + 1;
		}
		Arrays.sort(a, new Comparator<int[]>() {
			public int compare(int[] arg0, int[] arg1) {
				return arg0[0] - arg1[0];
			}
		});
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (a[i][0] <= k) {
				l.add(a[i][1]);
				k -= a[i][0];
			}
		}
		StringBuilder out = new StringBuilder();
		out.append(l.size() + "\n");
		for (int i = 0; i < l.size(); i++) out.append(" " + l.get(i));
		System.out.println(out);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
