import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		if (a == b) {
			System.out.println("infinity");
		} else if (a < b) {
			System.out.println(0);
		} else {
			int m = a - b;
			int cnt = 0;
			for (int i = 1; i * i <= m; i++) {
				if (m % i == 0) {
					if (a % i == b) cnt++;
					if (i == m / i) continue;
					if (a % (m / i) == b) cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
	
	public static void main(String[] args) {
		new B().run();
	}
}
