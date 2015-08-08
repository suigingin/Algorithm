import java.util.Scanner;

public class AOJ_0517 {
	Scanner sc = new Scanner(System.in);

	void run() {
		for (;;) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			if ((n | k) == 0) return;
			boolean[] bucket = new boolean[n + 1];
			for (int i = 0; i < k; i++) bucket[sc.nextInt()] = true;
			int max = 0;
			int p1 = 0;
			int p2 = 0;
			for (int i = 1; i <= n; i++) {
				if (bucket[i]) {
					p1++;
					p2++;
				} else if (bucket[0]) {
					int tmp = p1;
					p1 = 0;
					p2 = tmp + 1;
				} else {
					p1 = 0;
					p2 = 0;
				}
				max = Math.max(max, Math.max(p1, p2));
			}
			System.out.println(max);
		}
	}

	public static void main(String[] args) {
		new AOJ_0517().run();
	}
}
