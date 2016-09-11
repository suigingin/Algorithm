import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		char[] c = sc.next().toCharArray();
		int R = 0;
		int L = 0;
		int U = 0;
		int D = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'R') R++;
			else if (c[i] == 'L') L++;
			else if (c[i] == 'U') U++;
			else if (c[i] == 'D') D++;
		}
		int need1 = Math.abs(R - L);
		int need2 = Math.abs(U - D);
		System.out.println((need1 + need2) % 2 == 0 ? (need1 + need2) / 2 : -1);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
