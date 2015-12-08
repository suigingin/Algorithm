import java.util.HashMap;
import java.util.Scanner;

public class AOJ_0232 {
	Scanner sc = new Scanner(System.in);

	void run() {
		for (;;) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int Z = sc.nextInt();
			if ((X | Y | Z) == 0) return;
			int[] V = new int[X];
			for (int i = 0; i < X; i++) V[i] = sc.nextInt();
			int M = 5000;
			HashMap<Integer, Info> map = new HashMap<Integer, Info>();
			for (int i = 0; i < Z; i++) {
				int N = sc.nextInt();
				int E = sc.nextInt();
				int A = sc.nextInt();
				map.put(N, new Info(E, A));
			}

			double[][] dp = new double[Y + 1][M + 1];
			dp[0][0] = 1;

			for (int i = 0; i < Y; i++) {
				int go = 0;
				int add = 0;
				if (map.containsKey(i)) {
					Info in = map.get(i);
					if (in.E == 1) go += in.A;
					if (in.E == 2) add += in.A;
					if (in.E == 3) add -= in.A;
				}

				for (int j = 0; j < M; j++) {
					int nextMoney = Math.min(M, Math.max(0, j + add));
					for (int k = 0; k < X; k++) {
						int nextPos = Math.min(Y, i + V[k] + go);
						dp[nextPos][nextMoney] += dp[i][j] / X;
					}
				}
			}
			double ans = 0;
			for (int i = 0; i < M; i++)  ans += i * dp[Y][i];
			System.out.println((int) ans);
		}
	}

	class Info {
		int E;
		int A;

		/**
		 * @param e
		 * @param a
		 */
		public Info(int e, int a) {
			super();
			E = e;
			A = a;
		}
	}

	public static void main(String[] args) {
		new AOJ_0232().run();
	}
}
