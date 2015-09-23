import java.util.HashMap;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < m; i++) {
			String s = sc.next();
			String t = sc.next();
			map.put(s, t);
		}
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String k = sc.next();
			String v = map.get(k);
			if (k.length() == v.length()) out.append((map.containsKey(k) ? k : v) + " ");
			else                          out.append((k.length() < v.length() ? k : v) + " ");
		}
		System.out.println(out);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
