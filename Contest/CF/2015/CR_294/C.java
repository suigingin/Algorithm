import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		if (n * 2 < m) {
			System.out.println(n);
		} else if (m * 2 < n) {
			System.out.println(m);
		} else {
			System.out.println((n + m) / 3);
		}
	}

	public static void main(String[] args) {
		new C().run();
	}
}
