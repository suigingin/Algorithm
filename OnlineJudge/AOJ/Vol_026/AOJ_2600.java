import java.util.Scanner;

public class AOJ_2600 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();
		int[] wt = new int[W + 1];
		int[] ht = new int[H + 1];
		while (N-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			wt[x - w < 0 ? 0 : x - w]++;
			wt[x + w > W ? W : x + w]--;
			ht[y - w < 0 ? 0 : y - w]++;
			ht[y + w > H ? H : y + w]--;
		}
		for (int i = 1; i < W; i++) {
			wt[i] += wt[i - 1];
		}
		for (int i = 1; i < H; i++) {
			ht[i] += ht[i - 1];
		}
		boolean okW = true;
		boolean okH = true;
		for (int i = 0; i < W; i++) {
			if (wt[i] <= 0) {
				okW = false;
			}
		}
		for (int i = 0; i < H; i++) {
			if (ht[i] <= 0) {
				okH = false;
			}
		}
		System.out.println(okW || okH ? "Yes" : "No");
	}

	public static void main(String[] args) {
		new AOJ_2600().run();
	}
}

