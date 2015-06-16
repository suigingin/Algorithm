import java.util.Arrays;
import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		Info[] info = new Info[n];
		for (int i = 0; i < n; i++) info[i] = new Info(sc.nextInt(), sc.nextInt());
		Arrays.sort(info);
		for (int i = 0; i < n - 1; i++) {
			if (info[i].quality > info[i + 1].quality) {
				System.out.println("Happy Alex");
				return;
			}
		}
		System.out.println("Poor Alex");
	}

	class Info implements Comparable<Info> {
		int price;
		int quality;

		public Info(int price, int quality) {
			super();
			this.price = price;
			this.quality = quality;
		}

		@Override
		public int compareTo(Info arg0) {
			return this.price - arg0.price;
		}
	}

	public static void main(String[] args) {
		new A().run();
	}
}
