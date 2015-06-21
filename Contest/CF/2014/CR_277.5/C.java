import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int m = sc.nextInt();
		int s = sc.nextInt();
		if (m * 9 < s || (m > 1 && s == 0)) {
			System.out.println(-1 + " " + -1);
			return;
		}
		StringBuilder max = new StringBuilder();
		StringBuilder min = new StringBuilder();
		int ss = s;
		for (int i = 0; i < m; i++) {
			if (ss >= 9) {
				max.append(9);
				ss -= 9;
			} else {
				max.append(ss);
				ss = 0;
			}
		}
		ss = s;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j <= 9; j++) {
				if (i == 0 && j == 0 && s != 0) continue;
				if (ss - j <= (m - i - 1) * 9) {
					min.append(j);
					ss -= j;
					break;
				}
			}
		}
		System.out.println(min + " " + max);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
