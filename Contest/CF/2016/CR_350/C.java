import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) map.put(a[i], map.containsKey(a[i]) ? map.get(a[i]) + 1 : 1);

		int m = sc.nextInt();
		int[] b = new int[m];
		int[] c = new int[m];
		for (int i = 0; i < m; i++) b[i] = sc.nextInt();
		for (int i = 0; i < m; i++) c[i] = sc.nextInt();
		Pair[] movie = new Pair[m];

		for (int i = 0; i < m; i++) {
			movie[i]        = new Pair();
			movie[i].id     = i + 1;
			movie[i].first  = map.containsKey(b[i]) ? map.get(b[i]) : 0;
			movie[i].second = map.containsKey(c[i]) ? map.get(c[i]) : 0;
		}
		Arrays.sort(movie);
		System.out.println(movie[0].id);
	}

	class Pair implements Comparable<Pair> {

		int id;
		int first;
		int second;

		@Override
		public int compareTo(Pair arg0) {
			if (this.first == arg0.first) {
				return arg0.second - this.second;
			}
			return arg0.first - this.first;
		}
	}

	public static void main(String[] args) {
		new C().run();
	}
}
