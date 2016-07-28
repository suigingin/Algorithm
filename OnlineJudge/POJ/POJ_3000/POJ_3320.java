import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class POJ_3320 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int[] p = new int[N];
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			p[i] = sc.nextInt();
			set.add(p[i]);
		}
		int all = set.size();
		int min = Integer.MAX_VALUE / 2;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int s = 0, t = 0; t < N; t++) {
			if (map.containsKey(p[t])) map.put(p[t], map.get(p[t]) + 1);
			else map.put(p[t], 1);
			while (s <= t && map.size() == all) {
				min = Math.min(min, t - s + 1);
				int cnt = map.get(p[s]) - 1;
				map.put(p[s], cnt);
				if (cnt == 0)  map.remove(p[s]);
				s++;
			}
		}
		System.out.println(min);
	}

	public static void main(String[] args) {
		new POJ_3320().run();
	}
}
