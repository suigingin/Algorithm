import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				String s = sc.next();
				if (s.equals("C") || s.equals("M") || s.equals("Y")) {
					System.out.println("#Color");
					return;
				}
			}
		}
		System.out.println("#Black&White");
	}

	public static void main(String[] args) {
		new A().run();
	}
}
