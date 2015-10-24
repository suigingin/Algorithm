import java.util.HashMap;
import java.util.Scanner;

public class BytelandianGoldCoins {
	Scanner sc = new Scanner(System.in);
	HashMap<Long, Long> memo;

	void run() {
		while (sc.hasNext()) {
			long n = sc.nextInt();
			memo = new HashMap<Long, Long>();
			System.out.println(solve(n));
		}
	}

	long solve(long n) {
		if (n == 0) return 0;
		if (memo.containsKey(n)) return memo.get(n);
		memo.put(n, Math.max(n, solve(n / 2) + solve(n / 3) + solve(n / 4)));
		return memo.get(n);
	}

	public static void main(String[] args) {
		new BytelandianGoldCoins().run();
	}
}
