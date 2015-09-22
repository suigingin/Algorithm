import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		long x = sc.nextLong();
		long[] a = new long[n];
		for(int i = 0; i < n; i++) a[i] = sc.nextLong();

		// 各bitがいくつ立っているか保存
		int[] bitC = new int[63];
		for (int i = 0; i < n; i++) {
			long ai = a[i];
			for (int j = 0; ai > 0; j++, ai >>= 1) {
				if ((ai & 1) == 1) bitC[j]++;
			}
		}

		long ans = 0;
		for (int i = 0; i < n; i++) {
			// a[i]をx^k倍する
			// (x倍すると最上位bitが1桁増えるのでどれか一つに全部かけるのが最適)
			long ob = a[i];
			for (int j = 0; ob > 0; j++, ob >>= 1) {
				if ((ob & 1) == 1) bitC[j]--;
			}
			long add = (long) (a[i] * Math.pow(x, k));
			long tmp = add;
			for (int j = 0; tmp > 0; j++, tmp >>= 1) {
				if ((tmp & 1) == 1) bitC[j]++;
			}

			long res = 0;
			for (int j = 0; j < 63; j++) {
				if (bitC[j] > 0) res += 1L << j;
			}
			ans = Math.max(ans, res);

			// x^k倍していたa[i]のbitを戻す
			for (int j = 0; add > 0; j++, add >>= 1) {
				if ((add & 1) == 1) bitC[j]--;
			}
			ob = a[i];
			for (int j = 0; ob > 0; j++, ob >>= 1) {
				if ((ob & 1) == 1) bitC[j]++;
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new D().run();
	}
}
