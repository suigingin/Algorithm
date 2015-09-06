import java.util.ArrayList;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		ArrayList<Integer> first = new ArrayList<Integer>();
		ArrayList<Integer> second = new ArrayList<Integer>();
		long sumF = 0;
		long sumS = 0;
		int score = 0;
		for (int i = 0; i < n; i++) {
			score = sc.nextInt();
			if (score > 0) {
				first.add(score);
				sumF += score;
			} else {
				second.add(score * -1);
				sumS += score * -1;
			}
		}

		if (sumF != sumS) {
			System.out.println(sumF > sumS ? "first" : "second");
		} else {
			for (int j = 0; j < Math.min(first.size(), second.size()); j++) {
				if (first.get(j) != second.get(j)) {
					System.out.println(first.get(j) > second.get(j) ? "first" : "second");
					return;
				}
			}
			if (first.size() == second.size()) System.out.println(score > 0 ? "first" : "second");
			else System.out.println(first.size() > second.size() ? "first" : "second");
		}
	}

	public static void main(String[] args) {
		new B().run();
	}
}
