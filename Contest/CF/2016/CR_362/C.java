import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);
	Map<Long, Long> map = new HashMap<>();

	void run() {
		int q = sc.nextInt();
		StringBuilder o = new StringBuilder();
		while (q-- > 0) {
			long x = sc.nextLong();
			long v = sc.nextLong();
			long u = sc.nextLong();
			long common_parent = getCommonParent(v, u);
			if (x == 1) {
				long w = sc.nextLong();
				updateCost(common_parent, v, w);
				updateCost(common_parent, u, w);
			} else {
				o.append(getCost(common_parent, v) + getCost(common_parent, u) + "\n");
			}
		}
		System.out.print(o);
	}

	long getCommonParent(long a, long b) {
		while (a != b) {
			if (a > b) a /= 2;
			else b /= 2;
		}
		return a;
	}

	void updateCost(long p, long node, long w) {
		while (node != p) {
			if (!map.containsKey(node)) map.put(node, 0L);
			map.put(node, map.get(node) + w);
			node /= 2;
		}
	}

	long getCost(long p, long node) {
		long res = 0;
		while (node != p) {
			if (!map.containsKey(node)) map.put(node, 0L);
			res += map.get(node);
			node /= 2;
		}
		return res;
	}

	public static void main(String[] args) {
		new C().run();
	}
}
