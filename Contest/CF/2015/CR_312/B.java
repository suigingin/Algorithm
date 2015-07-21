import java.util.HashMap;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] cnt = new int[1000001];
		HashMap<Integer, Integer> l = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> r = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			cnt[a]++;
			if (!l.containsKey(a)) l.put(a, i);
			r.put(a, i);
		}
		int ans = 0;
		int max = 1;
		int dis = Integer.MAX_VALUE / 2;
		for (int i = 0; i <= 1000000; i++) {
			if (cnt[i] > max || (cnt[i] == max && r.get(i) - l.get(i) + 1 < dis)) {
				ans = i;
				max = cnt[i];
				dis = r.get(i) - l.get(i) + 1;
			}
		}
		System.out.println((l.get(ans) + 1) + " " + (r.get(ans) + 1));
	}

	public static void main(String[] args) {
		new B().run();
	}
}
