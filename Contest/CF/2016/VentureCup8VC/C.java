import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int com = 0;
		int getN = 0;
		int getM = 0;
		for (int i = 1;; i++) {
			if (i % 2 == 0 && i % 6 != 0 && getN < n) getN++;
			if (i % 3 == 0 && i % 6 != 0 && getM < m) getM++;
			if (i % 6 == 0) com++;
			if (getN + getM + com == n + m) {
				System.out.println(i);
				return;
			}
		}
	}

	public static void main(String[] args) {
		new C().run();
	}
}
