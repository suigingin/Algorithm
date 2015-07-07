import java.util.Scanner;

public class No_029 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int res = 0;
		int[] cnt = new int[10];
		while (N-- > 0) {
			cnt[sc.nextInt() - 1]++;
			cnt[sc.nextInt() - 1]++;
			cnt[sc.nextInt() - 1]++;
		}
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			res += cnt[i] / 2;
			cnt[i] -= cnt[i] / 2 * 2;
			sum += cnt[i];
		}
		res += sum / 4;
		System.out.println(res);
	}

	public static void main(String[] args) {
		new No_029().run();
	}
}
