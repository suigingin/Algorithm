import java.util.Scanner;

public class No_236 {
	Scanner sc = new Scanner(System.in);

	void run() {
		double A = sc.nextDouble();
		double B = sc.nextDouble();
		double X = sc.nextDouble();
		double Y = sc.nextDouble();

		if (X * (B / A) <= Y) System.out.println(X + X * (B / A));
		else System.out.println(Y + Y * (A / B));
	}

	public static void main(String[] args) {
		new No_236().run();
	}
}
