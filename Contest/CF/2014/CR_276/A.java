import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);
	void run() {
		long a = sc.nextLong();
		long m = sc.nextLong();
		for (int i = 0; i < 1000000; i++) {
			if (a % m == 0) {
				System.out.println("Yes");
				return;
			}
			a += a % m;
		}
		System.out.println("No");
	}

	public static void main(String[] args) {
		new A().run();
	}
}
