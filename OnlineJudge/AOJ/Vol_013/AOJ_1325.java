import java.util.Scanner;

public class AOJ_1325 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int T = sc.nextInt();
		L: while (T-- > 0) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			for (int m = 0; m <= 150; m++) {
				for (int n = 0; n <= 150; n++) {
					if (m == 0 && n == 0) continue;
					int mul = m * m + n * n;
					int a = m * p + n * q;
					int b = m * q - n * p;
					if (a % mul == 0 && b % mul == 0) {
						if (isDivide(m, n, p, q)) {
							System.out.println("C");
							continue L;
						}
					}
				}
			}
			System.out.println("P");
		}
	}

	boolean isDivide(int m, int n, int p, int q) {
		if (m == 1 && n == 0
			|| m == 0  && n == 1
			|| m == -1 && n == 0 
			|| m == 0  && n == -1 
			|| m == p  && n == q 
			|| m == -q && n == p 
			|| m == -p && n == -q 
			|| m == q  && n == -p)
			return false;
		else return true;
	}

	public static void main(String[] args) {
		new AOJ_1325().run();
	}
}
