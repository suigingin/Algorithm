import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int cost = 0;
		while (n > 0) {
			if (n - m >= 0) {
				cost += Math.min(b, a * m);
				n -= m;
			} else {
				cost += Math.min(b, a * n);
				n = 0;
			}
		}
		System.out.println(cost);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
