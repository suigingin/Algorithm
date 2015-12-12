import java.util.HashMap;
import java.util.Scanner;

public class AOJ_2015 {
	Scanner sc = new Scanner(System.in);

	void run() {
		for (;;) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			if ((N | M) == 0) return;
			int[] sumH = new int[N + 1];
			int[] sumW = new int[M + 1];
			for (int i = 1; i <= N; i++) sumH[i] = sumH[i - 1] + sc.nextInt();
			for (int i = 1; i <= M; i++) sumW[i] = sumW[i - 1] + sc.nextInt();
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= M; j++) {
					int v = sumH[i] - sumW[j];
					map.put(v, map.containsKey(v) ? map.get(v) + 1 : 1);
				}
			}
			long ans = 0;
			for (int key : map.keySet()) {
				int val = map.get(key);
				ans += (val * (val - 1)) / 2;
			}
			System.out.println(ans);
		}
	}

	public static void main(String[] args) {
		new AOJ_2015().run();
	}
}
