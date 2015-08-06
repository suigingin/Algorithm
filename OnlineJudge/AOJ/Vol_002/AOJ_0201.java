import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AOJ_0201 {
	Scanner sc = new Scanner(System.in);

	void run() {
		for (;;) {
			int n = sc.nextInt();
			if (n == 0) return;
			HashMap<String, Integer> stoi = new HashMap<String, Integer>();
			for (int i = 0; i < n; i++) stoi.put(sc.next(), sc.nextInt());

			int m = sc.nextInt();
			HashMap<String, ArrayList<String>> mix = new HashMap<String, ArrayList<String>>();
			for (int i = 0; i < m; i++) {
				String s = sc.next();
				int o = sc.nextInt();
				ArrayList<String> l = new ArrayList<String>();
				for (int j = 0; j < o; j++) l.add(sc.next());
				mix.put(s, l);
			}

			for (int i = 0; i < m; i++) {
				for (String key : mix.keySet()) {
					int cost = 0;
					for (int j = 0; j < mix.get(key).size(); j++) cost += stoi.get(mix.get(key).get(j));
					if (cost < stoi.get(key)) stoi.put(key, cost);
				}
			}
			System.out.println(stoi.get(sc.next()));
		}
	}

	public static void main(String[] args) {
		new AOJ_0201().run();
	}
}
