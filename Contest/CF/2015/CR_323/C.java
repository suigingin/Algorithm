import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n * n];
		ArrayList<Integer> res = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n * n; i++) {
			a[i] = sc.nextInt();
			map.put(a[i], map.containsKey(a[i]) ? map.get(a[i]) + 1 : 1);
		}
		Arrays.sort(a);
		for (int i = n * n - 1; res.size() < n; i--) {
			if (map.get(a[i]) <= 0) continue;
			map.put(a[i], map.get(a[i]) - 1);
			for (int j = 0; j < res.size(); j++) {
				int del = gcd(a[i], res.get(j));
				map.put(del, map.get(del) - 2);
			}
			res.add(a[i]);
		}
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < res.size(); i++) out.append(res.get(i) + " ");
		System.out.println(out);
	}

	int gcd(int a, int b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
