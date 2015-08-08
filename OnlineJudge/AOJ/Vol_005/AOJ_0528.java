import java.util.Scanner;

public class AOJ_0528 {
	Scanner sc = new Scanner(System.in);

	void run() {
		while (sc.hasNext()) {
			String s = sc.next();
			String t = sc.next();
			if (s.length() > t.length()) {
				String tmp = s;
				s = t;
				t = tmp;
			}
			t += "_" + t;
			int max = 0;
			for (int i = 0; i < t.length(); i++) {
				int match = 0;
				for (int j = 0; j < s.length() && j + i < t.length(); j++) {
					if (s.charAt(j) == t.charAt(j + i)) match++;
					else  match = 0;
					max = Math.max(max, match);
				}
			}
			System.out.println(max);
		}
	}

	public static void main(String[] args) {
		new AOJ_0528().run();
	}
}
