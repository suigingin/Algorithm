import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		ArrayList<Data> set = new ArrayList<Data>();
		for (int i = 0; i < n * 2 - 1; i++) {
			for (int j = 0; j < i + 1; j++) {
				set.add(new Data(sc.nextInt(), i + 2, j + 1));
			}
		}
		Collections.sort(set);
		int[] team = new int[n * 2];
		for (Data ele : set) {
			if (team[ele.p2 - 1] == 0 && team[ele.p1 - 1] == 0) {
				team[ele.p2 - 1] = ele.p1;
				team[ele.p1 - 1] = ele.p2;
			}
		}

		StringBuilder out = new StringBuilder();
		for (int i = 0; i < n * 2; i++) {
			out.append(team[i] + " ");
		}
		System.out.println(out);
	}

	class Data implements Comparable<Data> {
		int strength;
		int p1;
		int p2;

		public Data(int strength, int p1, int p2) {
			super();
			this.strength = strength;
			this.p1 = p1;
			this.p2 = p2;
		}

		@Override
		public int compareTo(Data arg0) {
			return arg0.strength - this.strength;
		}
	}

	public static void main(String[] args) {
		new B().run();
	}
}
