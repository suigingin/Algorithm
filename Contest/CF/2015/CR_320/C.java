import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		if (b > a) {
			System.out.println(-1);
			return;
		}
		int up = (int) ((a + b) / (2.0 * b));
		System.out.println((a + b) / (2.0 * up));
	}

	public static void main(String[] args) {
		new C().run();
	}
}
