package CR_315;

import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int T = sc.nextInt();
		int S = sc.nextInt();
		int q = sc.nextInt();
		int cnt = 1;
		S *= q;
		while (S < T) {
			S *= q;
			cnt++;
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new A().run();
	}
}