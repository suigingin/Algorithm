import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		long n = sc.nextLong();
		System.out.println(n % 2 == 0 ? n / 2 : -(n + 1) / 2);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
