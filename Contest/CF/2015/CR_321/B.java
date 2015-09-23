import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int d = sc.nextInt();
		ArrayList<Pair> list = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) list.add(new Pair(sc.nextInt(), sc.nextInt()));
		Collections.sort(list);
		long[] sum = new long[n];
		long[] m = new long[n];
		sum[0] = list.get(0).frined;
		m[0] = list.get(0).money;
		for (int i = 1; i < n; i++) {
			sum[i] = sum[i - 1] + list.get(i).frined;
			m[i] = list.get(i).money;
		}
		long max = 0;
		for (int i = 0, upper = 0; i < n; i++) {
			long f = list.get(i).frined;
			while (upper + 1 < n && m[upper + 1] - m[i] < d) {
				upper++;
				f = (i == 0) ? sum[upper] : sum[upper] - sum[i - 1];
			}
			max = Math.max(max, f);
		}
		System.out.println(max);
	}

	class Pair implements Comparable<Pair> {

		int money;
		int frined;

		public Pair(int money, int frined) {
			super();
			this.money = money;
			this.frined = frined;
		}

		@Override
		public int compareTo(Pair arg0) {
			if (this.money == arg0.money) {
				return this.frined - arg0.frined;
			}
			return this.money - arg0.money;
		}
	}

	public static void main(String[] args) {
		new B().run();
	}
}
