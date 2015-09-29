import java.util.Arrays;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		Num[] nn = new Num[n];
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			nn[i] = new Num(a, a % 10);
		}
		Arrays.sort(nn);
		for (int i = 0; i < n; i++) {
			int add = 10 - nn[i].mod;
			if (k >= add && nn[i].num + add <= 100) {
				k -= add;
				nn[i].num += add;
				nn[i].mod += add;
			}
		}
		for (int i = 0; i < n; i++) {
			if (k > 0 && nn[i].num < 100) {
				int add = Math.min(k, 100 - nn[i].num);
				nn[i].num += add;
				k -= add;
			}
		}
		int score = 0;
		for (int i = 0; i < n; i++) score += nn[i].num / 10;
		System.out.println(score);
	}

	class Num implements Comparable<Num> {
		int num;
		int mod;

		/**
		 * @param num
		 * @param mod
		 */
		public Num(int num, int mod) {
			super();
			this.num = num;
			this.mod = mod;
		}

		@Override
		public int compareTo(Num arg0) {
			return arg0.mod - this.mod;
		}
	}

	public static void main(String[] args) {
		new C().run();
	}
}
