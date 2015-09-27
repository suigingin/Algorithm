import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int q = sc.nextInt();
		HashMap<String, String> map = new HashMap<String, String>();
		ArrayList<String> l = new ArrayList<String>();
		ArrayList<String> o = new ArrayList<String>();
		for (int i = 0; i < q; i++) {
			String from = sc.next();
			String to = sc.next();
			map.put(from, to);
			l.add(from);
		}
		for (int i = 0; i < q; i++) {
			if (!map.containsValue(l.get(i))) o.add(l.get(i));
		}

		StringBuilder out = new StringBuilder();
		out.append(o.size() + "\n");
		for (int i = 0; i < o.size(); i++) {
			String s = o.get(i);
			while (map.containsKey(s)) s = map.get(s);
			out.append(o.get(i) + " " + s + "\n");
		}
		System.out.print(out);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
