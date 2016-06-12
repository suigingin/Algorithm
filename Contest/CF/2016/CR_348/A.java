import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		System.out.println((n / 3) * 2 + (n % 3 > 0 ? 1 : 0));
	}

	public static void main(String[] args) {
		new A().run();
	}
}
