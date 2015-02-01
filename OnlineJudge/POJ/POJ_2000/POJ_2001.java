import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class POJ_2001 {
	Scanner sc = new Scanner(System.in);

	void run() {
		ArrayList<String> l = new ArrayList<String>();
		while (sc.hasNext()) {
			l.add(sc.next());
		}
		for (int i = 0; i < l.size(); i++) {
			String s = l.get(i);
			String match = "";
			int index = 0;
			boolean add = true;
			boolean[] ok = new boolean[l.size()];
			Arrays.fill(ok, true);
			while (add) {
				add = false;
				for (int j = 0; j < l.size(); j++) {
					if (i == j) {
						continue;
					}
					if (ok[j] && index < s.length() && index < l.get(j).length()) {
						if (s.charAt(index) == l.get(j).charAt(index)) {
							add = true;
						} else {
							ok[j] = false;
						}
					}
				}
				if (add) {
					match += s.charAt(index++);
				}
			}
			if (index < s.length()) {
				match += s.charAt(index);
			}
			System.out.println(s + " " + match);
		}
	}

	public static void main(String[] args) {
		new POJ_2001().run();
	}
}
