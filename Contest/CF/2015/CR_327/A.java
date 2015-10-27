import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		double l = sc.nextDouble();
		double p = sc.nextDouble();
		double q = sc.nextDouble();
		System.out.println(l / (p + q) * p);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
