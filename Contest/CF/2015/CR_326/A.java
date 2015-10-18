import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int sum = 0;
		int min = Integer.MAX_VALUE / 2;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int p = sc.nextInt();
			min = Math.min(min, p);
			sum += a * min;
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
