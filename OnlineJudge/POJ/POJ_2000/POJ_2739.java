import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class POJ_2739 {
	Scanner sc = new Scanner(System.in);
	void run() {
		int N = 10000;
		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i * i <= N; i++) {
			if (!isPrime[i]) continue;
			for (int j = i * 2; j <= N; j += i) isPrime[j] = false;
		}
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i <= N; i++) if (isPrime[i]) l.add(i);

		StringBuilder sb = new StringBuilder();

		for (;;) {
			int n = sc.nextInt();
			if (n == 0) break;
			int cnt = 0;
			int sum = 0;
			for (int s = 0, t = 0; t < l.size(); t++) {
				sum += l.get(t);
				while (s <= t && sum >= n) {
					if (sum == n) cnt++;
					sum -= l.get(s);
					s++;
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.print(sb);
	}

	public static void main(String[] args) {
		new POJ_2739().run();
	}
}
