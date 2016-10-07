import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= 100; i++) {
			min = Math.min(min, Math.abs(i - a) + Math.abs(i - b) + Math.abs(i - c));
		}
		System.out.println(min);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
