import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class POJ_2643 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		sc.nextLine();
		Map<String, String> map = new HashMap<String, String>();
		Map<String, Integer> cnt = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			map.put(sc.nextLine(), sc.nextLine());
		}
		int m = sc.nextInt();
		int max = 0;
		sc.nextLine();
		for (int i = 0; i < m; i++) {
			String vote = sc.nextLine();
			cnt.put(vote, cnt.containsKey(vote) ? cnt.get(vote) + 1 : 1);
			if (cnt.get(vote) > max) {
				max = cnt.get(vote);
			}
		}
		boolean tie = false;
		String win = "";
		for (String key : cnt.keySet()) {
			if (cnt.get(key) == max) {
				win = key;
				if (tie) {
					System.out.println("tie");
					return;
				}
				tie = true;
			}
		}
		System.out.println(map.get(win));
	}

	public static void main(String[] args) {
		new POJ_2643().run();
	}
}
