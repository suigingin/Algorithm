import java.util.ArrayList;
import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);

	void run() {
		int k = sc.nextInt();
		if (k % 2 == 0) {
			System.out.println("NO");
			return;
		} else {
			System.out.println("YES");
			if (k == 1) {
				System.out.println("2 1");
				System.out.println("1 2");
				return;
			}
		}
		System.out.println((k * 2 - 1) * 2 + " " + (k * 2 - 1) * k);
		ArrayList<String> l = new ArrayList<String>();
		int leftCnt = k * 2 - 1;
		int half = (leftCnt - 1) / 2;
		for (int i = 2; i < half + 2; i++) {
			l.add(1 + " " + i);
			l.add((leftCnt + 1) + " " + (leftCnt + i));
		}
		for (int i = 2; i < half + 2; i++) {
			for (int j = half + 2; j <= half * 2 + 1; j++) {
				l.add(i + " " + j);
				l.add((leftCnt + i) + " " + (leftCnt + j));
			}
		}
		for (int i = half + 2; i < half * 2 + 1; i += 2) {
			l.add(i + " " + (i + 1));
			l.add((i + leftCnt) + " " + (i + leftCnt + 1));
		}
		l.add(1 + " " + (leftCnt + 1));
		for (String ele : l) System.out.println(ele);
	}

	public static void main(String[] args) {
		new D().run();
	}
}
