import java.util.HashMap;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		long ans = 0;
		HashMap<Integer, Long> one = new HashMap<Integer, Long>();
		HashMap<Integer, Long> two = new HashMap<Integer, Long>();
		for (int i = 0; i < n; i++) {
			if (a[i] % k == 0 && two.containsKey(a[i] / k)) {
				ans += two.get(a[i] / k);
			}
			if (a[i] % k == 0 && one.containsKey(a[i] / k)) {
				two.put(a[i], two.containsKey(a[i]) ? two.get(a[i]) + one.get(a[i] / k) : one.get(a[i] / k));
			}
			one.put(a[i], one.containsKey(a[i]) ? one.get(a[i]) + 1 : 1);
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
