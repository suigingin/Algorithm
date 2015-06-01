import java.util.HashMap;
import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		HashMap<Integer, Long> res = new HashMap<Integer, Long>();
		HashMap<Integer, Long> pre = new HashMap<Integer, Long>();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			HashMap<Integer, Long> now = new HashMap<Integer, Long>();
			now.put(num, 1L);
			for (int ele : pre.keySet()) {
				long cnt = pre.get(ele);
				int key = gcd(num, ele);
				now.put(key, now.containsKey(key) ? now.get(key) + cnt : cnt);
			}
			for (int ele : now.keySet()) {
				res.put(ele, res.containsKey(ele) ? res.get(ele) + now.get(ele) : now.get(ele));
			}
			pre = now;
		}

		StringBuilder ans = new StringBuilder();
		int q = sc.nextInt();

		while (q-- > 0) {
			int x = sc.nextInt();
			ans.append((res.containsKey(x) ? res.get(x) : 0) + "\n");
		}
		System.out.print(ans);
	}

	int gcd(int a, int b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}

	public static void main(String[] args) {
		new D().run();
	}
}
