import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		double d = sc.nextDouble();
		double h = sc.nextDouble();
		double v = sc.nextDouble();
		double e = sc.nextDouble();

		double S = d / 2 * d / 2 * Math.PI;
		double decS = v / S;
		if (decS - e <= 0) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			System.out.println(h / (decS - e));
		}
	}

	public static void main(String[] args) {
		new A().run();
	}
}
