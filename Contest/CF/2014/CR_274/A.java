import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int max = 0;
		max = Math.max(max, (a + b) * c);
		max = Math.max(max, a * (b + c));
		max = Math.max(max, a * b * c);
		max = Math.max(max, a + b + c);

		System.out.println(max);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
