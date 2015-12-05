import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AOJ_0580 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int K = sc.nextInt();
		long[] xS = new long[N];
		long[] yS = new long[N];
		long[] zS = new long[N];
		long[] xT = new long[N];
		long[] yT = new long[N];
		long[] zT = new long[N];
		ArrayList<Long> X = new ArrayList<Long>();
		ArrayList<Long> Y = new ArrayList<Long>();
		ArrayList<Long> Z = new ArrayList<Long>();
		for (int i = 0; i < N; i++) {
			xS[i] = sc.nextLong();
			yS[i] = sc.nextLong();
			zS[i] = sc.nextLong();
			xT[i] = sc.nextLong();
			yT[i] = sc.nextLong();
			zT[i] = sc.nextLong();
			X.add(xS[i]); X.add(xT[i]);
			Y.add(yS[i]); Y.add(yT[i]);
			Z.add(zS[i]); Z.add(zT[i]);
		}

		Collections.sort(X);
		Collections.sort(Y);
		Collections.sort(Z);

		long ans = 0;
		for (int i = 0; i < N * 2 - 1; i++) {
			for (int j = 0; j < N * 2 - 1; j++) {
				for (int k = 0; k < N * 2 - 1; k++) {
					int overlap = 0;
					// x,y,zそれぞれ点が存在する区間において
					// その区間を被覆する辺が何本あるか調べる
					for (int l = 0; l < N; l++) {
						if (xS[l] <= X.get(i) && X.get(i + 1) <= xT[l]
								&& yS[l] <= Y.get(j) && Y.get(j + 1) <= yT[l]
								&& zS[l] <= Z.get(k) && Z.get(k + 1) <= zT[l]) {
							overlap++;
						}
					}
					if (overlap >= K) {
						ans += (X.get(i + 1) - X.get(i)) * (Y.get(j + 1) - Y.get(j)) * (Z.get(k + 1) - Z.get(k));
					}
				}
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new AOJ_0580().run();
	}
}
