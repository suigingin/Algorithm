import java.util.Arrays;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		Pair[] p = new Pair[n];
		for (int i = 0; i < n; i++) p[i] = new Pair(i + 1, sc.nextInt());
		Arrays.sort(p);
		StringBuilder operation = new StringBuilder();
		int cnt = 0;
		while (k-- > 0 && p[n - 1].height - p[0].height > 1) {
			p[n - 1].height--;
			p[0].height++;
			operation.append(p[n - 1].num + " " + p[0].num + "\n");
			Arrays.sort(p);
			cnt++;
		}
		operation.insert(0, p[n - 1].height - p[0].height + " " + cnt + "\n");
		System.out.print(operation);
	}

	class Pair implements Comparable<Pair> {

		int num;
		int height;

		public Pair(int num, int height) {
			super();
			this.num = num;
			this.height = height;
		}

		@Override
		public int compareTo(Pair arg0) {
			return this.height - arg0.height;
		}
	}

	public static void main(String[] args) {
		new B().run();
	}
}
