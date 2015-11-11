import java.util.Scanner;

public class POJ_3276 {
	Scanner sc = new Scanner(System.in);
	int N;
	int[] a;

	void run() {
		N = sc.nextInt();
		a = new int[N];
		for (int i = 0; i < N; i++) a[i] = sc.next().equals("B") ? 1 : 0;
		int min = Integer.MAX_VALUE;
		int k = 0;
		for (int K = 1; K <= N; K++) {
			int res = check(K);
			if (res >= 0 && res < min) {
				min = res;
				k = K;
			}
		}
		System.out.println(k + " " + min);
	}

	int check(int K) {
		int cnt = 0;
		int[] r = new int[N];
		int reverse = 0;
		for (int i = 0; i < N; i++) {
			// i-Kに反転させていたとしたら、K離れたら反転を戻す
			if (i - K >= 0) reverse -= r[i - K];
			if ((a[i] == 1 && reverse % 2 == 0) || (a[i] == 0 && reverse % 2 == 1)) {
				cnt++;
				reverse++;
				r[i]++;
			}
		}
		if (r[N - K] > 0) reverse--;
		return reverse > 0 ? -1 : cnt;
	}

	public static void main(String[] args) {
		new POJ_3276().run();
	}
}
