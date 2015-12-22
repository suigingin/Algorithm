import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		double r = sc.nextDouble();
		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();
		double dist = Math.hypot(x1 - x2, y1 - y2);
		System.out.println((int) Math.ceil(dist / (r * 2)));
	}

	public static void main(String[] args) {
		new B().run();
	}
}
