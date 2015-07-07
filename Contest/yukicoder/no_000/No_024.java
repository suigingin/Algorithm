import java.util.Scanner;

public class No_024 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int[] cnt = new int[10];
		while (N-- > 0) {
			int[] n = { sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt() };
			if (sc.next().equals("YES")) {
				for (int j = 0; j < 4; j++) {
					if (cnt[n[j]] != -1) cnt[n[j]]++;
				}
			} else {
				for (int j = 0; j < 4; j++) {
					cnt[n[j]] = -1;
				}
			}
		}
		int max = -100;
		int maxIndex = 0;
		for (int i = 0; i < 10; i++) {
			if (max < cnt[i]) {
				max = cnt[i];
				maxIndex = i;
			}
		}
		System.out.println(maxIndex);
	}

	public static void main(String[] args) {
		new No_024().run();
	}
}
