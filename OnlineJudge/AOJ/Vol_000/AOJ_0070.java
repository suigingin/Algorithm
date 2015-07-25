import java.util.Scanner;

public class AOJ_0070 {
	Scanner sc = new Scanner(System.in);
	int[][] table;
	boolean[] use;

	void run() {
		table = new int[11][331];
		use = new boolean[10];
		make(0, 0);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			System.out.println((n > 10 || s > 330) ? 0 : table[n][s]);
		}
	}

	void make(int depth, int sum) {
		table[depth][sum]++;
		if (depth == 10) return;
		for (int i = 0; i < 10; i++) {
			if (use[i]) continue;
			use[i] = true;
			make(depth + 1, sum + i * (depth + 1));
			use[i] = false;
		}
	}

	public static void main(String[] args) {
		new AOJ_0070().run();
	}
}
