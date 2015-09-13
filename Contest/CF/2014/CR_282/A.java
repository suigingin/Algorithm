import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		String in = sc.next();
		int digit1 = in.charAt(0) - '0';
		int digit2 = in.charAt(1) - '0';
		int[] num = { 2, 7, 2, 3, 3, 4, 2, 5, 1, 2 };
		System.out.println(num[digit1] * num[digit2]);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
